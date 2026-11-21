# AERUNO Type & Depth Board — review checkpoint

**Board:** `design/type-depth/aeruno-type-depth-board.html`  
**Claude artifact:** https://claude.ai/artifact/RgbjfH2Ep66UkxqrXU4FXw  
**Status:** Visual exploration delivered; **Refinement 1 delivered 2026-11-21** (see the last section); owner review and type selection remain. This is not application implementation.

## What's in the board

1. **Type comparison:** Big Shoulders at ×1.00, ×1.10 and ×1.14 vertical scaling, plus a naturally taller/larger-size alternative.
2. **Workout hero:** stacked LOWER / BODY display typography with topographic contours and a Start workout action.
3. **Depth C:** TEMPO / RUN with a route crossing in front of the title.
4. **Hero statistic:** 12.4 with a quieter decorative ghost 20.
5. **Depth B:** oversized 18 partially tucked behind a November summary card.

The HTML embeds the font resources for the browser specimen. Android implementation must continue to use the approved locally bundled font files and licences; this HTML does not approve a network font dependency or a new app font.

## Owner-approved visual direction carried forward

- The owner strongly likes **Depth B** (number tucked behind a card) and **Depth C** (route crossing in front of typography). Preserve these as important design directions.
- The owner wants selective tall/elongated display typography. It must not be applied to ordinary UI text.
- Depth compositions should be deliberate, restrained, readable and accessible. Prefer clipping, overlap, occlusion and foreground/background ordering over fake 3D or excessive shadows.
- Existing Old Money × Liquid Glass identity, palette and approved font families remain unchanged.

## Review observations and targeted fixes

### Typography

- The board compares A (×1.00), B (×1.10), C (×1.14) and D (larger native size, no scale).
- **Exact winner is not yet an owner-approved implementation token.** The ×1.14 sample is a strong candidate, but compare its glyph weight and readability with ×1.10 and D at actual phone size before locking the method.
- The HTML's `scaleY` is a visual experiment; it has not been implemented or tested in Compose or the production app.
- Anton is not approved as an additional app font. Keep the bundled Big Shoulders / Instrument Serif / Inter families unless the owner later approves a change.

### Workout hero

- Preserve the stacked LOWER / BODY composition and contour treatment.
- Fix the Start workout label wrapping on narrow mobile widths. Keep the label on one line and preserve a comfortable touch target.

### Depth C — running route over title

- Preserve the route crossing in front of the oversized TEMPO / RUN typography.
- Improve the breathing room between the run metadata and the title so the metadata is not visually crowded or obscured.
- Check route placement and word recognition at realistic mobile size and ordinary viewing distance. Keep any edge bleed restrained.

### Hero statistic / ghost numeral

- The quieter ghost 20 is a promising treatment. Keep it secondary to 12.4 and ensure the real goal remains plainly readable in text.

### Depth B — number behind card

- Preserve the core composition. It is one of the strongest explored treatments.
- Use selectively for weekly/monthly summaries, milestones or selected Progress moments, not every card.
- Keep the real number repeated in readable content; hide the purely decorative numeral from assistive technology.

## Next design task

Make a **small refinement pass** on this existing board, not a redesign:

1. Fix Start workout label wrapping.
2. Improve metadata/title spacing in Depth C.
3. Fine-tune route placement while preserving the route-over-type relationship.
4. Keep the quieter ghost numeral and verify it does not compete with the main statistic.
5. Retain the A/B/C/D type comparison so the owner can make the final choice from a phone preview.
6. Render and inspect at a realistic mobile viewport before publishing/exporting.

After the owner reviews the refined board, record the selected type treatment and finalize the reusable foundation. Do not start app implementation or architecture migration as part of this board correction.

## Refinement 1 — 2026-11-21 (delivered, awaiting owner review)

Targeted pass on the existing board. Nothing was restarted. The original is kept at `design/type-depth/archive/aeruno-type-depth-board-v1-original.html`. Evidence tags: **[S]** = headless Chromium (Playwright) in an AI sandbox; it is never a phone test.

| # | Request | What changed |
|---|---|---|
| 1 | Start workout wrapping | Button is `nowrap`, never shrinks, keeps a 48 px touch height. The session facts beside it are two short lines ("35 min" / "6 exercises") because the one-line version collided with the button at 360 px. **[S]** one line at 320, 360, 375, 390, 412 and 430 px; no horizontal scroll. |
| 2 | Depth C metadata/title spacing | The vertical scale was growing the title up into the "Run · Week 2 · Day 4" label (the spacing fix was cancelled by a CSS override). Spacing is now reserved explicitly. **[S]** measured ink gaps: label to title about 20–24 px (was overlapping), title to run facts about 29–30 px. The "Warm-up · Tempo / Cool-down" line also no longer breaks mid-word. |
| 3 | Route placement | "TEMPO" ran off the right edge (about 3–7% of the O clipped depending on width **[S]**, and no margin at all); it is now fully inside the card with about 21–27 px right margin at the measured widths, in a slightly smaller size (35% of card width, was 38%). The route keeps its forest casing and still crosses RUN and TEMPO. It now ends in a clear spot below the O instead of leaving through the edge with a dot sitting on a letter. Title left edge now lines up with the label (20 px). |
| 4 | Depth B | Unchanged composition; the oversized 18 stays behind the card. Only 14 px of space was added under the section title so the numeral does not touch it. Still `aria-hidden`; the real figure is in the card text. |
| 5 | Ghost numeral | Unchanged (Surface Alt at 70%, bottom corner). Still `aria-hidden`; the goal is in the label. |
| 6 | A/B/C/D comparison | Retained. Label gaps equalised (about 10–13 px). Variant C no longer says "approved": no type treatment is selected. |
| 7 | Render checks | **[S]** 360, 390 and 412 px at 2.5x, all five sections: `design/type-depth/render-checks/refinement-1/`. Fonts reported loaded. |

Also tidied: workout-hero title now lines up with its label at 20 px (it sat about 4 px right).

**Not tested:** any real phone (the owner's OnePlus or otherwise), the owner's WebView, ordinary-viewing-distance legibility, dark mode (the board is light-only), screen-reader behaviour, Android/Compose implementation of `scaleY`, performance of any effect. The HTML transforms are a visual experiment, not proof of Android feasibility. Anton is still not approved; fonts remain the bundled Big Shoulders / Instrument Serif / Inter.

**Owner decision (2026-11-21): variant C**, Big Shoulders Display Black at ×1.14 vertical scale, for selective display type only (hero title, major workout/category words, one hero statistic per screen). Not approved for Android until a Compose/WebView check; the earlier "never stretch fonts" note is a deliberate display-only exception.
