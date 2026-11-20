# Build and testing

Tags: see `../START_HERE.md`. `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`. No credentials or keys are in this document or package.

## 1. Native prototype build (this repo)
- **System:** Gradle 8.13, AGP 8.13.2, Kotlin 2.3.0, Compose BOM 2026.05.00, Haze 1.7.2, `compileSdk 36`, `targetSdk 36`, `minSdk 31`, app id `com.aeruno.nativeprototype` [V `docs/VERSIONS.md`, `app/build.gradle.kts`, `gradle/libs.versions.toml`]. There is no Gradle wrapper in the repo; CI installs Gradle 8.13.
- **CI:** `.github/workflows/build.yml` ("Build debug APK") runs on push to `main` (ignoring `**.md`, `docs/**`, `update.zip`) and manually: guard that no key/secret file names are committed, JDK 17, Android platform 36, `gradle --no-daemon assembleDebug`, checks the APK (app id, minSdk with `aapt2`) and uploads artifact **`aeruno-native-debug-apk`** [V]. Debug only, no secrets, no release signing. Every build uses a fresh debug key, so the previous prototype must be uninstalled before installing the next.
- **Delivery mechanism:** the owner uploads a file named `update.zip` to the repo root; `.github/workflows/apply-update.yml` unpacks it (skipping anything under `.github/` and refusing key-like file names), commits it with `[skip ci]`, deletes the zip and starts the build [V].
- **Install:** download the artifact from the Actions run, extract, install the APK (uninstall the old prototype first).
- **Status:** run #4 (N01) was green and installed [D]. The N03 build was confirmed by the owner [D]. No build result is recorded for the N04 files [U].

## 2. Legacy build (verified from `LEGACY/.github/workflows/build.yml`)
Workflow "Build APK": triggers on push (ignoring `update.zip`, `docs/**`, `README.md`) and manual dispatch with input `app_id` (default `com.arya.fit3`).
1. Job `test`: `node tests/store.test.js` (**blocks** the build).
2. Job `browser-test` (`continue-on-error`): installs Playwright, runs `python tests/browser_test.py`.
3. Job `build` (needs `test`): copy `signing/debug.keystore` and check its SHA-256 against `signing/EXPECTED_SHA256.txt`; `python3 tools/check-web.py`; compute `VERSION_CODE` = minutes since 1970; write `web/js/build-info.js`; `npm install` (no lockfile); `npx cap add android && npx cap sync android`; set versionCode/versionName (`1.<run>`)/applicationId with `sed`; `python3 tools/patch_signing.py`; `bash tools/android-setup.sh` (copies `native/java` into `com/arya/fit/`, splash, icons, patches manifest and widgets); `./gradlew assembleDebug`; verify with `apksigner` that the signature matches the expected fingerprint and with `aapt2` that package and versionCode match; copy to `Arya-Fit-build<run>.apk`; upload artifact **`arya-fit-apk`**.
4. `apply-update.yml`: unpacks `update.zip` into the repo including workflow files when the secret `ARYA_PAT` exists, honours `DELETE.txt`, commits, starts the build [V first lines]. (Secret *names* appear in the workflows; no secret values are in the source.)
- Last known good: **Build APK #128**, commit `c2009d6`, versionCode 29913562, `Arya-Fit-build128.apk` [D `LEGACY/docs/CURRENT.md`]. Not re-run by the handoff author [U].
- Toolchain details (Capacitor 6, Node 20, JDK 17) from the workflow and `package.json` [V]. The Gradle/AGP versions come from Capacitor 6's generated template at build time and are not pinned in the repo [I].

## 3. Test frameworks and coverage
| Suite | Count | Run in CI? | Run by the handoff author? |
|---|---|---|---|
| Node tests `LEGACY/tests/*.test.js` | 16 | Only `store.test.js` (required) | **All 16 passed** in a sandbox [S] |
| Python + Playwright UI tests `LEGACY/tests/*_test.py` | 34 | Only `browser_test.py` (non-blocking) | **No** (Playwright not installed in the sandbox) [U] |
| Java test `LEGACY/tests/NotifTextTest.java` | 1 | No | No |
| `LEGACY/tools/check-web.py` | 1 | Yes | Passed: "web check ok. exercise pictures: 62" [S] |
| GPS simulator `LEGACY/tests/gps_sim.js` | helper | No | No |
| Native prototype tests | none | no | n/a |
Notes: Pure engines (`plangen`, `coachcalc`, `levelcalc`, `retest`, `runcalc`, `gpx`, `exdb`, `loads`, `nudges`, `weather`, `store`) have Node tests; GPS/background services, steps, widgets, notifications and native glue have **no automated tests**. `boot_ui_test.py` has a known timing flake on slow machines [D]. Test helpers: `LEGACY/tools/run-node-tests.sh`, `run-ui-tests.sh`, `qa-report.py`.

## 4. Android compatibility
- Prototype: minSdk 31 (Android 12+ real blur), target 36; owner's phone runs Android 16 [O/D].
- Legacy: min/target SDK come from Capacitor 6's template (not set in repo scripts) [V absence in `tools/`]; foreground-service types `location` and `health` and the permissions in `tools/patch-manifest.sh` are declared (inventory in `LEGACY/docs/PERMISSIONS.md`). Behaviour on Android 14 to 16 foreground-service rules is **untested** [U].
- Owner's device: OnePlus Nord CE5, 8 GB, high refresh rate [D `AGENTS.md`].

## 5. Device testing requirements
- Prototype: owner installs the APK and checks by eye; **no frame-time, battery or thermal measurement exists**. Planned method (never executed): `FrameMetrics` via `Window.OnFrameMetricsAvailableListener`, scripted scroll, `AGENTS.md` section 6/9 (cards N05 to N07).
- Legacy: `LEGACY/docs/DEVICE_TEST.md` is a 30-minute checklist (backup round trip, free run with screen locked, run while using another app, GPS loss, location refused, steps after reboot, notifications ...). **All result columns are blank** [V].

## 6. Known untested functionality (summary)
Background GPS, steps after reboot, hidden step notification, backup round trip on device, widgets, notifications under Doze, N04 blur build and look, any performance of any effect. See `KNOWN_ISSUES.md`.
