# AERUNO Roadmap — Current owner-approved sequence

**Updated:** 2026-11-22. This roadmap supersedes the earlier phase sequence where it conflicts. It is a gated plan, not authorization to skip owner decisions.

## Milestone 1 — Product and design foundation

Finish essential screen designs, the shared visual/interaction system, core feature requirements and user journeys.

Current order:

1. G01 V04 — complete Main Plan product decisions and design QA using V03 as the current proposed candidate.
2. Design and review the Manage Plan sheet.
3. Complete/reconcile the essential Today, Train, Progress and Me screen designs (reuse the completed Round 2 Today references; do not repeat them unnecessarily).
4. Consolidate navigation, session states, buttons, surfaces, sheets, typography, motion, Progressive Blur and Liquid Glass rules.
5. Map requirements and user journeys to existing legacy capabilities; keep unsupported or unverified behaviours labelled Open.

**Exit gate:** owner review of the essential screen directions and key user journeys; Approved/Proposed/Open states are explicit; responsive browser reviews and accessibility concerns are documented. No Android implementation claim is implied.

## Milestone 2 — Technical validation and architecture decision

Compare:

- Native Kotlin / Jetpack Compose.
- A redesigned Capacitor / WebView application.

The existing native prototype and its Haze/progressive-blur experiments are test assets only; they do not select the final architecture.

Validate an approved representative slice on real hardware. Compare rendering, scrolling, blur/glass behaviour, accessibility, dependency/maintenance costs and compatibility with existing GPS/run tracking, background services, steps, notifications, widgets, offline data, import/export, backups and permissions. Use equivalent test conditions and report what was actually measured. A green CI build is not evidence of real-device smoothness.

**Exit gate:** an evidence-based trade-off report and explicit owner architecture decision, with repository, app identity, signing and migration implications understood before implementation.

## Milestone 3 — Actual application development

After architecture approval:

1. Establish the selected foundation, build and CI.
2. Define storage/data compatibility and backup/migration strategy.
3. Implement navigation and shared design-system components.
4. Build approved screens and core journeys incrementally.
5. Integrate legacy functionality and native services carefully.
6. Test every phase in CI and on the owner's device where hardware/platform behaviour matters.
7. Prepare a stable release only after explicit identity/signing and release approval.

## Principles

- Preserve working legacy V1 behaviours and data contracts until replacements are proven.
- Inspect actual files before making project-specific claims.
- No mass rewrite or unrelated refactor.
- Do not introduce a feature because a mockup depicts it; verify its product behaviour.
- Do not claim tested/building/fast/smooth without named evidence.
- Keep the owner involved in major decisions.
- Keep the repository public-safe: no credentials, secrets, keystores, personal data or backups.
- Use small update ZIPs with repo-relative paths; note that the current Apply update workflow adds/replaces files but does not delete paths.
