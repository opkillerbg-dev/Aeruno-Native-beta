# Architecture decision record

**STATUS: NO DECISION HAS BEEN MADE.** Neither path is approved. The prototype and an early plan assume native, and an earlier AI audit leaned toward native; a later investigation said the evidence is not yet sufficient, and the owner declined to commit until more evidence exists. Do not describe the native migration as decided. Tags: see `../START_HERE.md`; `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`.

## The two paths
**Path A: complete native Android redesign.** Kotlin + Jetpack Compose, using the prototype as a possible foundation; reuse the legacy Java services behind Kotlin adapters; port the logic; migrate data by import.
**Path B: complete Capacitor/WebView UI redesign.** Keep the Capacitor shell, plugins, services, storage and logic; rebuild the entire user-facing UI from scratch (the old UI does not constrain the design).

## Facts both paths share [V]
- The hard Android features (GPS service, step service, widgets, notifications, TTS, file sync) are already native Java and mostly independent of Capacitor (`ARCHITECTURE.md` section 4).
- Logic is split: 7 pure DOM-free engines with Node tests, plus many pieces entangled with globals and the DOM.
- Nothing proves that WebView glass is the cause of the reported lag, and nothing proves native is smoother (no measurement exists for either).

## Comparison (assessments are [I]; effort is a relative estimate, not a commitment)
| Criterion | Path A: native | Path B: WebView rebuild |
|---|---|---|
| UI freedom | Highest: shaders, real blur, shared transitions | High for layout/type/motion; glass limited to CSS filters |
| Performance | Unproven; more control and measurable with `FrameMetrics` | Unproven; main-thread JS and WebView compositing; legacy needed a governor |
| Liquid glass / blur | Haze backdrop blur confirmed visually in N03; progressive blur (N04) not confirmed | `backdrop-filter` exists in Chromium WebView; progressive blur possible in principle (CSS mask), untested; V2 glass lagged |
| Animation | Native, high refresh rate | Good for transform/opacity; weak under blur |
| GPS / background | Same services; needs new run-session persistence | Unchanged (but never device-tested) |
| Step tracking | Same service | Unchanged |
| Data preservation | Needs an import path (or same id and key plus export) | Trivial: same store and migrations |
| Complexity | Large: shell, navigation, state, database, port logic | Medium; entangled controllers are the hard part |
| Testing | Port Node tests as spec; Compose tests | Keep Node tests; Playwright cheap in CI; many UI tests obsolete |
| Maintainability | Typed, structured | ES5 globals, no types, no lockfile |
| Android integration | First-class | Via plugins |
| Long-term flexibility | Android only | Web code could reach other platforms |
| Main risks | Regressing working features; two codebases during transition | Performance ceiling unknown; fixing entangled glue |
| Realistic effort | Large (about 9 phases) | Medium (about 6 to 7 phases) |

## What would settle it (evidence still missing)
1. Does the legacy lag disappear in Lite mode? (owner test)
2. Legacy CSS review for glass layering cost (the CSS is now in `LEGACY/web/css/`; not yet analysed).
3. A native benchmark (card N05) and a comparable WebView measurement.
4. Real redacted backup to test import fidelity.
5. Compile/run status of legacy Java services on current Android.

## Current status
**UNDECIDED.** Next decision step is the owner's, after the architecture investigation. See `ROADMAP.md`.
