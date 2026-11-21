# Current owner decisions and superseded guidance — 2026-11-21

This is the authoritative decision overlay for the current AERUNO redesign phase. Read it before following older prototype, architecture, performance or design notes. Historical documents remain available for context, but any conflicting old instruction is superseded by this file and `CURRENT_DESIGN_STATE.md`. The completed Visual Reference Pack is documented in `VISUAL_REFERENCE_PACK_GUIDE.md` and supplied separately by the owner.

## Owner decisions

### Product and project direction

- AERUNO is being redesigned as a complete personal Android fitness app.
- The legacy V1 app is the **functional reference** for existing features and integrations, not a constraint on the new visual design.
- No final architecture decision has been made. Native Kotlin/Compose and a redesigned Capacitor/WebView remain possible paths.
- The current work is design-only. No app implementation, migration, native-service changes or architecture commitment is authorized by the design artifacts.

### Performance-history correction

- Legacy V1 ran normally for the owner on his own device.
- Smooth mode was introduced mainly for friends using lower-end devices; it was not a fix for a V1 lag problem on the owner's phone.
- V2 was a failed experiment and is not the target product or visual baseline. Its reported lag was not diagnosed and is not evidence against WebView, CSS blur, GPU rendering or any other layer.
- Do not repeat the V1 Smooth/Lite-mode comparison as an architecture diagnostic. Do not investigate V2 unless the owner requests a specific, concrete investigation.

### Visual direction

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry information; glass is selective and functional.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- App font families remain Big Shoulders Display Black, Instrument Serif Italic and Inter. Do not add Anton or a network font dependency.
- Navigation remains Today · Plan · Train · Progress · Me, with contextual live/paused session states.
- Preserve Depth B (number behind a card) and Depth C (route crossing in front of title). Use depth selectively, with readable real content.

### Type treatment — selected

- The owner selected **Variant C: Big Shoulders Display Black at ×1.14 vertical scale** on 2026-11-21.
- Use selectively for hero titles, major workout/category words and at most one hero statistic per screen.
- Do not use it for buttons, navigation, chips, body text, exercise names, forms, settings, timers or secondary statistics.
- The selected treatment is a **visual/design decision**, not approval to implement `scaleY` in Android. Compose/WebView feasibility, font behaviour, accessibility at enlarged system font sizes and any relevant font-licence interpretation remain untested.

## Current Foundation review items — not yet owner-approved

The file `design/foundation-v1/aeruno-design-foundation.html` is Design Foundation draft 1, not a final approved specification. The owner reports Draft 2 correction and review complete, but the Draft 2 file is not present in this repository copy.

- **Session-pill timer font: LOCKED — Big Shoulders Display (Option 2), owner decision 2026-11-21** (`TIMER_FONT_DECISION_2026-11-21.md`). Do not reopen unless the owner asks or implementation testing finds a concrete issue. It is a design decision, not proof of Android/WebView/Compose behaviour. The timer stays outside the Variant C ×1.14 scaling. It does not approve Foundation Draft 2 as a whole or its Proposed tokens. Other timers and countdowns have no recorded decision; use tabular figures where numbers must not jitter and mark any choice Proposed.
- The Foundation's contrast notes show Terracotta `#C97855` on Ivory `#F3EFE4` at 2.90:1 and on Surface `#FFFEFA` at 3.30:1. Keep the approved palette unchanged unless the owner approves a change. Treat these combinations as decorative/large-fill use only; do not use Terracotta as ordinary small text on these light surfaces. The displayed ratios have not been independently re-measured in this patch.
- Spacing, radius, motion, component details and accessibility codification tagged **Proposed** still need owner review. Items tagged **Open** remain undecided or untested.
- HTML/headless-browser rendering at phone-like widths is not a real Android/Compose/WebView device test. No performance or implementation claims may be inferred from it.

## Current visual-reference status — 2026-11-21

- The owner completed the 8-image **AERUNO Visual Reference Pack v1** and will supply `AERUNO_Visual_Reference_Pack_v1.zip` separately alongside the repository in the new chat.
- It contains the Visual Language Moodboard, Typography Exploration, Progress Card / Depth B, Tempo Run Hero / route, Today Strength Hero, Today Dashboard / Full Composition, Graphic Language Exploration and Plan Screen Reference, plus per-image reviews, consolidated visual direction, typography/graphic/depth rules, canonical navigation specification, coding-AI handoff instructions and an index/manifest.
- Treat the pack as the primary **creative/art-direction benchmark** for the next design work. It is not a feature specification, code source, architecture decision or approval of the first Plan layout. See `VISUAL_REFERENCE_PACK_GUIDE.md`.
- Do not recreate the pack, start another moodboard round or ask the owner to generate it again. It is completed and supplied as a separate file.

## Current Plan phase — 2026-11-21

- The first Plan exploration in `design/plan-screen/` is useful functional/layout research, but the owner says its visual execution is too conventional and does not carry the distinctive creative character of the approved AERUNO boards. It is not visually approved.
- Keep its functionality research and information hierarchy. Do not repeat the same research unless a specific unresolved question requires it.
- The next task is to create **two materially different, art-directed Plan concepts**, each showing the main Plan screen and its Manage sheet, using the existing feature research and the Visual Reference Pack. Compare both in one review artifact and recommend one; do not mark either Approved. Stop for the owner's selection.
- Train starts only after a Plan direction is selected and approved. Current work remains design-only.

## Historical documents superseded where they conflict

- `AGENTS.md`: the original native-prototype N-card plan and its old phase description are historical; current design-only phase and owner decisions above take precedence. General repository safety, evidence and preservation rules still apply.
- `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md`: early statements that the type winner is undecided are superseded by the selected Variant C decision above.
- `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md`: older exploration-stage wording that the tall type treatment is undecided predates the Type & Depth Board and is superseded by the selected Variant C direction.
- `AERUNO_HANDOFF/ARCHITECTURE_DECISIONS.md` and `AERUNO_HANDOFF/KNOWN_ISSUES.md`: old Lite/Smooth-mode diagnostic suggestions and V2-lag comparisons are not current tasks or valid architecture evidence.
- `AERUNO_HANDOFF/CONTINUATION_UPDATE_2026-11-21.md`: old next-step instructions to refine the Type & Depth Board are superseded; that checkpoint is complete. Its instruction to resolve the timer-font question is also superseded: the timer font is locked (see above).

Do not delete historical evidence merely to make the old notes appear current. Preserve it and use this precedence note to avoid treating the old notes as active instructions.
