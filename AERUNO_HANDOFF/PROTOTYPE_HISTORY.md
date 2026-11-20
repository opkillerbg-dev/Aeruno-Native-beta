# Prototype and experiment history

Tags: see `../START_HERE.md`. The native prototype (`app/`) is an **experiment**, not the final application. Nothing in it is a requirement for the final app unless the owner adopts it. Each card has a log in `docs/log/`; the card plan is `AGENTS.md` Part 2 section 9.

## Purpose of the prototype
Answer one question cheaply: is a native Kotlin/Compose UI worth it compared with the legacy WebView UI (look, type, glass quality, smoothness)? Rules: mock data only, debug builds only, one card at a time, no claims of "smooth" or "fast" without measurement [V `AGENTS.md` sections 1 and 3]. The planned GO/NO-GO (card N08) was never reached.

## Timeline
| Card | What | Result and evidence |
|---|---|---|
| N00 Baseline (2026-11-19) | Inspect the repo and the legacy ZIP; record facts | Done and reviewed. `docs/BASELINE_LEGACY.md`, `docs/log/2026-11-19_N00.md` [D] |
| N01 Skeleton + CI (2026-11-19) | Empty Compose app, GitHub Actions debug build, `update.zip` unpacker | GitHub Actions run "Build debug APK #4" green; the owner installed and saw the blank AERUNO screen on his Android 16 phone [D `AGENTS.md` section 0, `docs/log/2026-11-19_N01.md`] |
| N02 Tokens + fonts (2026-11-20) | Palette, spacing, type scale, bundled fonts (Big Shoulders Display Black, Instrument Serif Italic, Inter), type specimen screen | **Owner confirmed** green build, status bar and display type on his phone [D `AGENTS.md`]. Replaced an earlier Manrope choice. Refinement logs: `docs/log/2026-11-20_N02-refinement.md`, `..._N02-refinement2.md` |
| N03 Glass card test (2026-11-20) | One sample card on a static background, switch between A real glass (Haze backdrop blur), B translucent (75% white, no blur), C solid | **Owner confirmed** the build and that A is genuine backdrop blur, not a flat tint [D `AGENTS.md`]. Haze 1.7.2 chosen over 2.x (toolchain). Files: `ui/glass/GlassSurface.kt`, `ui/cardtest/CardTestScreen.kt`. Log `docs/log/2026-11-20_N03.md` |
| N04 Top progressive blur (2026-11-20) | Scrolling mock content under a top-edge blur that fades to none (Haze `HazeProgressive.verticalGradient`); A progressive vs B none | Delivered as `update.zip`. **Whether it built and how it looked is not recorded in this repo**; the owner later described these experiments as "visually approved as directions worth exploring" [O]. Files: `ui/glass/ProgressiveEdgeBlur.kt`, `ui/topblur/TopBlurTestScreen.kt`. Log `docs/log/2026-11-20_N04.md` lists its untested items |

## The "N04" naming accident (read this)
Three different things were called N04:
1. **Original plan:** N04 = Today screen (greeting, hero card). Now renamed **N04b**, deferred, never built.
2. **Owner brief 2026-11-20:** N04 = top progressive blur test (the table row above).
3. **Owner brief later the same day:** "N04 floating glass bottom navigation" written for the legacy WebView app (CSS/JS). **Not implemented.** It did not match the prototype (no navigation exists there) and needed legacy CSS that was then unavailable; the owner then reset the project to a full redesign. Treat it as an idea only.
Card numbers N05 to N08 (benchmark, docs, owner device test, GO/NO-GO) were never started.

## What was tested, approved, and not
| Item | Built in CI | Seen on phone | Approved by owner | Performance measured |
|---|---|---|---|---|
| Fonts and type specimen (N02) | Yes | Yes | Yes | No |
| Palette A (ivory, forest, terracotta ...) | Yes | Yes | Yes | n/a |
| Glass card, real backdrop blur (N03) | Yes | Yes | Yes (A is real blur) | **No** |
| Translucent and solid surfaces (N03 B and C) | Yes | Yes | Part of the same comparison | No |
| Progressive top blur (N04) | Not recorded | Not recorded | "Approved direction" [O] | **No** |
| Floating glass navigation | Not built | No | No | No |
No frame-time, jank, battery or thermal measurement exists for any effect. The benchmark card (N05) was planned and not done. The legacy app's lag with its WebView glass look was reported by the owner and its cause is unproven.

## Experimental versus final
- Experimental only: all of `app/` including `GlassSurface`, `TopProgressiveBlur`, the three screens, their tuning constants, the dependency Haze, the temporary app id `com.aeruno.nativeprototype`, minSdk 31.
- Carried forward as direction, pending the architecture decision: palette, type families, the principle "solid carries information; glass only where it earns it".
