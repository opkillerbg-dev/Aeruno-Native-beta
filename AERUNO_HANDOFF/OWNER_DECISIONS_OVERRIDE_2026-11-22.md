# Current owner decisions and project direction — 2026-11-22

**Authority:** This is the newest owner-decision overlay. It inherits all still-valid identity, preservation, architecture and evidence rules from `OWNER_DECISIONS_OVERRIDE_2026-11-21.md`. Where the older file's *Plan task or next-step wording* conflicts with this file, this 2026-11-22 update takes precedence. The older file remains historical context; it is not deleted.

## 1. Product and project direction

- AERUNO remains a personal Android fitness application being redesigned as a distinctive, premium, usable product.
- The legacy V1 application remains the functional reference for existing features, data and native integrations. Do not modify `AERUNO_HANDOFF/legacy-reference/` or the separate legacy repository.
- The current work is still **design and product-definition only**. No application implementation, migration, storage/service changes or architecture commitment is authorized by the Plan design artifacts.
- Native Kotlin/Compose versus a redesigned Capacitor/WebView application remains undecided. The experimental native prototype is not the chosen final architecture.

## 2. Inherited visual decisions — remain locked

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry information; glass is selective and functional.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Fonts: Big Shoulders Display Black, Instrument Serif Italic and Inter. Do not add fonts or network font dependencies to the product without approval.
- Navigation: **Today · Plan · Train · Progress · Me**.
- Variant C: Big Shoulders Display Black at ×1.14 vertical scale, selective display use only. This is a design selection, not approval of a particular Android implementation.
- Session-pill timer: Big Shoulders Display, Option 2, locked; it remains outside Variant C scaling.
- Depth B: oversized programme/metric numeral partially occluded by a foreground surface, used meaningfully.
- Depth C: route graphic interacting with oversized typography.
- Do not use Terracotta as ordinary small text on light Ivory/Surface backgrounds; retain the approved palette.

## 3. Plan visual direction — owner-selected, final screen not approved

The owner selected the hybrid direction:

**Concept B — Program Edition composition + Concept A — Training Route topographic language.**

Develop it through these principles:

- Editorial, asymmetric, expressive composition. The current training week is a featured programme chapter, not a generic dashboard card.
- Programme-duration numeral is the Depth B anchor (for a four-week sample programme, the numeral is `4`, not the current week `2`).
- Depth C uses the established sage route with ivory-ringed terracotta waypoints. It represents programme progression, not a fabricated GPS route.
- Topographic lines are localized, purposeful and composition-aware; they are not a uniform background texture.
- Weekly rhythm uses unequal session-marker heights derived from planned session duration where reliable data exists. Rest days use compact horizontal Sage markers. A connected, gently undulating route thread is preferred over a rigid baseline.
- Today and selected-day states remain independent. Selecting another day must not move the actual Today marker.
- Natural vertical scrolling is intentional. Do not compress the full Plan experience into one 844 px viewport merely to avoid scrolling.
- The floating bottom navigation stays fixed and uses selective Liquid Glass. Content may pass behind it, but controls and meaningful text must remain accessible.
- Progressive Blur is a distinct scroll treatment: strongest at the fixed upper edge, fading progressively downward without a visible end line. It is a prototype design requirement, not yet a verified Android implementation or performance decision.
- The selected-session surface remains a strong Deep Forest composition with readable content and the established full-pill warm-Ivory action.

## 4. Current Plan artifact status

- `design/plan-screen/aeruno-plan-g01-v03.html` is the latest scroll-aware editorial prototype, submitted for owner review.
- `design/plan-screen/G01_V03_DESIGN_HANDOFF.md` records its structure, prototype interactions, Proposed choices and untested assumptions.
- The owner has positively received the direction and specifically supports natural scrolling, the earlier expressive unequal-height weekly rhythm, Progressive Blur and Liquid Glass as part of the future experience.
- **V03 is a strong proposed candidate, not an Approved final design.** Do not mark it Approved, do not begin app implementation, and do not treat the prototype's mock actions as production functionality.
- The original Plan exploration remains useful as functional/layout research. The user clarified that its previously listed gaps are existing research/observations, not a fresh or exhaustive audit. Verify individual behaviours against actual source files when necessary; do not repeat the whole research exercise.
- Foundation Draft 2 is owner-reported as reviewed/corrected, but the actual file is absent from this repository snapshot. Do not reconstruct it, infer its contents or approve it.

## 5. Current next work

The next Plan checkpoint is **G01 V04 — Product Completeness and Design QA**, not another moodboard round. It should resolve/represent the remaining Plan product questions without adding visual clutter:

1. Week selection and access to a whole-programme/28-day calendar.
2. Selected-session states: strength, run, rest/recovery, completed and upcoming, using supported data and behaviours.
3. Clear access to secondary session controls such as edit sets/reps, individual exercise swap, reschedule preview, finish/reopen and rest-day choices, without turning the hero into a toolbar.
4. Review the Coming Up area and its relationship to the weekly rhythm.
5. Verify Today versus Selected state independence.
6. Review Progressive Blur and fixed Liquid Glass navigation across realistic scroll positions, including fallback and readability.
7. Responsive and accessibility review at 360, 390 and 412 px, plus enlarged text considerations.

After the main Plan experience is coherent, design the **Manage Plan sheet** as its own bounded task. Then complete the remaining essential screen designs and shared journeys. Do not start Train or other screens in parallel with unresolved Plan interactions unless the owner explicitly changes the sequence.

## 6. Progressive Blur and Liquid Glass — status boundary

- V03 contains a browser prototype of six masked progressive-blur strata and a fixed translucent navigation surface.
- The owner wants Progressive Blur and Liquid Glass carried forward as reusable design-system concepts, not sprayed across every card.
- Browser rendering is not evidence of Android WebView/Compose support, low-end-device performance, GPU cost, accessibility or final implementation feasibility. Those belong to Milestone 2 technical validation.

## 7. Broader AERUNO development milestones

Use `AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md` as the master sequence:

- **Milestone 1 — Product and design foundation:** finish essential screen designs, design system, interaction patterns, feature requirements and user journeys.
- **Milestone 2 — Technical validation:** evaluate native Kotlin/Compose against a redesigned Capacitor/WebView application through focused tests of rendering, performance, legacy-service compatibility, offline storage, data/backup and maintenance feasibility. Make an architecture decision only after evidence and owner review.
- **Milestone 3 — Actual application development:** implement the selected foundation and approved screens incrementally, preserving established V1 behaviours and testing every phase.

## 8. Explicitly not authorized

- No Android, Kotlin, Compose, Capacitor or legacy application implementation in this design update.
- No edits to app IDs, signing, storage keys/schema, backup format, GPS/steps services, widgets, notifications or build workflows.
- No architecture decision based on the existing throwaway native prototype alone.
- No V2 investigation or old Smooth/Lite diagnostic unless the owner requests a specific investigation.
- No claim of Android testing, build success, performance or blur smoothness without the corresponding evidence.
