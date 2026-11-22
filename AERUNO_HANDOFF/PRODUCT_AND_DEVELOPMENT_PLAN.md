# AERUNO — Product and Development Plan

**Updated:** 2026-11-22  
**Current milestone:** 1 — Product and design foundation  
**Status:** Planning only. No architecture or implementation approval is implied.

## Product objective

Build AERUNO into a distinctive, reliable personal Android fitness app while preserving the useful functionality, data and workflows established by the working legacy V1 application.

The target experience is editorial, expressive and architectural, using the established Old Money × Liquid Glass identity. It must remain a usable fitness product rather than a set of attractive mockups.

## Source-of-truth rules

- Legacy V1 is the functional reference for existing features, data and native integrations. The archived source under `AERUNO_HANDOFF/legacy-reference/` is read-only.
- The separate eight-image Visual Reference Pack v1 is the primary creative/art-direction benchmark. It is complete and supplied as a companion ZIP; do not regenerate or duplicate it in this repository.
- Owner decisions are authoritative. Keep **Approved**, **Selected direction**, **Proposed**, **Open** and **Untested** distinct.
- The native Kotlin/Compose prototype is an experiment, not the final architecture.
- No implementation, migration or architecture decision is authorized until the relevant design and technical gates are reviewed by the owner.

---

# Milestone 1 — Product and design foundation

**Goal:** define the essential product experience before choosing an implementation architecture. Complete this efficiently; do not polish one screen indefinitely while other essential product decisions remain untouched.

## 1.1 Main Plan screen

Current candidate: `design/plan-screen/aeruno-plan-g01-v03.html`.

Next bounded checkpoint: **G01 V04 — Product Completeness and Design QA**.

Resolve or explicitly leave open:

- Programme identity and duration, current-week progress and Depth B/C semantics.
- Week selection and the entry point to a whole-programme/28-day calendar.
- Variable-height weekly rhythm derived from useful session data, with clear completed/today/upcoming/rest/selected states.
- Today versus Selected independence.
- Selected-session states for strength, running, recovery/rest, completed and upcoming sessions.
- Access to secondary actions: edit sets/reps, individual exercise swap, reschedule preview, finish/reopen and rest-day choices.
- Coming Up section, its value beyond the weekly rhythm, and its interaction with selection.
- Progressive Blur and fixed Liquid Glass navigation across scroll positions; ensure legibility and graceful fallback.
- Responsive behaviour, enlarged text, touch targets, scrolling and accessibility.

V03 is not approved. Do not begin app implementation from it.

## 1.2 Manage Plan sheet

Design as a separate, coherent AERUNO experience. Use existing product research as guidance, verifying individual behaviours against source when needed.

Expected capability areas to design and label accurately:

- Active programme identity and progress.
- Switching between plans and adding/managing plans.
- Plan my next week / Smart Week: preview, apply and undo where supported.
- Editing/personalising a plan and building a plan where supported.
- Reschedule and selected-day controls in their correct context.
- Plan import/export and the separate full-backup operation; do not conflate them.
- Clear confirmation, cancellation and destructive-action treatment.

Do not present an unsupported session-to-session swap or fictional settings capability as existing functionality. Individual exercise swap is a different behaviour.

## 1.3 Remaining essential screens

After Plan and Manage directions are sufficiently reviewed, complete the core screens:

- **Today:** use the existing Round 2 Today strength/running work as reference; refine only where the current design system or journey requires it.
- **Train:** session execution, active workout/run, exercise groups, timers and relevant session states.
- **Progress:** history, trends and meaningful statistics.
- **Me:** profile, personal settings and app-level preferences.

Do not repeat completed Round 2, Type & Depth or Visual Reference Pack work. Reuse what remains relevant and test consistency across screens.

## 1.4 Shared design system and journeys

Consolidate:

- Tokens, typography hierarchy and selective Variant C use.
- Solid surface, border, radius and elevation rules.
- Liquid Glass and Progressive Blur rules, including where not to use them.
- Navigation states and contextual session states.
- Common buttons, sheets, pills, progress indicators, lists and confirmation patterns.
- Loading, empty, error, permission, offline, completed and recovery states where relevant.
- Key user journeys and a capability-to-screen map tied to the legacy functional reference.

