# Foundation v0.2 — owner review and continuation notes

**Status:** Visual exploration received and inspected. The board itself says **“Exploration · not approved”**. This review records the owner's preferences; it does not approve every proposal in the HTML or approve app implementation.

## Source artifact

- Repository path: `design/foundation-v02/aeruno-foundation-v02.html`
- Original upload SHA-256: `da90ac3a64ddc4265138f014038720c1170f685f9c7d10254a7f61a74536a6cd`
- Original HTML is preserved byte-for-byte.
- The HTML uses Google Fonts in its browser preview, including Anton for one comparison specimen. This is not approval to add Anton or any network font dependency to the app. Android must continue using the bundled approved font files and licences.

## Owner's design intent

The owner wants a distinctive editorial/athletic interface, not generic fitness UI. The existing **Old Money × Liquid Glass** identity, established palette and three approved font families remain the baseline:

- Big Shoulders Display Black — display typography.
- Instrument Serif Italic — restrained editorial accent.
- Inter — functional UI, body, labels and metrics.

The owner specifically wants selective tall/elongated display typography in some visual moments, not throughout the interface. This direction is wanted; the exact implementation method and scale are not yet selected.

## v0.2 ideas to carry forward

### Depth B — large number tucked behind a card (HTML section 4)

**Strongly liked by the owner. Preserve this direction.** A decorative oversized numeral extends above a solid summary card and is occluded by the card. The same fact is stated in readable text inside the card, while the decorative numeral is hidden from assistive technology. Intended for weekly/monthly summary moments, not every card.

Refine only as needed for balance, legibility and spacing. Do not flatten or discard this concept during the next iteration.

### Depth C — route crosses in front of the word (HTML section 5)

**Strongly liked by the owner. Preserve this direction.** The route graphic crosses in front of oversized running typography. The double-stroke route treatment creates a deliberate gap/cut through the letters and communicates clear foreground/background ordering. It is a strong candidate for the running hero.

Refine its crop, placement and text fit without losing the route-over-type interaction. Keep the route decorative and preserve accessible text labels for the run information.

## Direction wanted, exact treatment still to decide

### Selective tall / elongated display type (HTML section 1)

The owner wants this visual quality selectively. The board compares the same word at vertical scale 1.00, 1.15 and 1.30 and also shows Anton as an alternative.

Important facts and constraints:

- The existing bundled Big Shoulders Display Black file is static and has no width/variable axis (as documented in the v0.2 board and existing type setup).
- The current Kotlin type system does not yet approve `scaleY` on text. Existing prototype guidance says not to stretch or scale the font; this is a historical implementation constraint that must be consciously reviewed before changing code.
- A mild display-only scale around 1.10–1.15 is an exploration, not an approved token. The 1.30 sample looks excessive and is not recommended by the v0.2 board.
- Prefer comparing larger native font sizes and tighter line-height against a mild vertical transform before selecting a method. Test glyph weight, legibility, clipping and accessibility at real phone sizes.
- Anton is only an alternative specimen loaded from Google Fonts in the HTML. It is not approved as a new app font.

Use expressive display treatment only for selected hero titles, major workout/category words and a small number of high-impact statistics. Keep body text, exercise names, forms, settings, buttons, chips, navigation and timers in the normal readable type system.

## Items needing refinement

### Depth A — title sinks behind a ledge (HTML section 3)

The idea is not selected as-is. The title/ledge overlap and amount of covered text need refinement. Keep it as an optional exploration, not a default hero treatment. The word must remain identifiable and essential workout information must never be hidden.

### Numbers treatment (HTML section 6)

The oversized ghost “20” is decorative and has a duplicate textual goal label. It needs refinement so it supports, rather than competes with, the primary `12.4` value. Adjust scale, opacity, crop and placement during the next design iteration. Decorative numerals must stay hidden from assistive technology and must not replace meaningful text.

### Ordinary vs expressive comparison (HTML section 2)

Keep the comparison as a useful specimen, but make the visual difference and intended use more obvious. Expressive typography is selective, not a replacement for all ordinary UI typography.

## Usage principles to validate

The v0.2 board proposes:

- Expressive treatment for workout/running heroes, selected weekly/monthly summaries, a major hero statistic, PR/completion moments and a Progress screen title.
- Keep lists, exercise names, forms, settings, navigation, session pill, sheets, buttons, chips, timers and body text flat and readable.
- Limit depth compositions to a deliberate focal moment rather than layering every component.
- Avoid animation of the text layering; respect reduced-motion settings.
- Decorative cropped/ghost elements must not conceal essential content and must have accessible text equivalents where needed.

The exact crop limits in v0.2 (≤20% crop and ≥80% of each glyph visible) are proposed guardrails, not a final approved universal rule. Review them against each actual composition.

## Technical notes — not implementation approval

The HTML suggests Compose techniques such as `Box` z-order, `clipToBounds`, `graphicsLayer` vertical scale and container-width fractions. These are proposals and have not been implemented or tested in Compose or on the owner's phone. The HTML is a design specimen, not proof of implementation or performance.

## Next design task

Refine the existing Foundation v0.2 board; do not restart it. Preserve Depth B and Depth C as the strongest directions, explore the selective tall display direction without locking the exact transform, refine Depth A and the ghost-number treatment, and produce a clean mobile-readable comparison. Keep all app code and architecture unchanged until the owner approves the design foundation and implementation phase.
