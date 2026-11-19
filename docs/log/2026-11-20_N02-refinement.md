# 2026-11-20 N02 refinement (lanes UI, DOCS)

**Status: DELIVERED, gate pending.** N02 is not marked complete. Needs a green GitHub Actions run and the owner's phone check of palette and status bar.

Owner input: typography approved (Big Shoulders Display Black, Instrument Serif Italic, Inter Regular + Bold, no new fonts). Palette A "Deep Heritage" selected.

## Changed
1. **Palette.** `Color.kt`: ivory/background #F3EFE4, deepForest #1F3B30, terracotta #C97855 are the brand colors. Olive, old forest and old deepForest removed. textMuted darkened #687167 to #646E65 because the darker ivory dropped it to 4.4 (now 4.6). Surface, surfaceAlt, sage, text, border, danger, brass unchanged (brass is unused, left in, flagged for removal). `Theme.kt`: primary deepForest, secondary terracotta (onSecondary text color). `colors.xml`: window background #F3EFE4. Specimen: accent "Today's plan" in terracotta, second button terracotta, palette swatches (brand colors first row, swatch text picks the higher-contrast label color), caption updated.
2. **Status bar.** Cause: `enableEdgeToEdge()` default style follows the phone's dark mode, so a phone in dark mode got white icons. Now `SystemBarStyle.light(transparent, transparent)` for status and navigation bars, plus `windowLightStatusBar` / `windowLightNavigationBar` in `themes.xml`.
3. **Compact stats.** Hero 8,420 stays Big Shoulders 64. "42" and "4" now use new `statCompact` (Inter Bold 28/32, `tnum`). Reason: Big Shoulders has no tnum, its "1" is much narrower than other digits, and 40 sp condensed next to a 64 sp hero looked like a second hero. Added one specimen row for the style. No other type style changed.
4. **Font licenses.** Copyright lines checked against upstream-derived sources; Inter line corrected to the upstream header "Copyright (c) 2016 ..."; license header URL set to the upstream `scripts.sil.org/OFL` form. Details: `docs/DESIGN_TOKENS.md`.
- `AGENTS.md` section 0, 7 (colors, contrast), 9, 11 and `docs/DESIGN_TOKENS.md` updated.
- No new dependencies, fonts, workflows or Gradle changes.

## Evidence
- VERIFIED (sandbox): contrast ratios computed from the hex values (listed in AGENTS.md section 7). Brace/paren balance of all Kotlin files. Old color names no longer referenced in Kotlin.
- VERIFIED (web search 2026-11-20): Big Shoulders copyright line (Font Squirrel license page); Instrument Serif line (copy of upstream OFL.txt header in a public repo, Google Fonts METADATA.pb); Inter header (package mirror quoting upstream LICENSE.txt). No Reserved Font Name appears in them.

## Findings the owner should know
- **Terracotta on ivory is 2.9 : 1** and on surface 3.3 : 1. Fine for fills, lines, icons, big decoration. The 40 sp "Today's plan" accent in terracotta on ivory is just under the 3.0 large-text guide.
- **Terracotta button label** uses text color: 4.45 : 1, just under 4.5. Ivory on terracotta would be 2.9, deepForest on terracotta 3.65.
- Danger #B55345 and terracotta are both warm red-orange; check on the phone that they read as different.

## UNTESTED
- That the code builds (no Kotlin/Android tools in the sandbox) until the Actions run is green.
- That the status-bar icons are dark on the phone, and that the xml `windowLight*` items do not conflict with `enableEdgeToEdge`.
- How the palette and the Inter stats look on the phone.
- Raw upstream license files were not downloaded; text is the standard OFL 1.1, copyright lines checked as above.

## Needs (owner)
1. Upload `update.zip` to the repo root, wait for the green build.
2. Uninstall the old app, install the new one.
3. Check: status-bar icons dark; ivory / deep forest / terracotta look right; "42" and "4" feel balanced next to 8,420; terracotta "Add set" button label readable. Send screenshots.
4. Say yes and I mark N02 done; N03 starts only on your go.

## Next
N03 Card test, after owner approval.
