# AERUNO Native (prototype repository)

> **New here?** Read `START_HERE.md` first. It points to the current project state and design archive.

This repository contains a small native Kotlin/Jetpack Compose prototype and a read-only copy of the legacy AERUNO source for reference. It is not yet the production AERUNO app. The functional legacy app remains in its separate repository and must not be modified from this repository.

**Current project phase:** Round 2 visual design is complete and archived in `design/round-02/`. The next phase is Design Foundation. Architecture (native Compose vs rebuilt WebView), app implementation and migration remain undecided/not approved. See [`AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`](AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md).

Working rules: [`AGENTS.md`](AGENTS.md). Project handoff: [`AERUNO_HANDOFF/`](AERUNO_HANDOFF/). Legacy baseline: [`docs/BASELINE_LEGACY.md`](docs/BASELINE_LEGACY.md). Tool versions: [`docs/VERSIONS.md`](docs/VERSIONS.md).

## Prototype status

The native prototype is a visual/technical experiment. Its existing theme, fonts and glass tests are not the finished app and do not establish performance. Continue only within the owner's approved phase and the rules in `AGENTS.md`. The previous N04/N05 prototype task sequence remains on hold unless explicitly resumed.

- Prototype app id: `com.aeruno.nativeprototype` (temporary, debug builds only).
- Minimum Android version: Android 12 (minSdk 31).
- No keys, passwords or secrets belong in this public repository.

## How the app gets built

GitHub builds it. The workflow `Build debug APK` runs on pushes to `main`, or manually: **Actions tab > Build debug APK > Run workflow**.

## Get the app onto your phone

1. Open the repo, tap **Actions**, then the newest **Build debug APK** run. A green tick means the build succeeded.
2. Open **Artifacts** and download `aeruno-native-debug-apk`.
3. Extract the downloaded ZIP and tap the `.apk`.
4. Allow installs from the app you used to download/open it, then install.
5. Before installing a newer prototype build, uninstall the previous `AERUNO Native (proto)`. Each build uses a fresh debug key, so Android won't update over the previous one. The prototype has no user data.

If a run fails, open it, tap the failed **Build debug APK** job, and capture the first red error line.

## How changes get into this repo

Upload one file named `update.zip` to the repository root (**Add file > Upload files**). The `Apply update` workflow unpacks the paths, commits them, removes the ZIP and attempts to start the debug build.

Files inside `.github/` are skipped by the workflow and must be added manually.

## Building locally (optional)

Requires JDK 17 and Gradle 8.13. The repository does not include the Gradle wrapper; use `gradle assembleDebug`. The APK appears in `app/build/outputs/apk/debug/`.
