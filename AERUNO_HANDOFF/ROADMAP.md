# AERUNO roadmap — Path A native Android

**Architecture decision:** Path A (Kotlin + Jetpack Compose) selected by the owner on 2026-11-23.  
**Current phase:** Finish the G01 Plan design package.  
**Detailed execution plan:** `IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`.

This roadmap supersedes the prior sequence that kept Path A and Path B undecided. It does not claim that implementation or feature migration is complete.

| # | Phase | Status | Exit condition |
|---|---|---|---|
| 0 | Choose target architecture | **Complete — Path A selected** | Owner decision recorded in `OWNER_ARCHITECTURE_DECISION_2026-11-23.md` |
| 1 | Complete the Plan design specification | **In progress** | Day Actions + Full Plan Calendar reviewed; main Plan, Manage, day and calendar states checked together |
| 2 | Design remaining app flows progressively | Next after Plan package | Required Today/Train/Run/Progress/Profile/settings/support flows have clear approved designs and functional specs; do not restart completed Round 2 work without reason |
| 3 | Close native UI/quality proof gates | Pending | Current Compose prototype builds; N04 progressive blur gate and N05 benchmark/device evidence are reviewed; design tokens/system insets/accessibility direction are ready |
| 4 | Establish native app foundation | Pending | Compose shell, canonical navigation, theme, state pattern, domain/repository boundaries and CI are agreed and verified |
| 5 | Build domain and data foundation | Pending | Core Kotlin models/use cases, persistence plan, schema/versioning, tests and backup/import strategy are validated |
| 6 | Implement approved features in vertical slices | Pending | Each slice includes Compose UI, Kotlin behaviour, data/native integrations, automated tests, CI and owner device review |
| 7 | Migrate legacy data safely | Pending | Explicit importer tested against representative exports; restore and failure cases verified without altering the legacy install/data |
| 8 | Full device validation | Pending | Background GPS, steps, timers, notifications, widgets, lifecycle, accessibility, performance and battery checks pass for included features |
| 9 | Release preparation | Pending | Separate owner decisions for production app ID, signing, distribution, privacy and release process are documented |

## Current design sequence

1. G01 main Plan and Manage Plan baseline.
2. G01 V06 Day Actions — next.
3. G01 V07 Full Plan Calendar.
4. Review the whole Plan experience and its states together.
5. Design and implement later features in small, dependent slices.

## Important implementation rule

HTML/CSS/JavaScript prototypes are design and interaction references. They are not automatically converted into Kotlin, and they are not production WebView screens. Approved designs are recreated in Kotlin/Jetpack Compose. The implementation must separately provide native state, domain logic, persistence, Android service integration and tests.

## Path A boundaries

- The legacy application remains a separate functional reference and is not modified from this repository.
- Existing Java Android services may be reused/adapted after checking Capacitor coupling, manifest entries, permissions, lifecycle and tests.
- Pure JavaScript business engines are ported/reimplemented in Kotlin with equivalent tests. DOM/global-dependent controllers are not copied wholesale.
- Existing user data is migrated through a deliberate, tested import/export flow. No direct destructive rewrite of legacy private storage.
- `com.aeruno.nativeprototype` remains a temporary app ID. Production identity, signing and distribution remain open.
- The N04/N05 native prototype checks measure quality/readiness within Path A; they do not automatically reopen the Path A vs Path B decision.

Principles: inspect before changing; preserve working systems; make small reviewable changes; label evidence honestly; do not claim a feature is migrated until it is tested.
