# AERUNO Current Design State — 2026-11-21

**Current phase: Design Foundation review/refinement.** Round 2 visual screens are complete. Foundation v0.1 and v0.2 are historical explorations. Type & Depth Board Refinement 1 is complete and the owner selected Variant C. Design Foundation draft 1 exists and is awaiting owner review/corrections. No app implementation, migration, final native/WebView architecture decision or new-UI performance benchmark has been approved.

## Read these first

1. `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-21.md` — authoritative owner decisions and superseded guidance.
2. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` — this current status.
3. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md` — owner clarification: V1 was fine for the owner; Smooth mode was mainly for friends on lower-end devices; V2 was a failed experiment and is not the target.
4. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md` — completed board refinement and selected Variant C.
5. `design/foundation-v1/aeruno-design-foundation.html` — Foundation draft 1 for owner review.
6. `design/type-depth/` — Type & Depth Board HTML and phone captures.
7. `design/round-02/` — approved Round 2 Today strength, navigation and Today running baseline.
8. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` — historical Foundation v0.2 review; newer decisions supersede older open questions.

If older documents conflict with the override or this file, follow the override/current state. Preserve older content as historical context unless a specific documentation correction is requested.

## Product and architecture context

- AERUNO is a personal Android fitness app.
- Legacy V1 is the functional reference for existing capabilities, data and native integrations. The owner reports V1 ran normally on his own phone.
- Smooth mode was added mainly to help friends using lower-end devices who experienced lag; it was not a fix for a V1 lag issue on the owner's phone.
- V2 was a failed experiment, not the target product. Its reported lag is historical context only. It is not evidence against WebView, CSS blur, the GPU or any particular layer.
- Do not run the old V1 Smooth/Lite-mode comparison as an architecture diagnostic. Do not investigate V2 unless the owner requests a specific investigation.
- Native Kotlin/Compose and a redesigned Capacitor/WebView remain possible implementation paths. Neither is approved. Evaluate them later against the new AERUNO design and real functional requirements.

## Approved visual direction

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry information; glass is selective and functional.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Font families: Big Shoulders Display Black, Instrument Serif Italic and Inter. Do not add another family or network font dependency without owner approval.
- Navigation: Today, Plan, Train, Progress, Me; contextual live/paused session states.
- Round 2 screens: Today strength day, navigation states and Today running day are complete and archived in `design/round-02/`.

## Type & Depth decisions

- **Selected by owner on 2026-11-21: Variant C**, Big Shoulders Display Black at ×1.14 vertical scale, as a selective display direction.
- Use only for hero titles, major workout/category words and at most one hero statistic per screen. Never for buttons, nav, chips, body, exercise names, forms, settings, timers or secondary stats.
- This is a design decision only. Android/Compose/WebView implementation, font scaling behaviour, font-licence interpretation and accessibility at larger system font sizes remain untested.
- Preserve Depth B (number tucked behind a card) and Depth C (route crossing in front of typography). Depth A remains exploratory. Keep ghost numerals quiet and decorative, with the real goal stated in text.
- The Type & Depth Board is a visual exploration; its HTML transforms are not proof of Android implementation or performance.

## Current Design Foundation status

`design/foundation-v1/aeruno-design-foundation.html` is **Draft 1 — for owner review**, not a fully approved implementation specification. It consolidates palette, font roles, Variant C, depth rules, components, space/motion and accessibility with Approved / Proposed / Open tags.

Known review items:

- Session-pill timer font is still open. Round 2 shows Big Shoulders; older `DESIGN_SYSTEM.md` guidance specifies Inter tabular numerals for timers. Recommendation for owner review: Inter tabular numerals for all active timers/countdowns; do not mark it owner-approved until confirmed.
- Keep the palette unchanged. The Foundation lists Terracotta on Ivory at 2.90:1 and on Surface at 3.30:1; these combinations should be decorative or large-fill use, not ordinary small text. The ratios have not been independently re-measured as part of this documentation patch.
- Proposed component, spacing, radius, motion and accessibility rules require owner review. Open items remain open.
- Foundation rendering was checked in a headless browser at 360, 390 and 412 px; this is not a real Android implementation or device test. Actual system font scaling at 200%, dark mode, accessibility and performance remain untested unless separately evidenced.

## Immediate next task

Continue refining **the existing Foundation draft only**. Resolve the session-pill timer question with the owner, clarify Terracotta contrast/use restrictions, preserve Proposed/Open status honestly, and deliver the corrected Foundation with a documentation update ZIP. Wait for the owner's Foundation approval before beginning the representative **Plan** screen. Review Plan with the owner before moving to **Train**.

No app implementation, migration, architecture investigation or performance benchmark is authorized in this phase.

## Safety and preservation constraints

Do not change app IDs, signing, storage keys/schema, backup format, native services, legacy source or existing build workflows without explicit owner approval. Keep legacy source as a read-only functional reference. No secrets, keys or personal backups in this public repository. Keep design and technical claims evidence-based.
