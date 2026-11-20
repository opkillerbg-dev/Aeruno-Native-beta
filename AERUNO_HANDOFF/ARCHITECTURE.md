# Architecture and integration

Tags: see `../START_HERE.md`. `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`. Assessments marked **[I]** are the handoff author's inferences from reading code; nothing here is a decision (`ARCHITECTURE_DECISIONS.md`).

## 1. The two systems today
```
LEGACY APP (functional)                              NATIVE PROTOTYPE (visual experiment)
+---------------------------------------+            +--------------------------------+
| WebView  (Capacitor 6)                |            | Kotlin + Jetpack Compose       |
|  index.html + ES5 JS + CSS            |            |  theme (tokens, fonts)         |
|  globals: APP, st, PR                 |            |  GlassSurface (Haze 1.7.2)     |
|  localStorage "aryaApp2", IndexedDB   |            |  3 test screens, mock data     |
+------------------+--------------------+            |  no services, no storage       |
      Capacitor.Plugins.X  /  window.AxInsets        +--------------------------------+
+------------------v--------------------+
| Java (package com.arya.fit)           |            Shares nothing with legacy at runtime.
|  plugins: RunEngine, Steps, SyncFile, |            Different app id, different build.
|           AppWidget, AppIcon          |
|  services: RunService (GPS),          |
|            StepsPlugin.Svc (steps)    |
|  helpers: NotifKit, VoiceKit,         |
|           WidgetKit, 3 widget prov.   |
|  SharedPreferences: arya_steps,       |
|    arya_sync, arya_voice, arya_widget |
+---------------------------------------+
```

## 2. UI-to-native communication (legacy) [V]
- JS calls `Capacitor.Plugins.<Name>.<method>(args)`; each plugin method is a `@PluginMethod` taking a `PluginCall` (JSON in, JSON out). Examples: `RunEngine.start/state/route/stop/speak`, `Steps.status/start/history/keepAlive`, `SyncFile.pick/read/write`, `AppWidget.update`, `AppIcon.get/set`.
- Plugin classes call services with Intents and static methods. Services do not call back into JS; **JS polls** (`state()`, `history()`), and pushes timer state to the run service (`engPush` in `LEGACY/web/js/core/progress-share.js`).
- `MainActivity` injects `window.AxInsets` (system-bar insets, bar style) consumed by `LEGACY/web/js/core/native-ui.js`.
- JS data never reaches native code except: the widget JSON snapshot (`AppWidget.update`), run options (`RunEngine.start`), TTS text, sync file content.

## 3. Java/Kotlin interoperability [I]
Java and Kotlin compile together in one Android module; Kotlin can call the legacy Java classes directly and Java can call Kotlin. The prototype is Kotlin-only today, with no Java source set. [U: whether adding the legacy Java to the prototype needs Gradle changes beyond default Android source sets. Not tested.]

## 4. Coupling to Capacitor (measured by import and symbol reading) [V]
| Java file | Imports `com.getcapacitor` | Notes |
|---|---|---|
| `RunTrack`, `NotifKit`, `NotifText`, `VoiceKit`, `WidgetKit`, `StepsWidgetProvider`, `TodayWidgetProvider`, `ComboWidgetProvider` | No | Plain Android/Java |
| `RunService` | Yes, only `JSObject` | `JSObject` wraps `org.json.JSONObject`; used to build the state/route JSON |
| `RunEnginePlugin`, `StepsPlugin`, `SyncFilePlugin`, `AppWidgetPlugin`, `AppIconPlugin` | Yes | Thin `PluginCall` wrappers. `StepsPlugin` also contains the nested step service `Svc` and receiver `Boot`, which use the outer class's static helpers |
| `MainActivity` | Yes | `extends BridgeActivity`; registers plugins; `AxInsets`; refresh-rate request |
`SyncFilePlugin` uses Capacitor's activity-result callback for the file picker. `RunService` keeps the track in static in-memory fields and is non-sticky; the **JS layer persists the in-progress run** (`aryaRun1`). These are verified by reading, **not compiled or run** by the handoff author [U].

## 5. Reusability map (neutral, by component) [I]
| Component | Without Capacitor | Reuse in native Kotlin/Compose (Path A) | Reuse in rebuilt WebView UI (Path B) |
|---|---|---|---|
| `RunService`, `RunTrack`, `StepsPlugin.Svc`/`Boot`, `NotifKit`, `NotifText`, `VoiceKit`, `WidgetKit`, widget providers | Mostly yes | Direct reuse after replacing `JSObject`, declaring manifest entries, deciding package name | Unchanged |
| Plugin wrappers (5) | No (they are the bridge) | Adapter: replace with Kotlin facade classes | Unchanged; new UI calls the same plugin API |
| Pure JS engines (7) | n/a | Port to Kotlin; Node tests are the spec | Keep as-is |
| Entangled JS (progression, readiness, prs, coach, timers-run, ...) | n/a | Port and re-structure | Keep, or rewrite glue on top of the pure engines |
| Storage (`aryaApp2`) | n/a | Migrate (import) | Keep |
| Backup/sync format | n/a | Importer/exporter needed | Keep |
| Exercise data/images/body map | n/a | Port data; reuse webp assets | Keep |
| All UI | n/a | Rebuild | Rebuild |

## 6. Needs investigation [U]
Whether the legacy Java still compiles today (`docs/CURRENT.md` says the edits since v141 were first compiled by CI and that build #128 was green [D]; not re-run here); foreground-service behaviour at targetSdk 36 (legacy targetSdk is whatever Capacitor 6 template sets, not checked); what the final merged `AndroidManifest.xml` contains; real data size; where the WebView lag comes from.

## 7. Data flow for a GPS run (legacy) [V, read-only]
`timers-run.js` creates `TM` -> `engStart()` -> `RunEngine.requestPermissions()` + `RunEngine.start(opts)` -> `RunService` (foreground notification, location updates, step sensor, `RunTrack` filter) -> JS polls `RunEngine.state()`/`route()` and persists `aryaRun1` -> on stop, `runsummary.js` builds the summary, stored in `APP.plans[...].rsum` and `.routes` -> included in exports.
