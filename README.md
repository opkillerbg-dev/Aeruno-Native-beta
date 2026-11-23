# AERUNO Native Android App

> **New here?** Read [`START_HERE.md`](START_HERE.md) first.

**Architecture selected by the owner (2026-11-23): Path A — Kotlin + Jetpack Compose, native Android.** This repository is the current native development workspace. The app currently present here is still a prototype; it is not the completed product.

The HTML/CSS/JavaScript files created during design are visual and interaction specifications. They are **not automatically converted into Kotlin**. Each owner-approved screen will be deliberately recreated in Jetpack Compose and connected to native application state, Kotlin domain logic, persistence and Android services.

The legacy AERUNO application remains in its separate repository. Its frozen copy in `AERUNO_HANDOFF/legacy-reference/` is a read-only source of existing functionality, business rules, data formats and Android integration behaviour. Do not modify it from this repository.

## Current phase

G01 Plan experience design is in progress. Manage Plan V05.2.1 is the current design baseline. The next design task is the Day Actions sheet, followed by Full Plan Calendar and an end-to-end Plan review. See [`AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`](AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md) and [`AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`](AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md).

## Important project documents

- [`START_HERE.md`](START_HERE.md) — current project status and required reading.
- [`AERUNO_HANDOFF/OWNER_ARCHITECTURE_DECISION_2026-11-23.md`](AERUNO_HANDOFF/OWNER_ARCHITECTURE_DECISION_2026-11-23.md) — Path A owner decision.
- [`AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`](AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md) — complete design-to-native implementation route.
- [`AERUNO_HANDOFF/ROADMAP.md`](AERUNO_HANDOFF/ROADMAP.md) — phased roadmap.
- [`AGENTS.md`](AGENTS.md) — repository rules and delivery protocol.
- [`docs/DESIGN_TOKENS.md`](docs/DESIGN_TOKENS.md) — existing native design tokens.
- [`AERUNO_HANDOFF/FEATURE_INVENTORY.md`](AERUNO_HANDOFF/FEATURE_INVENTORY.md) — legacy functionality inventory.

## Build and install the current prototype

GitHub builds the debug APK through the **Build debug APK** workflow. A green run means the Android project compiled; it does not prove that all app features work or that the interface has been tested on a device.

1. Open the repository's **Actions** tab.
2. Open the newest **Build debug APK** run and confirm it succeeded.
3. Download the `aeruno-native-debug-apk` artifact.
4. Extract it and install the APK.
5. A fresh debug signing key may mean the previous prototype must be uninstalled before installing a new build. The prototype has no production data.

## Delivering repository updates

The `Apply update` workflow expects one file named **`update.zip`** uploaded to the repository root. ZIP entries must be paths relative to the repository root (for example, `AERUNO_HANDOFF/ROADMAP.md`), with no enclosing project folder. The workflow extracts and commits those files, removes `update.zip`, and attempts to start the debug APK build. Files under `.github/` are skipped and must be added manually.

## Current identity and data boundaries

- Temporary prototype package ID: `com.aeruno.nativeprototype`.
- Final production package ID and signing: not decided.
- Legacy package ID, signing, `aryaApp2` storage key/schema, backup format and native services: frozen; do not change without explicit owner approval.
- No production user data or credentials belong in this public repository.
