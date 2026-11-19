# Design tokens (N02)

Source of truth is the code: `ui/theme/Color.kt`, `Dimens.kt`, `Type.kt`, `Theme.kt`. Direction and contrast rules: `AGENTS.md` section 7. Everything here is UNTESTED on a device until the owner checks the specimen screen.

## Colors (`AerunoColors`, unchanged since N01)
background #F5F2E8, surface #FFFEFA, surfaceAlt #E7E2D6, forest #243D30, deepForest #172A21, olive #729900, sage #DCE5D7, brass #A98542, text #202A23, textMuted #687167, border #D8D9CE, danger #B55345. Olive and brass: fills, lines, icons, large type only.

## Spacing and radii (`Spacing`, `Radii`, unchanged)
Spacing dp: 4, 8, 12, 16, 20, 24, 32, 40. Radii dp: button 12, chip 14, icon button 16, card 22, hero 28, nav 28, sheet 28.

## Fonts (`AerunoFonts`, `res/font`)
| Role | Family | Files | Use |
|---|---|---|---|
| Display | Big Shoulders Display, Black 900 | `big_shoulders_display_black.ttf` | Hero numbers, screen and workout titles. Short and big. Never paragraphs. |
| Accent | Instrument Serif, Italic | `instrument_serif_italic.ttf` | Editorial accent, one per screen at most. Never body copy. |
| UI | Inter, Regular 400 + Bold 700 | `inter_regular.ttf`, `inter_bold.ttf` | Everything else. |

Only these weights exist. No Medium or SemiBold, so none is requested (no faked weights).

## Type scale (`AerunoType`, sp, size/line height)
heroStat 64/68 (tracking -0.5), displayLarge 52/56, displayMedium 40/44, screenTitle 34/38 (all Big Shoulders Black); accentLarge 40/44, accentMedium 28/32 (Instrument Serif Italic); headline 22/28, cardTitle 18/24 (Inter Bold); bodyLarge 16/24, body 14/20, caption 11/16 (Inter Regular); button 15/20 (Inter Bold); label 12/16 (Inter Bold, tracking 0.8, write text in uppercase); timer 32/36 and statNumber 22/28 (Inter Bold, `tnum`).

`AerunoTypography` maps these onto the Material text slots, so any Material component also uses AERUNO fonts.

## Known limits
- Big Shoulders has no `tnum` feature and its digit widths differ (the "1" is narrow). Big stats are not tabular. Timers use Inter.
- The bundled font files are web subsets (about 220 to 520 glyphs, Latin). The specimen "Glyph check" shows whether the characters we need exist. Anything outside Latin will fall back to the system font.
- Condensed display sizes (52 to 64 sp) are first guesses. Tune after the phone check.
- Font files came from the legacy app's `web/fonts` (WOFF2) converted to TTF by the owner's previous session. Not byte-compared with upstream.

## Licenses
SIL Open Font License 1.1, one file per family in `app/src/main/assets/font-licenses/`, so they ship inside the APK. The copyright lines come from each font file's own metadata. For Big Shoulders the line matches the upstream project (checked on the web 2026-11-20). For Instrument Serif and Inter the line comes from the font file only; the upstream license files were not fetched.
