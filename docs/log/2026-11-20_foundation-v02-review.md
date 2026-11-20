# Foundation v0.2 archive and review record

## Changed
- Added the original Foundation v0.2 HTML export at `design/foundation-v02/aeruno-foundation-v02.html`.
- Added a folder guide and `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` with owner preferences and unresolved refinements.
- Updated `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` and `START_HERE.md` so a new AI account starts at Foundation v0.2 refinement, not an older phase.

## Evidence
- VERIFIED: inspected the uploaded HTML content and its CSS/markup. It contains specimens for tall type, ordinary-vs-expressive typography, Depth A (title under ledge), Depth B (number behind card), Depth C (route over word), a ghost-number statistic treatment and usage rules.
- VERIFIED: compared the font, color and glass claims against repository `Color.kt`, `Type.kt`, `Dimens.kt` and `GlassSurface.kt` during the related review.
- VERIFIED: source HTML copied byte-for-byte; SHA-256 `da90ac3a64ddc4265138f014038720c1170f685f9c7d10254a7f61a74536a6cd`.

## Owner preferences recorded
- Strongly likes Depth B (number tucked behind a card) and Depth C (route crossing in front of the word); retain these directions.
- Wants selective tall/elongated display typography; exact technique and scale remain unresolved.
- Depth A and ghost-number treatment need refinement, not automatic approval.

## Untested / not done
- No application code changed.
- No Compose implementation, build, device rendering or performance test was performed.
- No architecture choice was made.

## Next
Refine Foundation v0.2 visually, preserving Depth B and C; resolve typography scale and refine Depth A / ghost-number treatment before owner review.
