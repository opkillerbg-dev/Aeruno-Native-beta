# AERUNO Current Design State — 2026-11-21

**Current phase: Design Foundation refinement.** Round 2 visual screens are complete. Foundation v0.1 and v0.2 are archived. The Type & Depth Board is the current visual evaluation checkpoint. No app implementation, migration, final native/WebView architecture decision, or new-UI performance benchmark has been approved.

## Read these first

1. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` — current authoritative status.
2. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md` — owner clarification: V1 was fine for the owner; Smooth mode was for friends on lower-end devices; V2 was a failed experiment and is not the target.
3. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md` — latest Type & Depth Board review and next targeted fixes.
4. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` — previous Foundation v0.2 decisions and observations.
5. `design/type-depth/` — latest Type & Depth Board HTML and phone captures.
6. `design/foundation-v02/` — Foundation v0.2 source.
7. `design/round-02/` — approved Round 2 Today strength, navigation and Today running baseline.

This current-state file and the two clarification/review files above supersede older performance-test suggestions or stale phase labels in historical docs where they conflict.

## Product and architecture context

- AERUNO is a personal Android fitness app.
- The legacy V1 application is the functional reference for existing capabilities, data and native integrations. The owner reports V1 ran normally on his own phone.
- Smooth mode was added mainly to help friends using lower-end devices who experienced lag; it was not a fix for a V1 lag issue on the owner's phone.
- V2 was a failed experiment, not the target product. Its reported lag is historical context, not a reason to diagnose V2 or choose the new architecture.
- Native Kotlin/Compose and a redesigned Capacitor/WebView remain possible implementation paths. Neither is approved. Evaluate them against the new AERUNO design and real functional requirements when an implementation decision is needed.
- Do not run the old V1 Smooth/Lite-mode comparison as an architecture diagnostic. Do not spend time reverse-engineering V2 unless the owner requests a specific investigation.

## Approved visual direction

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry information; glass is selective and functional.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Font families: Big Shoulders Display Black, Instrument Serif Italic and Inter.
- Navigation: Today, Plan, Train, Progress, Me; contextual live/paused session states.
- Round 2 screens: Today strength day, navigation states and Today running day are complete and archived in `design/round-02/`.

## Type & Depth direction

- Selective tall/elongated display typography is wanted, but the exact scale/method remains to be selected from the A/B/C/D comparison in the Type & Depth Board.
- Depth B (number tucked behind a card) and Depth C (route crossing in front of typography) are owner-preferred directions. Preserve them.
- Depth A remains exploratory; ghost numerals are promising but need restraint.
- Type & Depth Board **Refinement 1 delivered 2026-11-21** (awaiting owner review on the phone): Start workout/Start run labels stay on one line, Depth C metadata and title have clear spacing, the route placement is refined with the route-over-type effect kept, Depth B and the quieter ghost numeral are unchanged, and the A/B/C/D comparison is retained (label "approved" removed from C). **The owner chose variant C (×1.14 vertical scale of Big Shoulders Display) on 2026-11-21.** It is a design decision only; Android feasibility and the licence position for scaling the font are unchecked.
- The board is a visual exploration only; its HTML transforms are not proof of Android implementation or performance.

## Immediate next task

Owner reviews `design/foundation-v1/aeruno-design-foundation.html` (draft 1: colour, type with variant C, depth rules, components, space/motion, accessibility; every rule tagged Approved / Proposed / Open) and answers its open items, notably the session-pill timer font. Then design the representative **Plan** screen, then **Train**, to test the system beyond Today. No app implementation, migration or architecture investigation is approved. Do not repeat the Lite-mode test. Do not investigate V2.

## Next phase after the board is approved

Consolidate the selected typography, depth rules, components, accessibility constraints and motion into the practical Design Foundation. Then design representative screens beyond Today (starting with Plan and Train) to test the system across the product. Architecture can be evaluated against those actual screen and feature requirements before implementation.

## Safety and preservation constraints

Do not change app IDs, signing, storage keys/schema, backup format, native services, legacy source or existing build workflows without explicit owner approval. Keep legacy source as a read-only functional reference. No secrets, keys or personal backups in this public repository. Keep design and technical claims evidence-based.
