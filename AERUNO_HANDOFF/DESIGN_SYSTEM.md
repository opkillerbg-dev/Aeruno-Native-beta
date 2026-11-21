# Design system

> **Update 2026-11-21:** the consolidated, tagged reference is now `../design/foundation-v1/aeruno-design-foundation.html` (draft). The owner chose type variant C: display type may be scaled ×1.14 vertically (hero titles, major workout/category words, one hero statistic per screen). This is a deliberate, display-only exception to "never stretch or shrink fonts to fit" below; it is untested on Android. Where this file and the foundation page differ, the foundation page and `CURRENT_DESIGN_STATE.md` win.

Tags: see `../START_HERE.md`. Status labels: **APPROVED** = owner decision recorded in this repo's `AGENTS.md`/logs or stated by the owner; **EXPERIMENT** = tested visually in the prototype, not a final rule; **OPEN** = undecided. Code truth for the native tokens: `app/src/main/java/com/aeruno/nativeprototype/ui/theme/` (`Color.kt`, `Dimens.kt`, `Type.kt`, `Theme.kt`) and `docs/DESIGN_TOKENS.md`.

## Aesthetic: Old Money x Liquid Glass (APPROVED direction)
Premium, understated, timeless; warm organic refined surfaces; modern glass used **intentionally** for depth, hierarchy or interaction; layered depth; subtle translucency; smooth, intentional motion; clean type; strong hierarchy. Must not look like a generic AI fitness dashboard, a template or an ordinary gym app. Avoid excess glass, gradients, clutter, meaningless animation. (The prototype's `AGENTS.md` section 7 calls the same direction "Verdant Glass".)

## Colour palette (APPROVED; owner-selected 2026-11-20, "Palette A Deep Heritage") [V `ui/theme/Color.kt`, `AGENTS.md` section 7]
| Token | Hex | Role |
|---|---|---|
| Ivory (`Background`) | `#F3EFE4` | Screen background (brand) |
| Deep Forest | `#1F3B30` | Primary: buttons, headings, dark surfaces (brand) |
| Terracotta | `#C97855` | Accent: fills, lines, icons, large decorative display only (brand) |
| Surface | `#FFFEFA` | Cards |
| Surface Alt | `#E7E2D6` | Neutral fill |
| Sage | `#DCE5D7` | Soft fill |
| Text | `#202A23` | Body text |
| Muted Text | `#646E65` | Secondary text |
Also in code: border `#D8D9CE`, danger `#B55345`, brass `#A98542` (unused, removal candidate). Do not reinvent the palette.
**Contrast (WCAG, computed by the prototype's author 2026-11-20 [D `docs/DESIGN_TOKENS.md`]):** text on ivory 12.9; muted on ivory 4.6; ivory on deep forest 10.6. **Terracotta on ivory is 2.9 and on surface 3.3: never for small text.**

## Typography (APPROVED)
| Role | Family | Use |
|---|---|---|
| Display | **Big Shoulders Display Black (900)** | Short, bold, uppercase headings; hero numbers; workout titles (1 to 3 words) |
| Accent | **Instrument Serif Italic** | Expressive editorial accent; at most one per screen; never body copy |
| UI | **Inter** (Regular 400 and Bold 700 bundled) | Body, labels, buttons, metrics, tabular numerals where digits must not jitter. The session-pill timer is the exception: Big Shoulders Display, locked by the owner 2026-11-21. Other timers: no decision recorded |
No other families. Contrast between display, editorial and functional type should be obvious.
**Hierarchy (prototype values, sp size/line height; EXPERIMENT until phone-checked) [V `AGENTS.md` section 7]:** hero stat 72/66; display large 60/55, medium 44/40; screen title 36/33; accent large 40/44, medium 28/32; headline 22/28 (Inter Bold); card title 18/24; body large 16/24, body 14/20; button 15/20; label 12/16 uppercase with tracking; caption 11/16; timer/stat numbers Inter Bold 32/36 and 22/28 with `tnum`. Rules: numbers visually dominant; tight tracking on big stats; uppercase only for small labels and display headings; never stretch or shrink fonts to fit.
The legacy web app already ships the same three families as woff2 (`LEGACY/web/fonts/`).

## Spacing and shape (prototype, EXPERIMENT)
Spacing dp: 4, 8, 12, 16, 20, 24, 32, 40. Radii dp: button 12, chip 14, icon button 16, card 22, hero card 28, bottom nav 28, sheet 28.

## Visual hierarchy and glass (principles APPROVED; parameters EXPERIMENT)
- Solid surfaces carry information; blur and translucency add depth only where they earn it. Glass is a candidate technique, not the goal.
- **Real backdrop blur** is blur of content *behind* a surface; `Modifier.blur()` on a card is foreground blur and does not count [V `AGENTS.md`].
- Glass surface starting values: blur 16 dp, white about 65%, cream tint about 12%, white border about 35%, minimal shadow. Translucent (no blur): white about 75%. Solid: `#FFFEFA` with neutral border [V `GlassTuning` in `ui/glass/GlassSurface.kt`].
- Progressive top-edge blur: strongest at the top edge, fading to none, with an ivory veil that fades on the same path; starting values blur 20 dp, veil 70% to 0% [V `TopBlurTuning` in `ui/glass/ProgressiveEdgeBlur.kt`]. EXPERIMENT (see `PROTOTYPE_HISTORY.md`).

## Motion (EXPERIMENT starting values) [V `AGENTS.md` section 7]
Button feedback 100 ms with press scale 0.97, selection 160 ms, card appear 220 ms, nav 220 ms, sheet 280 ms. Animate only transform and opacity. No continuously animated blur, background or shadow.

## Component philosophy
Premium, restrained, intentional; custom components, not stock Material (Material 3 only as a base in the prototype). Numbers and the current workout are the heroes; avoid dashboards of tiny boxes; do not port web layouts.

## Contrast and readability
Check text over any translucent surface by eye on the phone; muted text only on ivory/surface; terracotta only for decoration or large fills. Not yet verified: text contrast over the blurred surfaces (prototype logs list it as untested).

## Open design questions
Navigation design, screen layouts, component set, illustration/asset art direction, final motion language, whether glass is used on cards, navigation, sheets or only selected overlays. All **OPEN**; ChatGPT leads visual direction and the owner decides.

## Legacy visual system (for contrast; do not carry over blindly)
The legacy repo shows two looks: the **V1** UI (light ivory/forest with a serif accent; screenshots in `LEGACY/docs/v1-simplify/after_final/*.jpg`, v142 to v149 [V images]) and the dark **V2** layer below. Which one is the default in v150 was not traced (`LEGACY/tests/v1_default_test.py` exists) [U].
The legacy V2 look is dark (`--v2-bg:#000`, accent `#30d158`, radii 28/24/32/16, SF-like glass) [V `LEGACY/web/css/v2/tokens.css`]. It is a different identity from the palette above. `LEGACY/docs/DESIGN_TOKENS.md` is a misplaced copy of the native doc, not legacy tokens (`REPOSITORY_GUIDE.md`).
