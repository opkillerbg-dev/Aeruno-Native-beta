# Data and migration

Tags: see `../START_HERE.md`. `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`. **Nothing here is a decision.** The owner has not chosen an architecture, package name, signing key or migration method. No user data or backup file was available to the handoff author; the schema below comes from source code [V] and documents [D], not from real data [U].

## 1. Storage systems in the legacy app
| System | Where | What | Evidence |
|---|---|---|---|
| WebView `localStorage` key **`aryaApp2`** | `LEGACY/web/js/core/state.js` (`KEY2`, `save()`) | The whole app object `APP` as one JSON string: plans, progress, profile, preferences-related state | [V] |
| `localStorage` key `arya28v1` | `state.js` (`OLDK`) | Pre-v2 format, read for upgrade | [V] |
| Safety copies in `localStorage` | `core/store.js` (`AXSK`) | `aryaApp2.bak` (daily copy) with `aryaApp2.bakts`, `aryaApp2.premig` (before a migration), `aryaApp2.bad` (damaged data kept), `aryaApp2.preimport` (before a backup import) | [V] |
| In-progress run | `core/timers-run.js` (`RK`) | `aryaRun1` (current run state), `aryaLast1` (last run marker) | [V] |
| Onboarding | `core/profile.js`, `features/onboard-entry.js` | `aryaOnboardDraft`, `aryaOnboardSkip` | [V] |
| UI/feature keys | various | `axLite`, `axLiteAuto` (low-cost mode), `axSync` (sync state), `axWx` (weather cache), `axTips` (help tips) | [V] |
| IndexedDB **`aryafit-lib`**, store `kv` | `features/library.js` | Optional downloaded online exercise library | [V] |
| Android SharedPreferences (native) | `native/java/` | `arya_steps` (per-day step totals under keys `d_yyyy-MM-dd`, settings), `arya_sync` (picked sync file), `arya_voice` (TTS choice), `arya_widget` (widget snapshot JSON and colours) | [V names; key lists not fully traced] |
| Files on user storage | `SyncFilePlugin` / share sheet | Exported backups; optional sync file | [V] |

## 2. Schema
- **Version:** `AXSCHEMA = 2`; migrations in `AXMIG`: `{to:1, name:"baseline"}`, `{to:2, name:"profile"}` [V `core/store.js`]. Tests: `LEGACY/tests/store.test.js`.
- **Profile model** (`APP.profile`, added with the onboarding wizard): fields `v, done, ts, units, name, ht, wt, age, sex, health, goal{main,extra}, xp, env, equip[], bench{push,pull,squat,plank,run,lifts{}}, levels{push,pull,legs,core,run}, weak[], want[], protect[], days, mins, weeks, start, retest{last,due,history[]}` with documented ranges; unknown fields dropped on import [D `LEGACY/docs/onboarding/02_DATA_MODEL.md`; validation in `core/profile.js`].
- **Plan format:** objects in `APP.plans` tagged "arya-plan" (validated by `vplan()` in `core/sheets-views.js`); docs `docs/onboarding/04_PLAN_ENGINE.md`. Per plan: progress, schedule map, workout edits, `routes`, `rsum` (run summaries), generator info [V `pack()` in `data-io.js`].
- **Preferences `PR`:** includes gym-weight log `PR.wtLog` (kg per set), step history `PR.ds` (copied from native on export), voice and display settings [V partial]. A full key list of `PR` was not traced [U].