### Milestone 1 exit gate

Owner has reviewed and approved the essential screen directions and critical journeys; Proposed/Open items are explicitly listed; core feature behaviours are mapped to the legacy reference; responsive browser previews have been inspected; no design prototype is being represented as Android-tested. Only then move to technical validation.

---

# Milestone 2 — Technical validation and architecture decision

**Goal:** choose the implementation path from evidence, not preference or the existence of an experimental prototype.

Evaluate both:

- **Path A:** native Kotlin/Jetpack Compose.
- **Path B:** redesigned Capacitor/WebView application.

Neither path is selected today.

### Focused validation questions

1. Can the approved AERUNO typography, editorial composition and motion be reproduced accurately?
2. Can Progressive Blur and Liquid Glass deliver the intended visual effect at acceptable performance, including on lower-end Android hardware?
3. What are the real scrolling/frame-time, startup, memory and battery/thermal trade-offs? Measure only what is actually available; do not invent CPU/GPU readings.
4. How reliably can each path preserve legacy capabilities: GPS/run tracking, background services, step counting, timers, notifications, widgets and permissions?
5. How will offline storage, plan data, history, import/export, backups and migration be preserved?
6. What are the maintenance burden, testability, development speed, dependency risks and long-term ownership costs?
7. What accessibility, system-font scaling, safe-area and device compatibility constraints exist?

### Validation method

- Select a small representative slice based on approved design, not a static screenshot alone. Include scrolling, the intended glass/blur behaviour, typography and a meaningful interaction.
- Reuse the existing native prototype only as a test asset; it does not become the architecture by default.
- Build and run on real target hardware. A green CI build proves compilation, not smoothness.
- Compare equivalent content and interaction conditions between paths as fairly as practical.
- Record test device, OS, refresh rate, software versions, test steps, measurements, limitations and failures.
- Verify legacy-service and data compatibility against actual source, not assumptions from the UI prototype.

### Milestone 2 exit gate

Produce an evidence-based comparison and explicit recommendation. The owner chooses the architecture and approves the repository/identity/migration plan. No silent selection and no irreversible migration before that decision.

---

# Milestone 3 — Actual application development

**Goal:** implement the approved AERUNO product incrementally while preserving proven behaviour.

Expected sequence after architecture approval:

1. Establish the selected project structure, build, CI, environment and development rules.
2. Define the data model and storage strategy; document compatibility and migration/backup behaviour before changing data formats.
3. Implement navigation and shared design-system components.
4. Implement approved screens and journeys one bounded phase at a time.
5. Integrate legacy capabilities and native services carefully; preserve app identity, storage and backup contracts unless the owner explicitly approves a change.
6. Test each phase: logic tests, browser/Compose checks as appropriate, CI build, then owner device tests for real rendering and hardware-dependent behaviour.
7. Maintain a verified/unverified list, release checklist and rollback/backup plan.

### Development rules

- No mass rewrite. No unrelated refactor.
- Preserve working V1 behaviour until the replacement is proven.
- Never claim a feature works because its UI exists.
- Test after each meaningful phase; stop when a blocker threatens data or existing functionality.
- No secrets, signing keys, personal data or backups in this public repository.
- Deliver repo updates as a validated `update.zip` containing repo-relative paths, followed by a concise continuation prompt.

---

## Current next actions

1. Complete G01 V04 product-completeness decisions and QA for the Main Plan screen.
2. Design and review Manage Plan.
3. Complete the remaining essential screens and user journeys.
4. Consolidate the design system and product requirements.
5. Begin Milestone 2 technical validation only after Milestone 1's exit gate.

## Explicit non-goals for the current milestone

- No production app code or Android implementation.
- No Kotlin/Compose vs Capacitor decision.
- No migration, app identity/signing, storage schema or native-service changes.
- No old V2 or Smooth/Lite diagnostic.
- No regeneration of the completed Visual Reference Pack.
