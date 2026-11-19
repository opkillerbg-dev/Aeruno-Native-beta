# Legacy baseline (N00)

Written 2026-11-19 for card N00. Purpose: record what the legacy AERUNO / Arya Fit app is, so the native prototype is judged against facts and not memory.

**Evidence tags. Every bullet and table row below carries exactly one.**
- `[V]` Verified: read in a file of the supplied legacy zip (`Arya-Fit-app-main.zip`, repo state v150 plus two CI additions made 2026-11-18). The file is named in the line.
- `[S]` Verified in the coding sandbox: a command or test was actually run there. Says nothing about the real phone.
- `[O]` From the owner: a screenshot or a statement in chat. Not re-checked by the AI.
- `[U]` Unverified: not checked, never run on a device, or only assumed.

Scope limits: this is a read-through, not a code audit. "Present in a file" never means "works on the phone". Nothing here was run on a phone.

## 1. The native prototype repo (what N00 had to confirm)

| Check | Result | Tag |
|---|---|---|
| Repo is `opkillerbg-dev/Aeruno-Native-beta`, public, default branch `main` | Seen on the repo page on 2026-11-19 | [V] |
| Repo holds one commit and one file, `README.md`, which has no text | Seen in the repo page file list | [V] |
| So it is the native prototype repo and is empty, not the legacy app | Follows from the file list and name; legacy repo is `Arya-Fit-app` | [V] |
| Legacy repo name `opkillerbg-dev/Arya-Fit-app` | Seen in the owner's Actions screenshot | [O] |
| No Gradle files, no workflows, no docs in the native repo | Follows from the one-file list | [V] |
| Branches other than `main`, tags, releases, open issues, Actions settings | The branches page could not be opened from the AI's tools | [U] |
| Chosen temporary app id `com.aeruno.nativeprototype` does not clash with anything in the repo | No code exists, so nothing can clash; the owner has not yet approved the id | [V] |

## 2. Identity and build of the legacy app

- Public name AERUNO; internal codename `arya` / `ax-` / `aryaApp2`, which must never be renamed or user data is lost. Source: `docs/CURRENT.md`. [V]
- Installed app id is `com.arya.fit3`; `capacitor.config.json` appId `com.arya.fit` is only the Java namespace. Source: `docs/CURRENT.md`, `capacitor.config.json`. [V]
- Latest build the owner showed: Build APK #133, package `com.arya.fit3`, signing key matches the expected SHA-256, test / browser-test / build all green, APK 7.44 MB. [O]
- Every APK is signed with a debug key kept in the legacy repo (`signing/debug.keystore`). Source: `docs/CURRENT.md`. [V]
- Wrapper: Capacitor 6 (`@capacitor/android`, core, local-notifications, filesystem, share, haptics, status-bar, app) plus `@capacitor-community/background-geolocation`. Source: `package.json`. [V]
- Web app is plain HTML, CSS and ES5 JavaScript, no framework, no build step. Source: `docs/CURRENT.md`. [V]
- CI builds on Node 20 and Java 17 with `npx cap add android`, patch scripts in `tools/`, then a Gradle debug build. Source: `.github/workflows/build.yml`. [V]

## 3. Size

| Item | Count | Tag |
|---|---|---|
| `web/js/core` | 15 files, 1,123 lines | [V] |
| `web/js/features` | 34 files, 4,188 lines | [V] |
| `web/js/ui` | 17 files, 1,409 lines (many lines are very long, so line counts understate the code) | [V] |
| `native/java` | 15 Java files, 2,335 lines | [V] |
| `web/` total on disk | 4.7 MB; `native/` 1.0 MB | [V] |
| Exercise pictures | 62 `.webp` files in `web/images/exercises`, plus `anatomy` and `exercise-masks` folders | [V] |
| Number of distinct exercises in the library | Not counted | [U] |

## 4. Feature areas (what exists in files)

| Area | Evidence (file) | Tag |
|---|---|---|
| Five tabs in V1: Today, Plan, Move, Progress, Me | `docs/CURRENT.md` | [V] |
| Plan engine: profile in, plan out, pure logic that also runs in node | `web/js/features/plangen.js`, `tests/plangen.test.js` | [V] |
| Plan engine tests pass | 16 node test files all passed on 2026-11-18 (node 22) | [S] |
| "Build my plan" builder (3 steps, validated) | `web/js/features/builder.js` | [V] |
| Exercise library with pictures, and Swap (same-muscle alternatives, non-destructive) | `exdb.js`, `library.js`, `swap.js` | [V] |
| 1-tap set logging, progression hint, PR pills, deload hint | `progression.js` | [V] |
| Gym loads in kg per set | `loads.js` | [V] |
| Best efforts and PRs for runs | `prs.js` | [V] |
| Readiness score 0 to 100 that adjusts the plan, with override | `readiness.js` | [V] |
| 4-week retest logic | `retest.js` | [V] |
| "Smart week" coach with tested rules | `coach.js`, `coachcalc.js` | [V] |
| Hands-free workout player (picture strip, set counter, rest timer, voice cues, wake lock) | `handsfree.js`, `timers-run.js` | [V] |
| Voice cues through Android text-to-speech, selectable engine and speed | `voice.js` | [V] |
| Running: calculations, live map, route map, run card, summary, GPX export | `runcalc.js`, `livemap.js`, `routemap.js`, `runcard.js`, `runsummary.js`, `gpx.js`, `run-extras.js` | [V] |
| Steps and progress | `steps-progress.js`, `native/java/StepsPlugin.java` | [V] |
| Home-screen widgets: Today, Steps, Combo | `TodayWidgetProvider`, `StepsWidgetProvider`, `ComboWidgetProvider` | [V] |
| Run weather card from Open-Meteo (free, no key) | `weather.js` | [V] |
| Reminders and nudges | `nudges.js`, `NotifKit.java` | [V] |
| App icon switching | `appicon.js`, `AppIconPlugin.java` | [V] |
| Backup export and import, plus auto sync to a user-chosen file (Google Drive or any folder) through the Android document picker | `backup.js`, `data-io.js`, `sync.js`, `SyncFilePlugin.java` | [V] |
| Onboarding with a Starter plan for new installs | `onboard.js`, `onboard-entry.js`, `docs/CURRENT.md` | [V] |
| Settings, help, profile | `ui/settings.js`, `ui/help.js`, `core/profile.js` | [V] |
| Optional "New look (beta)" (V2) | `ui/v2-*.js`, `web/css/v2/`, `docs/archive/v2/` | [V] |
| The 34 browser (Playwright) tests for these screens pass | Final run on 2026-11-18, all 34 passed; `boot_ui_test` failed once under load before that | [S] |
| One Java unit test file, `NotifTextTest.java`, exists in `tests/` | Never compiled or run | [U] |

