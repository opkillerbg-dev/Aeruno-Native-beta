# Glossary

| Term | Meaning |
|---|---|
| **AERUNO** | Public name of the app. Formerly **Arya Fit**. |
| **Arya / `arya` / `ax-`** | Internal codenames kept in code: storage key `aryaApp2`, CSS/DOM prefix `ax-`, package `com.arya.fit`, sync marker `arya-fit-sync`. Never renamed (would break data/backups) [V `LEGACY/docs/brand/README.md`]. |
| **Legacy application** | The working Capacitor/WebView app (repo `Arya-Fit-app`), copy at v150 in `AERUNO_HANDOFF/legacy-reference/`. |
| **Native prototype** | This repo's Kotlin/Compose experiment (`app/`). No app functionality. |
| **Capacitor** | Framework that wraps a web app in an Android WebView and exposes native code as "plugins". Version 6 in legacy. |
| **WebView** | The Android component that renders web pages inside an app. |
| **Plugin** | Java class callable from JavaScript via `Capacitor.Plugins.<Name>`. |
| **RunEngine / `RunEnginePlugin`** | Plugin for GPS runs: start, state, route, stop, speak. |
| **`RunService`** | Foreground Android service doing the GPS tracking (type `location`). |
| **`RunTrack`** | Pure Java class that filters GPS points into a track (also mirrored in JS `runcalc.js`). |
| **Steps / `StepsPlugin`** | Plugin plus nested service `StepsPlugin.Svc` (counts steps, type `health`) and receiver `StepsPlugin.Boot` (restart after reboot/update). |
| **`SyncFile` / `SyncFilePlugin`** | Pick/read/write a user-chosen file via Android's Storage Access Framework (used for auto sync). |
| **`AppWidget`, `WidgetKit`, widget providers** | Home-screen widgets: Steps, Today, Overview ("Combo"). |
| **`AppIcon`** | Plugin switching among 6 launcher icons. |
| **`NotifKit`, `NotifText`, `VoiceKit`** | Native helpers for notifications, notification text and text-to-speech. |
| **`AxInsets`** | JS interface injected by `MainActivity` giving system-bar insets and bar style. |
| **`APP`, `st`, `PR`** | JS globals: whole saved app object, progress, preferences. |
| **`aryaApp2`** | `localStorage` key holding `APP` as JSON. |
| **`AXSCHEMA` / `AXMIG`** | Current data schema number (2) and the list of migrations. |
| **arya-plan** | The JSON format of a workout plan inside the legacy app. |
| **Legacy export v2** | Backup file: `{app:"arya-28day-tracker", version:2, schema, exported, active, meta, prefs, profile, plans:{...}}` (`DATA_AND_MIGRATION.md`). |
| **`exdb`** | Built-in exercise database (108 exercises) in `web/js/features/exdb.js`. |
| **plangen / levelcalc / coachcalc / retest / runcalc** | Pure JS engines: plan generator, levels and weak points, weekly coach rules, 4-week retest, run maths. |
| **`TM`** | The timer/run session object in `core/timers-run.js` (modes `cd`, `sw`, `iv`). |
| **V1 / V1 simplification** | The original UI and its v142 to v149 clean-up ("Home = what do I do now"). |
| **V2** | The later dark "liquid glass" visual layer (`web/js/ui/v2-*.js`, `web/css/v2/`) applied on top of the old DOM. |
| **Lite mode / perf governor** | Low-cost visual mode (`axLite`) and scroll-time cost reducer (`ui/perf.js`). |
| **Glass studio** | Settings page to tune glass look in legacy (`ui/v2-glass-studio.js`). |
| **Haze** | Android/Compose library (`dev.chrisbanes.haze`, pinned 1.7.2) providing real backdrop blur; used only inside `ui/glass/`. |
| **Backdrop blur** | Blurring the content behind a surface (true glass). Not the same as blurring the surface's own content. |
| **Progressive blur** | Blur whose strength changes gradually along a direction (e.g. strong at the top edge, none lower down). |
| **`GlassSurface`** | Prototype composable giving a surface in three looks: Glass, Translucent, Solid. |
| **`TopProgressiveBlur`** | Prototype composable for the progressive top-edge blur. |
| **N00 to N08** | Prototype "cards" (small tasks): N00 baseline, N01 skeleton + CI, N02 tokens + fonts, N03 glass card test, N04 top progressive blur, N04b Today screen (deferred), N05 benchmark, N06 docs, N07 owner device test, N08 GO/NO-GO. See `PROTOTYPE_HISTORY.md` for the "N04" naming accident. |
| **Card / gate / lane** | Task unit / its pass condition / folder set a task may change (prototype `AGENTS.md`). |
| **GO / NO-GO** | The owner's planned decision on whether a native migration is worth it (card N08, never reached). |
| **`update.zip`** | A zip of changed files with repo paths; uploaded to the repo root, unpacked by the `Apply update` workflow. |
| **Palette A "Deep Heritage"** | The approved colour set (ivory, deep forest, terracotta, surface, surface alt, sage, text, muted). |
| **Old Money x Liquid Glass / Verdant Glass** | The design direction names (`DESIGN_SYSTEM.md`). |
| **Path A / Path B** | The two candidate architectures (`ARCHITECTURE_DECISIONS.md`). Neither approved. |
| **`FrameMetrics`** | Android API for measuring frame times; the planned way to benchmark the prototype (never run). |
| **Evidence tags [V] [S] [D] [O] [I] [U]** | See `../START_HERE.md`. |
