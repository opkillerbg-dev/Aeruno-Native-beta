# AERUNO Type & Depth Board — review checkpoint

**Board:** `design/type-depth/aeruno-type-depth-board.html`  
**Claude artifact:** https://claude.ai/artifact/RgbjfH2Ep66UkxqrXU4FXw  
**Status:** Refinement 1 delivered and reviewed by the owner on 2026-11-21. **Variant C is selected.** This board is closed as a design-selection checkpoint; it is not application implementation.

## Current owner decision

The owner selected **Variant C — Big Shoulders Display Black at ×1.14 vertical scale** on 2026-11-21. This is a selective display direction only:

- Use for hero titles, major workout/category words and at most one hero statistic per screen.
- Do not use for buttons, navigation, chips, body text, exercise names, forms, settings, timers or secondary statistics.
- This does not approve an Android `scaleY` implementation. Compose/WebView feasibility, text layout behaviour, system font scaling, accessibility and any relevant font-licence interpretation remain untested.

The old comparison label and earlier notes saying the winner was undecided are superseded by this decision.

## What's in the board

1. **Type comparison:** Big Shoulders at ×1.00, ×1.10 and ×1.14 vertical scaling, plus a naturally taller/larger-size alternative.
2. **Workout hero:** stacked LOWER / BODY display typography with topographic contours and a Start workout action.
3. **Depth C:** TEMPO / RUN with a route crossing in front of the title.
4. **Hero statistic:** 12.4 with a quieter decorative ghost 20.
5. **Depth B:** oversized 18 partially tucked behind a November summary card.

The HTML embeds font resources for the browser specimen. Android must continue using approved locally bundled font files and licences; this HTML does not approve a network font dependency or another app font.

## Owner-approved visual direction carried forward

- Preserve **Depth B** (number tucked behind a card) and **Depth C** (route crossing in front of typography).
- Selective tall/elongated display typography is wanted; Variant C is the selected visual direction, not a general UI text treatment.
- Depth compositions should be deliberate, restrained, readable and accessible. Prefer clipping, overlap, occlusion and foreground/background ordering over fake 3D or excessive shadows.
- Existing Old Money × Liquid Glass identity, palette and approved font families remain unchanged.

## Refinement 1 — delivered 2026-11-21

Targeted refinement of the original board; no redesign and no application code changes. The original is kept at `design/type-depth/archive/aeruno-type-depth-board-v1-original.html`. Evidence tag **[S]** means headless Chromium (Playwright) in an AI sandbox, never a phone test.

| # | Request | What changed |
|---|---|---|
| 1 | Start workout wrapping | Button label is `nowrap`, does not shrink and keeps a 48 px touch height. Session facts beside it use two short lines (“35 min” / “6 exercises”) because the one-line version collided with the button at 360 px. **[S]** one line at 320, 360, 375, 390, 412 and 430 px; no horizontal scroll. |
| 2 | Depth C metadata/title spacing | Explicit spacing now reserves room for the ×1.14 title. **[S]** measured ink gap label-to-title about 20–24 px and title-to-run-facts about 29–30 px. “Warm-up · Tempo / Cool-down” no longer breaks mid-word. |
| 3 | Route placement | TEMPO previously clipped at the right edge. It now fits inside the card with about 21–27 px right margin at measured widths; it is slightly smaller (35% of card width rather than 38%). The route still crosses RUN and TEMPO and ends in clear space below the O. Title and label share a 20 px left edge. |
| 4 | Depth B | Composition retained; oversized 18 remains behind the card. It is `aria-hidden`; the real figure is in card text. |
| 5 | Ghost numeral | Kept quiet (Surface Alt at 70%, bottom corner), `aria-hidden`; the goal is also written in the label. |
| 6 | A/B/C/D comparison | Retained for review; labels/gaps equalised. Variant C was not marked approved until the owner made the selection separately. |
| 7 | Render checks | **[S]** 360, 390 and 412 px at 2.5x, all five sections: `design/type-depth/render-checks/refinement-1/`. Fonts reported loaded. |

The workout-hero title was also aligned with its label at a 20 px left edge.

## What remains untested

- No production Android, Compose or WebView implementation of Variant C.
- No proof of performance, animation cost or accessibility at 200% system font size.
- No dark-mode board and no full screen-reader test on a device.
- Font licence interpretation for vertical scaling has not been checked. The app must continue using the approved bundled Big Shoulders / Instrument Serif / Inter files unless the owner approves otherwise.
- Headless-browser renders are not proof of real-device legibility at ordinary viewing distance.

## Next design checkpoint

The Type & Depth Board is closed. Do not repeat its A/B/C/D selection or redo the refinement. Use Variant C as the selected **visual direction** in the existing Design Foundation, while keeping implementation feasibility open. The current task is Foundation review/refinement, then owner approval; only after approval should the representative Plan screen begin.