## 5. Android native side

- Permissions found in `tools/` and `native/` files: fine, coarse and background location; activity recognition; foreground service plus its health and location types; post notifications; receive boot completed; ignore battery optimizations; schedule exact alarm; vibrate; wake lock. The manifest itself is generated at build time. [V]
- Components: `RunService` (location foreground service), `StepsPlugin` with a service and a boot receiver, launcher activity aliases, three widget providers, `SyncFilePlugin`, `VoiceKit`, `WidgetKit`. [V]
- Native Java edits since v141 were never compiled by an assistant; only a CI build tests them. Source: `docs/CURRENT.md`. [V]
- Whether background GPS, locked-screen runs, step counting after reboot, midnight rollover, hidden step notification and reminder delivery work on a real phone. Source: `docs/CURRENT.md`, `docs/DEVICE_TEST.md` (a pending checklist). [U]

## 6. Data and export (for a later migration, not for this prototype)

- Data lives in browser storage under keys starting `aryaApp2`; the store keeps a daily copy (`.bak`), a copy before a migration (`.premig`), a damaged file as evidence (`.bad`) and a copy before an import (`.preimport`). Source: `web/js/core/store.js`. [V]
- Current data schema version is 2, with an ordered migration list. Source: `store.js` (`AXSCHEMA=2`). [V]
- Export is one JSON file named `aeruno-backup-<date>-<time>.json`. Top-level fields seen: `app` ("arya-28day-tracker"), `version` (2), `schema`, `exported` (ISO time), `active`, `meta`, `prefs`, `profile`, `plans` (per plan: plan, progress, schedMap, workoutEdits and more). Source: `web/js/core/data-io.js`. [V]
- Import refuses a backup from a newer schema and snapshots current data first. Source: `data-io.js`. [V]
- Whether the export also contains run history, GPS routes and step history: not checked. [U]
- Whether an export then import round trip works on the phone (checklist item D1). [U]

## 7. Look and performance history

- Fonts bundled in `web/fonts`: Big Shoulders Display (900), Instrument Serif (italic), Inter (400, 700). Manrope is not among them, so Inter is already part of the legacy look. [V]
- 60 lines in the CSS use `backdrop-filter` (counted across `web/css` including `web/css/v2`). [V]
- A "Smooth mode" setting exists ("Turn on if the app feels laggy"). Source: `ui/settings.js`. [V]
- A performance governor (`ui/perf.js`) switches blur off while scrolling and turns Smooth mode on by itself if scrolling is measured choppy in two separate scrolls. [V]
- An older note records "phone scroll performance with many backdrop-filter layers" as not verified. Source: `docs/archive/HANDOFF_through_v150.md`. [V]
- A boot-gate test simulates 60, 90 and 120 Hz screens. Source: `tests/bootgate.test.js`. [V]
- A keyword search for lag, jank, choppy and stutter in the handoff, release notes and device test files found no recorded frame-time measurements of the legacy app or of V2. [V]
- The owner reports that V2 was very laggy on the OnePlus Nord CE5 (8 GB, Android 16). [O]
- The cause of that lag (blur, WebView, animations, anything else) has never been measured. [U]
- How smooth the legacy V1 look is on that phone in numbers. [U]

## 8. What this means for Phase 2 (observations, not new facts)

- The legacy app contains lag mitigations (Smooth mode, governor); no measurements behind them were found in the files searched. [V]
- Phase 2 will therefore produce the first measured frame-time numbers for this look. A like-for-like legacy number would need a separate measurement of the web app, which is out of scope unless the owner asks. [U]
- Assumption: Phase 2 needs no change to the legacy repo, since the prototype uses mock data only. [U]

## 9. Known gaps in this baseline

- No feature was run; only files were read and tests run in the sandbox. [U]
- The exact exercise count and the full list of fields in the export were not checked. [U]
- Other branches and settings of the native repo were not inspected. [U]
