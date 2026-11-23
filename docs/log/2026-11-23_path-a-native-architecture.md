# 2026-11-23 — Path A native architecture selected and roadmap added

**Lane:** DOCS. Documentation only. No app code, Gradle files, native services, build workflows, app ID, signing, storage schema or legacy source changed.

## Changed

- Recorded the owner's explicit architecture decision: Path A, Kotlin + Jetpack Compose.
- Added `AERUNO_HANDOFF/OWNER_ARCHITECTURE_DECISION_2026-11-23.md`.
- Added `AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`, including the design-prototype-to-Compose workflow, technical foundations, feature slices, legacy reuse/porting, data migration, device QA and release gates.
- Updated `START_HERE.md`, `README.md`, `AGENTS.md`, `AERUNO_HANDOFF/ARCHITECTURE_DECISIONS.md`, `ARCHITECTURE.md`, `ROADMAP.md` and `CURRENT_DESIGN_STATE.md` so they no longer describe the architecture as undecided or the current phase as the earlier Plan concept comparison.
- Preserved the legacy application as a read-only functional reference and retained the distinction between the native proof prototype and the future complete app.

## Evidence

- **VERIFIED [O]:** Owner explicitly selected Path A in the conversation on 2026-11-23.
- **VERIFIED [V]:** Inspected the repository snapshot's `START_HERE.md`, `AGENTS.md`, `README.md`, `ARCHITECTURE.md`, `ARCHITECTURE_DECISIONS.md`, `ARCHITECTURE_DECISION_OVERRIDE_2026-11-21.md`, `ROADMAP.md`, `CURRENT_DESIGN_STATE.md`, `PROJECT_OVERVIEW.md`, `FEATURE_INVENTORY.md`, `DATA_AND_MIGRATION.md`, `BUILD_AND_TESTING.md`, and `.github/workflows/apply-update.yml`.
- **VERIFIED [V]:** Confirmed the update workflow extracts ZIP entries directly to their exact repository-relative paths; the ZIP must not contain an enclosing project folder. `.github/` entries are skipped.
- **VERIFIED [V]:** Confirmed the repository's old Path A/Path B undecided statements and historical N00–N08 proof-card status that needed clarification.

## Untested / unknown

- No Android source was compiled or changed in this DOCS-only update.
- No APK was built or installed as part of this update.
- Path A performance, full Compose implementation and feature parity remain untested.
- Final production repository strategy, package ID, signing, exact Room/DataStore schema and import/release details remain open for later decisions.

## Needs (owner)

- Upload the supplied `update.zip` to the root of `opkillerbg-dev/Aeruno-Native-beta` using the existing Apply update workflow.
- Review the next design task (G01 V06 Day Actions) after it is created; then continue with Full Plan Calendar.

## Next

Continue G01 Plan design: Day Actions, then Full Plan Calendar, then an end-to-end Plan review. After the design package, close the native N04/N05 quality gates and move into the Path A Compose foundation and vertical feature implementation plan.
