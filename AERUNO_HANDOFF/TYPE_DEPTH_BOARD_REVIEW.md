# AERUNO Type & Depth Board — review checkpoint

**Board:** `design/type-depth/aeruno-type-depth-board.html`  
**Claude artifact:** https://claude.ai/artifact/RgbjfH2Ep66UkxqrXU4FXw  
**Status:** Visual exploration delivered; targeted refinements and owner review remain. This is not application implementation.

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
