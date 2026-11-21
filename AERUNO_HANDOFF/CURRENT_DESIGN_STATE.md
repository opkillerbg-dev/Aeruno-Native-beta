# AERUNO Current Design State — 2026-11-21

**Current phase: Plan screen creative rework.** Round 2 visual screens, the Type & Depth Board checkpoint and the separate 8-image Visual Reference Pack are complete. The first Plan exploration was reviewed and is not visually approved. The next checkpoint is two materially different Plan directions with their Manage sheets; owner selection is pending. Design Foundation Draft 2 correction/review is owner-reported, but the Draft 2 file is not included in this repo copy. No app implementation, migration, final native/WebView architecture decision or new-UI performance benchmark has been approved.

## Status update — visual reference pack and Plan phase

- **Visual Reference Pack v1 is complete and delivered as a separate ZIP:** `AERUNO_Visual_Reference_Pack_v1.zip`. The owner will attach it separately when starting the new chat; it is not a prerequisite to regenerate or rebuild. Read `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md` for the contents and how it should guide the work.
- Use the pack as the primary **visual/art-direction benchmark**. It does not replace the repo's functional research or owner-approved decisions, and it is not an approved final Plan layout.
- **Current phase: Plan screen creative rework**, owner review pending: `design/plan-screen/OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md` is the owner's visual feedback; `design/plan-screen/README.md` and the HTML export preserve the first functional/layout exploration.
- The first Plan exploration is useful for its researched feature set and information sequence, but its conventional visual execution is not approved. Preserve it as reference; do not restart its functionality research without a specific unresolved question.
- Create two materially different, art-directed Plan concepts. Each must show the main Plan screen and its Manage sheet, use the existing researched feature set, and be compared in one review artifact. Explain the core idea briefly and recommend one, but do not mark either Approved. Stop for owner selection. Train begins only after Plan approval.
- Session-pill timer font is locked to Big Shoulders Display. It is outside the Variant C vertical scaling.
- The owner reports that Foundation Draft 2 correction and review are complete (2026-11-21), but the Draft 2 file is not in this repo copy. Proposed and Open items remain as tagged unless the owner explicitly approves them.

## Read these first

1. `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md` — the separate pack's status, contents and intended use.
2. `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-21.md` — authoritative owner decisions and superseded guidance.
3. `design/plan-screen/OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md` — required Plan creative rework.
4. `design/plan-screen/README.md` — existing Plan research and open capability gaps.
5. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md` — V1/Smooth/V2 correction.
6. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md` — completed board refinement and selected Variant C.
7. `design/round-02/` — approved Round 2 Today strength, navigation and Today running baseline.
8. `design/type-depth/` — Type & Depth Board HTML and refinement captures.
9. `design/foundation-v1/aeruno-design-foundation.html` — Foundation draft 1; do not assume it contains the owner-reported Draft 2 corrections.
10. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` — historical exploration; newer decisions supersede old open questions.

If older documents conflict with the current owner override or this file, follow the current status and the owner override. Preserve older content as historical context unless a specific documentation correction is requested.

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

`design/foundation-v1/aeruno-design-foundation.html` is **Draft 1 — historical review artifact**, not a fully approved implementation specification. The owner reports Draft 2 correction and review complete, but that file is not in this repository copy. Do not silently infer that all Proposed/Open items were promoted.

Known review items retained from the available record:

- **Session-pill timer font: LOCKED — Big Shoulders Display (Option 2), owner decision 2026-11-21** (`TIMER_FONT_DECISION_2026-11-21.md`). Do not reopen unless the owner asks or implementation testing finds a concrete issue. The timer stays outside Variant C ×1.14 scaling. Other timers and countdowns have no recorded decision; use tabular figures where numbers must not jitter and mark any choice Proposed.
- Keep the palette unchanged. The Foundation lists Terracotta on Ivory at 2.90:1 and on Surface at 3.30:1; these combinations should be decorative or large-fill use, not ordinary small text. The ratios have not been independently re-measured in this documentation patch.
- Proposed component, spacing, radius, motion and accessibility rules remain Proposed unless the owner explicitly approves them. Open items remain Open.
- Foundation rendering was checked in a headless browser at 360, 390 and 412 px; this is not a real Android implementation or device test. Actual system font scaling at 200%, dark mode, accessibility and performance remain untested unless separately evidenced.

## Immediate next task

Use the completed Visual Reference Pack and the existing Plan research to create two materially different, art-directed Plan concepts, each with a main Plan screen and its Manage sheet. Compare both in one review artifact, explain their different composition ideas, recommend one with reasons, and stop for the owner's selection. Do not begin Train, app implementation, migration or architecture work until the relevant owner approvals are given.

## Safety and preservation constraints

Do not change app IDs, signing, storage keys/schema, backup format, native services, legacy source or existing build workflows without explicit owner approval. Keep legacy source as a read-only functional reference. No secrets, keys or personal backups in this public repository. Keep design and technical claims evidence-based.
