# Feature inventory (legacy app v150)

Tags: see `../START_HERE.md`. `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`. All paths under `LEGACY/`.

**How to read the "Device test" column:** no device-test results are recorded anywhere in the ZIP (`docs/DEVICE_TEST.md` result columns are blank [V]). "None recorded" means exactly that, not "failed". The only owner-confirmed device facts in the sources: installing a new build over the old one keeps data (2026-11-16) [D `docs/CURRENT.md`, `docs/DEVICE_TEST.md`]. "Code tests" = automated tests that exist in `tests/` (the 16 Node tests were run by the handoff author and passed [S]; the 34 Python/Playwright UI tests were NOT run [U]).

**"none found" in Code tests** means no test file whose name matches the feature; the behaviour may still be touched indirectly by `browser_test.py` [U].

**Reuse column** is the author's assessment [I] for Path A (native Compose) / Path B (rebuilt WebView UI); neither path is approved. Keep = unchanged, Adapter = thin new glue, Port = rewrite in Kotlin, Rebuild = new UI.

| # | Feature | Implementation | Source files | Depends on | Code tests | Device test | Reuse A / B |
|---|---|---|---|---|---|---|---|
| 1 | Today/Home dashboard | "What do I do now" screen: today's workout, readiness, weather card, nudges | `web/js/ui/home.js`, `ui/v2-today.js`, `features/readiness.js`, `features/weather.js` | `APP`, plan data | `v1_home_test.py` [not run] | None recorded | Rebuild UI, Port logic / Rebuild UI |
| 2 | Readiness score | 0-100 score adjusting the plan, with override | `features/readiness.js` | `APP`/`PR` | none found | None recorded | Port / Keep |
| 3 | Plan view, plan list, day view | Views `ax-v-plan`, `ax-v-plans`, `ax-day`; edit workout, shift schedule | `core/plan-ui.js`, `core/sheets-views.js`, `ui/v2-plan.js`, `core/state.js` (`axPlan`, `axSched`, `axEdits`) | `APP.plans` | `v1_plan_test.py` | None recorded | Rebuild UI / Rebuild UI |
| 4 | Personalised plan generator (first-run wizard) | Profile to plan; levels, weak points, equipment, protect areas; retest every 4 weeks | `features/onboard.js`, `onboard-entry.js`, `plangen.js`, `levelcalc.js`, `retest.js`, `core/profile.js`, `features/exdb.js`; specs `docs/onboarding/` | none (pure engines) | `plangen`, `levelcalc`, `retest`, `profile` Node tests | None recorded | Port (engines have Node tests) / Keep |
| 5 | Plan builder | 3-step builder to the arya-plan format | `features/builder.js` | plan validator in `sheets-views.js` | via browser tests | None recorded | Port / Keep |
| 6 | Coach "Smart week" | Rules engine adjusting weeks | `features/coachcalc.js` (pure), `features/coach.js` | `APP` | `coachcalc.test.js`, `coach_ui_test.py` | None recorded | Port / Keep |
| 7 | Workout session, set logging, progression | 1-tap set logging, progression hint, PR pills, deload hint; gym weights in kg | `features/progression.js`, `loads.js`, `core/timers-run.js` | `PR.wtLog` | `loads.test.js`, `loads_ui_test.py` | None recorded | Port / Keep |
| 8 | Timers | Countdown (`cd`), stopwatch (`sw`), intervals (`iv`); wake lock; voice cues | `core/timers-run.js`, `core/run-extras.js`, `features/voice.js` | `TM` object, Web Speech or `RunEngine.speak` | `automove.test.js`, `autopause_ui_test.py`, `v1_move_test.py` | None recorded | Port / Keep |
| 9 | Hands-free workout player | Full-screen player: pictures, set counter, rest timer, voice | `features/handsfree.js` | timers, exercise media | via browser tests | None recorded | Rebuild / Rebuild |
| 10 | Built-in exercise library | 108 exercises; 62 with pictures (webp frames a-d + masks) | `features/exdb.js`, `core/exercise-media.js`, `features/animate.js`, `web/images/exercises/`, `web/images/exercise-masks/`; seed `docs/onboarding/exercises.seed.json`; tool `tools/build-exdb.py` | none | `exdb.test.js` | None recorded | Port data, reuse images / Keep |
| 11 | Online exercise library (opt-in) | Downloads public-domain free-exercise-db into IndexedDB `aryafit-lib` | `features/library.js`, `ui/v2-exercises.js` | network, IndexedDB | none found | None recorded | Investigate / Keep |
| 12 | Swap exercise | Same-muscle alternatives in Edit workout | `features/swap.js` | `exdb` | none found | None recorded | Port / Keep |
| 13 | GPS run tracking (native) | Foreground location service, 1 s GPS updates, track filter, step sensor, notification | `native/java/RunService.java`, `RunTrack.java`, `RunEnginePlugin.java`, `VoiceKit.java`, `NotifKit.java`; JS `core/progress-share.js` (`engStart/engPush/engSync`), `core/timers-run.js` | Android location permissions, foreground service type `location` | `runcalc.test.js`, `gps_sim.js` (simulator), `run_ui_test.py`; `NotifTextTest.java` exists, not in CI | Background GPS **untested on device** [D `CURRENT.md`] | Adapter (reuse service) / Keep |
| 14 | Run summary, PRs, route map, share, GPX | After-run summary, best efforts, offline SVG route and live trace, share card, GPX export | `features/runsummary.js`, `prs.js`, `routemap.js`, `livemap.js`, `runcard.js`, `gpx.js`, `runcalc.js` | `rsum`, `routes` in `APP.plans` | `efforts.test.js`, `gpx.test.js`, `runcalc.test.js`, `prs_ui_test.py`, `runcard_ui_test.py`, `gpx_ui_test.py` | None recorded | Port / Keep |
| 15 | All-day step counter | Foreground health service reading the step counter, per-day totals, boot restart, history to JS | `native/java/StepsPlugin.java` (`Svc`, `Boot`), `core/steps-progress.js`, `features/widget.js` | `ACTIVITY_RECOGNITION`, `FOREGROUND_SERVICE_HEALTH`, `RECEIVE_BOOT_COMPLETED` | none found | Steps after reboot **untested on device** [D `CURRENT.md`] | Adapter / Keep |
| 16 | Progress, history, overview, analytics | History list, totals, PRs, charts | `core/sheets-views.js` (`prog()`), `core/steps-progress.js` (`axPs`), `core/progress-share.js`, `ui/v2-progress.js` | `APP` | `v1_progress_test.py` | None recorded | Rebuild UI, Port logic / Rebuild UI |
| 17 | Body map and recovery/volume heat | SVG anatomy, Recovery vs Week volume | `core/body-map.js`, `features/bodyheat.js`, `web/images/anatomy/` | plan + logs | none found | None recorded | Investigate / Keep |
| 18 | Weekly review card | 1080x1350 PNG share card | `features/weekly.js` | canvas, native Share | via browser tests | None recorded | Port / Keep |
| 19 | Streaks and goals | Appear in plan, readiness, weekly, widget and nudge code | `core/plan-ui.js`, `core/sheets-views.js`, `features/readiness.js`, `weekly.js`, `widget.js`, `nudges.js` | `APP` | none found | None recorded | Investigate [U exact location] |
| 20 | Backup export / import | JSON envelope `arya-28day-tracker` v2; export via share sheet; restore with validation | `core/data-io.js`, `features/backup.js` | `APP`, `PR` | `store.test.js`, `browser_test.py` | Round trip **not recorded** (`DEVICE_TEST.md` D1 blank) | Migrate (importer) / Keep |
| 21 | File sync | One user-picked file kept in sync; pulls newer data on open | `features/sync.js`, `native/java/SyncFilePlugin.java` | Storage Access Framework | none found | None recorded | Adapter / Keep |
| 22 | Storage safety and migrations | Schema version 2, migrations, damaged-data recovery, snapshots | `core/store.js`, `core/state.js` | localStorage | `store.test.js` (required in CI) | Update-over-old keeps data [O/D] | Migrate (spec) / Keep |
| 23 | Notifications and nudges | Daily reminder, hydration, move break, evening walk, weekly summary, comeback; run/steps notifications | `features/nudges.js`, `core/run-extras.js`, `native/java/NotifKit.java`, `NotifText.java` | `POST_NOTIFICATIONS`, LocalNotifications, exact alarms | `nudges.test.js`, `nudges_ui_test.py`, `reminder_test.py` | None recorded; hidden step notification untested [D] | Adapter or rebuild / Keep |
| 24 | Home-screen widgets | Steps, Today and Overview widgets | `features/widget.js`, `native/java/WidgetKit.java`, `StepsWidgetProvider.java`, `TodayWidgetProvider.java`, `ComboWidgetProvider.java`, `AppWidgetPlugin.java`, `native/res/layout/`, `native/res/xml/`, `tools/patch_widgets.py` | JSON snapshot from JS | none found | None recorded | Adapter / Keep |
| 25 | Voice cues | Choose TTS engine/voice/speed | `features/voice.js`, `native/java/VoiceKit.java` | Android TTS | `voice_ui_test.py` | None recorded | Adapter / Keep |
| 26 | App icon picker | 6 selectable adaptive launcher icons | `features/appicon.js`, `native/java/AppIconPlugin.java`, `tools/patch_icons.py`, `tools/icons/`, `native/res/mipmap-*` | manifest activity aliases | none found | None recorded | Adapter / Keep |
| 27 | Run weather | Opt-in forecast to suggest a run time | `features/weather.js` | network (`api.open-meteo.com`), location | `weather.test.js` | None recorded | Investigate / Keep |
| 28 | Settings hub, Glass studio, Lite mode, skins | Grouped settings; glass parameters; low-cost mode | `ui/settings.js`, `ui/v2-settings.js`, `ui/v2-glass-studio.js`, `ui/perf.js`, `core/adaptive-glass.js` | localStorage `axLite`, `axLiteAuto` | `v1_me_test.py`, `v2_glass_studio_test.py` | None recorded | Rebuild / Rebuild |
| 29 | Help layer | In-app help | `ui/help.js` | none | `v1_help_test.py` | None recorded | Rebuild / Rebuild |
| 30 | Loading screen gate | Waits for stable frame rate before revealing app | `features/bootgate.js`, `js/boot.js`, `css/boot.css` | rAF | `bootgate.test.js`, `boot_ui_test.py` (flaky on slow machines [D]) | None recorded | Rebuild / Keep |
| 31 | Offline/PWA | Service worker precache, manifest | `web/sw.js`, `web/manifest.webmanifest` | browser | none found | None recorded | n/a / Keep |
| 32 | Android shell integration | Edge-to-edge, insets, back button, status bar, high refresh rate request | `native/java/MainActivity.java`, `core/native-ui.js`, `core/lifecycle.js`, `features/backnav.js` | Capacitor | `backnav_test.py` | None recorded | Port / Keep |
| 33 | Motion | Direction-aware tab slides, page pushes | `ui/motion.js` | CSS | none found | None recorded | Rebuild / Rebuild |
| 34 | Build/CI tooling | APK build, key check, update unpacker, checkers | `.github/workflows/`, `tools/` | GitHub Actions | `store.test.js` + `browser_test.py` in CI | CI green at build #128 [D] | n/a |

