# START HERE — AERUNO project handoff

You are continuing the existing AERUNO project. Do not restart the project, recreate completed visual research or assume that a prototype is the final application.

## 1. Current status

- **Current milestone:** Milestone 1 — Product and design foundation.
- **Current screen:** Plan, G01 V03 scroll-aware editorial prototype.
- **Current status:** Owner likes the direction; V03 is a strong proposed candidate, **not Approved**.
- **Next task:** G01 V04 — Plan product completeness and design QA. Then design Manage Plan. Follow `AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md`.
- **Architecture:** Native Kotlin/Compose vs redesigned Capacitor/WebView remains undecided.
- **Implementation:** Not authorized by the current design stage.

## 2. Read these first (in order)

1. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` — current project and Plan status.
2. `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-22.md` — newest owner decisions and selected design direction.
3. `AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md` — three milestones and exit gates.
4. `AERUNO_HANDOFF/NEXT_TASK_G01_V04.md` — bounded next task.
5. `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md` — the completed external Visual Reference Pack and its authority.
6. `design/plan-screen/README.md` — Plan feature research and current design files.
7. `design/plan-screen/G01_V03_DESIGN_HANDOFF.md` — exact V03 design structure and limitations.
8. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md` — correction about V1, Smooth mode and V2.
9. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md` — completed Type & Depth work and selected Variant C.
10. `design/round-02/` and `design/type-depth/` — completed visual references; do not recreate.
11. `design/foundation-v1/aeruno-design-foundation.html` — Foundation Draft 1 only. Draft 2 is owner-reported reviewed/corrected but its actual file is not in this repository copy. Do not reconstruct it or assume its contents.

If anything conflicts, use this precedence:

1. Newest owner decision overlay (`OWNER_DECISIONS_OVERRIDE_2026-11-22.md`).
2. `CURRENT_DESIGN_STATE.md` and this `START_HERE.md`.
3. The completed Visual Reference Pack for creative direction.
4. Existing feature research and legacy reference source for functionality.
5. Older prototype notes and dated continuation updates as history only.

## 3. Current Plan direction

**Concept B — Program Edition + Concept A — Training Route.**

Retain the editorial composition, programme-duration Depth B numeral, Depth C route, localized topography, expressive unequal-height weekly rhythm, Deep Forest selected-session surface, natural scrolling, Progressive Blur and selective Liquid Glass navigation.

V03 is not the final approved design. The user explicitly prefers natural scrolling over compressing everything into a single viewport. Do not require the complete page and primary CTA to fit above the fold. Do ensure controls are not obscured and content has enough clearance above the fixed navigation.

## 4. Next task: G01 V04

Finish the Plan product decisions without starting another moodboard round:

- Week browsing and whole-programme calendar entry point.
- Strength/run/rest/recovery/completed/upcoming states.
- Access to contextual edit, individual exercise swap, reschedule preview, finish/reopen and rest-day choices.
- Today vs selected-day independence.
- Coming Up's purpose and selection behaviour.
- Progressive Blur and Liquid Glass across scrolling states, including legibility and fallback.
- Responsive/accessibility review at 360, 390 and 412 px.

Then design the Manage Plan sheet. Do not start app implementation or choose the architecture.

## 5. Locked design baseline

- Aesthetic: Old Money × Liquid Glass.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Fonts: Big Shoulders Display Black, Instrument Serif Italic and Inter.
- Variant C: Big Shoulders ×1.14 vertical scale, selective display use only; implementation is untested.
- Session-pill timer: Big Shoulders Display Option 2, locked; outside Variant C scaling.
- Depth B: oversized numeral partially behind a foreground surface.
- Depth C: route interacting with oversized typography.
- Navigation: Today · Plan · Train · Progress · Me.
- Terracotta is not ordinary small text on the light surfaces.

## 6. Project history and preservation

- Legacy V1 ran normally for the owner. Smooth mode was mainly for friends on lower-end devices; it was not a fix for the owner's V1 performance.
- V2 was a failed experiment and is not the product or performance baseline. Do not investigate V2 or repeat the old Smooth/Lite diagnostic unless the owner requests a specific investigation.
- The native Compose prototype is an experiment for later technical validation, not the chosen architecture.
- The original Plan exploration and its render checks remain useful functional/layout history; they are not the current visual benchmark.
- The eight-image Visual Reference Pack v1 is complete and supplied separately. Do not recreate it.

## 7. Working and evidence rules

- Inspect actual files before making project-specific assumptions.
- Preserve Approved / Selected / Proposed / Open / Untested distinctions.
- The previous Plan functionality gaps were research observations, not a fresh or exhaustive audit. Verify individual behaviour against source when needed.
- Do not touch `AERUNO_HANDOFF/legacy-reference/`, legacy app IDs/signing, storage keys/schema, backup format, native services or existing build workflows.
- Do not claim a build, device test, blur performance or feature behaviour without evidence.
- Keep work bounded and reviewable. Owner decides major design and architecture questions.
- This is a public repository: no secrets, credentials, personal data or backups.

## 8. Evidence tags

| Tag | Meaning |
|---|---|
| **[V]** | Verified by reading the named repository file. |
| **[S]** | Verified by running something in an AI sandbox; not phone-tested. |
| **[D]** | Recorded in repository documentation/log; not independently re-checked. |
| **[O]** | Reported by the owner; not independently re-checked. |
| **[I]** | Inference. |
| **[U]** | Unknown / not checked. |

## 9. Repository update ZIP

The established `Apply update` workflow accepts `update.zip` at the repository root. It adds or replaces files at their repo-relative paths and starts the existing debug build workflow. It does not delete tracked files. A separate cleanup action is required for removals. `.github/` entries inside the ZIP are skipped intentionally.
