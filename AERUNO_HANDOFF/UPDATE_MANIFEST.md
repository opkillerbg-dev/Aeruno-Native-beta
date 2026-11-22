# Update manifest — 2026-11-22

**Prepared against:** `main` commit `3e2dad3593fb10e592bec434ff1ee4bfc2f72300` of `opkillerbg-dev/Aeruno-Native-beta`.  
**Package type:** `update.zip` for the existing Apply update workflow; repo-relative paths only.  
**Scope:** design artifacts and project handoff documentation. No application code or workflow changes.

## Added

- `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-22.md`
- `AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md`
- `AERUNO_HANDOFF/NEXT_TASK_G01_V04.md`
- `AERUNO_HANDOFF/historical/CONTINUATION_UPDATE_2026-11-20.md` (preserved from old staging folder)
- `design/plan-screen/aeruno-plan-g01-v03.html`
- `design/plan-screen/G01_V03_DESIGN_HANDOFF.md`
- `design/plan-screen/owner-captures/` (three owner-supplied browser-preview screenshots and evidence note)
- `docs/log/2026-11-22_plan-g01-v03.md`

## Updated

- `README.md`, `START_HERE.md`, `AGENTS.md`
- `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`
- `AERUNO_HANDOFF/ROADMAP.md`
- `AERUNO_HANDOFF/UPDATE_MANIFEST.md`
- `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md`
- `AERUNO_HANDOFF/REPOSITORY_GUIDE.md`
- `AERUNO_HANDOFF/CONTINUATION_UPDATE_2026-11-21.md` (now prominently marked historical/superseded)
- `design/README.md`
- `design/plan-screen/README.md`

## Preserved intentionally

- `design/plan-screen/aeruno-plan-screen.html` and its original render checks: retained as the first functional/layout exploration, not the visual benchmark.
- Round 2, Type & Depth and Foundation Draft 1: completed visual research remains useful history/reference.
- `AERUNO_HANDOFF/legacy-reference/`: read-only legacy V1 functional reference; untouched.
- `app/`, Gradle, `.github/workflows/`, app ID, storage, services and all native-prototype files: untouched.
- Visual Reference Pack v1: remains the separate companion ZIP and is not duplicated in the repository.

## Cleanup after applying this update

The old `aeruno_update/` folder is a one-time staging package whose contents have now been reconciled: its 2026-11-20 continuation note was copied to `AERUNO_HANDOFF/historical/`. After the update ZIP is successfully applied, delete these two tracked files manually:

- `aeruno_update/README.md`
- `aeruno_update/AERUNO_HANDOFF/CONTINUATION_UPDATE_2026-11-20.md`

The current Apply update workflow only adds/replaces files; it cannot delete tracked paths. See the separately supplied `CLEANUP_AFTER_UPDATE.md` for exact GitHub UI steps. No other files are recommended for deletion in this update.

## Important status boundaries

- G01 V03 is a proposed design candidate, not an Approved final Plan design.
- No app implementation, migration, architecture selection, build or Android device test was performed by this documentation/design package.
- The V03 owner captures are browser-preview screenshots, not formal automated responsive test output.
- Foundation Draft 2 remains owner-reported but absent; no reconstruction or inferred approval was made.
