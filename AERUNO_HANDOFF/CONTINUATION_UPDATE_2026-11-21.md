> **HISTORICAL — SUPERSEDED 2026-11-22.** The Foundation/Plan next-step instructions below have been replaced by `OWNER_DECISIONS_OVERRIDE_2026-11-22.md`, `CURRENT_DESIGN_STATE.md` and `PRODUCT_AND_DEVELOPMENT_PLAN.md`. Keep this file as an audit trail; do not follow its old task order.

# Continuation update — 2026-11-21

This update supersedes the earlier continuation note that asked the next assistant to refine the Type & Depth Board. That checkpoint is complete.

## Current owner decisions

- The owner selected Variant C: Big Shoulders Display Black at ×1.14 vertical scale, for selective display use only.
- Preserve Depth B and Depth C.
- Keep the Old Money × Liquid Glass direction, the approved palette and the three font families: Big Shoulders Display Black, Instrument Serif Italic and Inter.
- Legacy V1 ran normally for the owner; Smooth mode was mainly for friends on lower-end devices. V2 was a failed experiment and is not the target. Do not run the old Lite/Smooth diagnostic or investigate V2 as a prerequisite.
- Architecture remains undecided. No app implementation or migration is approved.

## Current task

Review/refine the existing Design Foundation draft at `design/foundation-v1/aeruno-design-foundation.html`. Resolve the session-pill timer font question with the owner; older `DESIGN_SYSTEM.md` guidance recommends Inter tabular numerals, while Round 2 shows Big Shoulders. This is a recommendation, not yet an owner-confirmed decision. Clarify Terracotta contrast/use restrictions without changing the approved palette. Preserve Approved / Proposed / Open tags honestly.

Do not begin Plan until the owner approves the corrected Foundation. After Plan, pause for owner review before Train.

## Delivery discipline

Return a valid `update.zip` containing only changed/new repository files at their repo-relative paths. Do not include app code, `.github/` workflows, legacy reference files, secrets, signing material or personal backups. State exactly which ZIP the owner should upload to GitHub as `update.zip`; distinguish it from any full repository ZIP used to start a new Claude account.