## Source files (`web/js`, with size in bytes and the file's own header comment)
| File | Bytes | Header comment |
|---|---|---|
| `web/js/core/adaptive-glass.js` | 790 | Conservative signals only: don't disable glass just because a device lacks reporting APIs. |
| `web/js/core/body-map.js` | 67617 | Render the anatomy as a real interactive SVG, not a decorative image. |
| `web/js/core/data-io.js` | 14287 | daily steps already travel in prefs.ds; packFresh only refreshes them from the native counter first |
| `web/js/core/exercise-media.js` | 3108 | v50 exercise pictures. EXI = which files exist (slug -> letters); a missing file just means no picture for tha |
| `web/js/core/lifecycle.js` | 3348 | Step 8b: Android back button (history guard entry; native app only) |
| `web/js/core/native-ui.js` | 8834 | v64 native insets bridge (MainActivity exposes window.AxInsets; absent in browser/PWA, then env() alone is use |
| `web/js/core/plan-ui.js` | 9706 | v98: rebuild when the plan length changed (rest day inserted, coach week past the end) |
| `web/js/core/profile.js` | 5305 | Onboarding profile: validation + draft storage. See docs/onboarding/02_DATA_MODEL.md. |
| `web/js/core/progress-share.js` | 12837 |  |
| `web/js/core/run-extras.js` | 8537 |  |
| `web/js/core/sheets-views.js` | 39561 | Animate only stable summary numbers once; never rewrite live run timers or GPS metrics. |
| `web/js/core/state.js` | 9504 |  |
| `web/js/core/steps-progress.js` | 10050 | Step 7: settings status line |
| `web/js/core/store.js` | 3283 | Storage safety: schema version, migrations, damaged-data recovery, snapshots. |
| `web/js/core/timers-run.js` | 18512 | auto-paused: keep feeding the tracker so slow walking is never lost; resume on 2 movement signs within 6 s. Ma |
| `web/js/features/animate.js` | 3716 | Arya Fit v70 (v93: paused by default): Animated exercises. Cross-fades the A/B/C/D frames in a loop with a Pla |
| `web/js/features/appicon.js` | 8343 | Arya Fit v84: app icon picker (Settings > Appearance). Six adaptive icons; Android switches between them with |
| `web/js/features/backnav.js` | 1029 | Arya Fit v96: Android back button through Capacitor's own event (@capacitor/app). |
| `web/js/features/backup.js` | 2094 | Arya Fit v73: backup nudge. Export already opens the Android share sheet (pick Google Drive there). |
| `web/js/features/bodyheat.js` | 4074 | Arya Fit v72: Body tab "Week volume" heatmap. Toggle between Recovery (existing) and Week volume (sets per mus |
| `web/js/features/bootgate.js` | 4486 | Arya Fit v116: smart loading-screen gate (pure, also node). |
| `web/js/features/builder.js` | 14841 | Arya Fit v80: "Build my plan". 3 quick steps -> a plan in the existing arya-plan format -> validated by vplan( |
| `web/js/features/coach.js` | 14668 | Arya Fit v98: Smart week (coach), app side. The rules live in coachcalc.js (pure, tested). |
| `web/js/features/coachcalc.js` | 10104 | Arya Fit v98: Coach engine. Pure logic (no DOM, no app globals), tested by tests/coachcalc.test.js. |
| `web/js/features/exdb.js` | 28598 | exdb.js: exercise database for onboarding / plan engine (S1). Data = docs/onboarding/05_EXERCISE_DB.md. |
| `web/js/features/gpx.js` | 2683 | GPX 1.1 export of a saved run route. Works in the browser and in node (tests). |
| `web/js/features/handsfree.js` | 8179 | Arya Fit v69: Hands-free workout mode (full-screen player: picture strip, set counter, rest timer, voice cues, |
| `web/js/features/levelcalc.js` | 3042 | levelcalc.js: onboarding S2. Pure level + weak-point engine (docs/onboarding/03). No UI, no storage, also runs |
| `web/js/features/library.js` | 6575 | Arya Fit v73: online exercise library (yuhonas/free-exercise-db, public domain). |
| `web/js/features/livemap.js` | 3144 | Live route map in the run panel: offline SVG trace of the last ~1.2 km, with your position. No tiles, no netwo |
| `web/js/features/loads.js` | 3103 | loads.js: onboarding S9. Pure helpers for gym weights. Weights are stored in kg, per set, in PR.wtLog = {exerc |
| `web/js/features/nudges.js` | 13056 | v140: Nudges. Hydration, morning check-in, move break, evening walk, workout-still-open, wind-down, weekly sum |
| `web/js/features/onboard-entry.js` | 5846 | onboard-entry.js: S7. Ways in to the personalisation wizard for people who already use the app. Never forced,  |
| `web/js/features/onboard.js` | 37857 | onboard.js: first-run personalisation wizard (docs/onboarding/01_UX_SPEC.md). S4 = shell + screens 0-3 (welcom |
| `web/js/features/plangen.js` | 17573 | plangen.js: onboarding S3. Pure plan engine (docs/onboarding/04): profile -> arya-plan. No UI, no storage, no  |
| `web/js/features/progression.js` | 10470 | Arya Fit v68: 1-tap set logging, auto-progression hint, PR pills, deload hint. |
| `web/js/features/prs.js` | 7061 | Strava-style best efforts and PRs. Efforts come from AxRun.bestEfforts (stored per run as `be`; older runs are |
| `web/js/features/readiness.js` | 11478 | Arya Fit v66: Readiness score (0-100) on Home + real plan adjustment + override. |
| `web/js/features/retest.js` | 2912 | retest.js: onboarding S8. Pure 4-week retest logic: when it is due, new levels from fresh benchmarks, weak poi |
| `web/js/features/routemap.js` | 4387 | Arya Fit v73: offline route map. Adds a "Route" button to each run in Progress > History; opens a clean SVG li |
| `web/js/features/runcalc.js` | 11585 | Arya Fit v92: run maths. Pure functions, no DOM, so they run in Node tests too. |
| `web/js/features/runcard.js` | 12973 | Arya Fit v92: run share card (1080x1350 PNG, skin-aware colours like the weekly card). |
| `web/js/features/runsummary.js` | 14924 | Arya Fit v92: after-run summary. |
| `web/js/features/swap.js` | 4138 | Arya Fit v72: Swap exercise. In "Edit workout" each exercise gets a Swap button listing same-muscle alternativ |
| `web/js/features/sync.js` | 7362 | Arya Fit v85: auto sync. Keeps one sync file (pick Google Drive, or any folder, once) up to date and pulls new |
| `web/js/features/voice.js` | 3974 | Arya Fit v99: voice engine / voice / speed picker (Settings > Sound & feedback). Phone app only. |
| `web/js/features/weather.js` | 15070 | Arya Fit v91: Run weather. A Home card that says whether now (or which hour today/tomorrow) is a good time to  |
| `web/js/features/weekly.js` | 7535 | Arya Fit v71: Weekly review share card (1080x1350 PNG, skin-aware colours, native Share with web fallback). |
| `web/js/features/widget.js` | 2388 | Arya Fit v86: home-screen widgets bridge. Sends the widgets today's plan text, step goal, streak and the curre |
| `web/js/ui/help.js` | 4331 | AERUNO v149 (V1 simplification P8): help layer. |
| `web/js/ui/home.js` | 7764 | AERUNO v142 (V1 simplification P2): Home = "what do I do now". |
| `web/js/ui/motion.js` | 5494 | Arya Fit v80: one motion language for every screen. Direction-aware tab slides, settings pages that push in/ou |
| `web/js/ui/perf.js` | 2872 | Arya Fit v83: performance governor. Zero cost while idle (its only per-frame work runs during a scroll). |
| `web/js/ui/settings.js` | 12523 | Settings hub (v75). Turns the stacked accordion into a menu of rows; each row opens one page. |
| `web/js/ui/v2-core.js` | 3784 | V2 foundation state. Pure helpers are exported for node tests; DOM work stays optional. |
| `web/js/ui/v2-exercises.js` | 5830 | Arya Fit V2 P6 — exercise discovery layered over the existing add-exercise sheet. |
| `web/js/ui/v2-glass-studio.js` | 10850 | Arya Fit V2 - Glass studio (Settings > Glass studio) + Settings hub upgrades (quick toggles, glass row). |
| `web/js/ui/v2-liquid.js` | 15630 | Arya Fit V2 - Liquid Glass. |
| `web/js/ui/v2-plan.js` | 1769 | Arya Fit V2 P4 — Plan/Plans presentation enhancer. No plan data or handlers are rebuilt. |
| `web/js/ui/v2-polish.js` | 3789 | Arya Fit V2 P7 — one-time introduction and global accessibility/presentation corrections. |
| `web/js/ui/v2-progress.js` | 1924 | Arya Fit V2 P5 — Progress presentation enhancer. Existing prog()/axPs() own all data and interactions. |
| `web/js/ui/v2-session-run.js` | 8395 | Arya Fit V2 P3 — Session + Run presentation only; original timer/set/GPS handlers remain authoritative. |
| `web/js/ui/v2-settings.js` | 6364 | Arya Fit V2 P6 — grouped Settings hub and Appearance controls; original settings nodes remain moved, never reb |
| `web/js/ui/v2-shell.js` | 12415 | Arya Fit V2 shell: navigation, active-session shortcut and account popover. |
| `web/js/ui/v2-today.js` | 6330 | Arya Fit V2 P2 — Today presentation. Reuses existing plan data and controls. |
| `web/js/ui/v2-type.js` | 1853 | Arya Fit V2 - typography accent: wraps the LAST word of day titles in <em class="v2-type-accent"> (editorial i |

## Native Java files (`native/java/`)
`AppIconPlugin`, `AppWidgetPlugin`, `ComboWidgetProvider`, `MainActivity`, `NotifKit`, `NotifText`, `RunEnginePlugin`, `RunService`, `RunTrack`, `StepsPlugin`, `StepsWidgetProvider`, `SyncFilePlugin`, `TodayWidgetProvider`, `VoiceKit`, `WidgetKit` (15 files, about 82 KB) [V].