## 3. Backup format ("legacy export v2") [V `core/data-io.js` `pack()`]
```
{ app: "arya-28day-tracker", version: 2, schema: AXSCHEMA, exported: <ISO time>,
  active: APP.active, meta: axMeta(), prefs: PR, profile: APP.profile || null,
  plans: { <planId>: { plan, progress, schedMap, workoutEdits, routes, rsum, gen } } }
```
(Per plan, `progress` is exported from the in-app field `APP.plans[id].st`; the other keys keep their names. Exact code: `pack()` in `core/data-io.js`.) The whole `PR` object is exported as `prefs`; import restores it through `restorePrefs()`, which validates selected fields [V; which fields it keeps was not traced, U]. `packFresh()` refreshes steps history from native before packing. `doImport(txt)` parses, validates (`clean*` helpers, `restorePrefs`, `axValidApp`), writes a `aryaApp2.preimport` safety copy and restores. Export goes through the Android share sheet; a CSV of steps (`stepsCSV`) also exists. File sync (`features/sync.js`) writes the same kind of envelope, marker `"arya-fit-sync"`, to a user-picked file [V].
**Not in the export** (so lost on an export/import migration) [I, from reading `pack()`]: live run state, weather cache, help tips, sync state, native SharedPreferences other than steps history copied into `PR.ds` (voice, widget, icon choice), IndexedDB library.

## 4. Package identity and signing (facts only)
| Item | Value | Evidence |
|---|---|---|
| Capacitor `appId` / Java package | `com.arya.fit` | [V `capacitor.config.json`, `android-setup.sh`] |
| CI `applicationId` default | `com.arya.fit3` (override via workflow input `app_id`, e.g. `com.arya.fit4` for a deliberate clean install) | [V `build.yml`] |
| Installed id on the owner's phone | Believed `com.arya.fit3`; the owner confirmed a new build installs over the old as an update | [D `docs/CURRENT.md` line 16 (confirmed), line 43 says "installed app id unverified": **conflicting statements inside one file**] |
| Signing | Fixed public debug key in the legacy repo (`signing/debug.keystore`, fingerprint files `signing/EXPECTED_SHA256.txt`, `EXPECTED_RELEASE_SHA256.txt`); CI fails if the APK is signed differently | [V]. **The keystore file was NOT copied into this handoff** |
| Prototype id | `com.aeruno.nativeprototype`, signed by a fresh debug key on every CI build (each install requires uninstalling the previous prototype) | [V `AGENTS.md` section 3 and 12] |
Same application id **and** same signing key are required for one APK to update another in place. Different id = separate app with separate data. This is a fact about Android, not a decision for AERUNO.

## 5. Migration possibilities (options only, not chosen)
| Option | Path | How it would work | Open issues |
|---|---|---|---|
| M1 | B (keep WebView) | No migration: same app id, key and storage; schema changes through the existing `AXMIG` mechanism with automatic safety copies | Redesign must keep reading `APP`; entangled controllers |
| M2 | A (native), side by side | New app id; user exports a backup in legacy; native app imports the `arya-28day-tracker` v2 file. Or use the legacy file-sync as the transfer channel | Fidelity needs testing with a real backup; items listed under "Not in the export" |
| M3 | A (native), in place | Native build with the legacy app id and key replaces the app. SharedPreferences (steps etc.) survive and are readable by native code. WebView `localStorage` stays on disk but is not practically readable from Kotlin, so an export step is still needed | Requires reusing the legacy id and key (owner decision) |
| M4 | A (native) | Hidden WebView inside the native app to read old `localStorage` | Only works with the same app id; considered hacky [I]; untested |

## 6. Known data-loss risks
- `localStorage` can be cleared by "clear app data"; `aryaApp2.bak` is in the same store, so it does not protect against that [I].
- Export/import omits items listed in section 3 [I].
- Run recovery depends on JS-persisted `aryaRun1`; native `RunService` keeps the track in memory only [V]. If the process dies the native track is lost; recovery behaviour was never device-tested [D].
- Changing the app id or key without export/import would present as a fresh install [V fact of Android; `docs/brand/README.md` warns about renaming `aryaApp2`].
- Very large `routes` inside the single JSON blob could approach `localStorage` limits [I]; real size unknown [U].
- A real, redacted backup is needed to verify any import design (`KNOWN_ISSUES.md`).
