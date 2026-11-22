# Repository guide

## Current design repository status — 2026-11-22

- Current phase: Milestone 1 — product and design foundation. See `CURRENT_DESIGN_STATE.md` and `PRODUCT_AND_DEVELOPMENT_PLAN.md`.
- Current Plan candidate: `design/plan-screen/aeruno-plan-g01-v03.html` with `design/plan-screen/G01_V03_DESIGN_HANDOFF.md` and owner preview captures under `design/plan-screen/owner-captures/`.
- The existing `design/plan-screen/aeruno-plan-screen.html` and its render checks are the first functional/layout exploration, retained as historical research; do not treat it as the visual benchmark.
- The eight-image Visual Reference Pack v1 is a completed separate companion ZIP, not duplicated here.
- `app/` is the experimental native Compose prototype for later technical validation, not the final architecture.
- `AERUNO_HANDOFF/legacy-reference/` is a read-only v150 functional reference. Never edit it.
- `aeruno_update/` was a one-time staging package for the 2026-11-20 continuation note. That note is now copied into `AERUNO_HANDOFF/historical/`; after this update is applied, the two files in `aeruno_update/` can be deleted manually. The Apply update workflow itself cannot delete paths.

Tags: see `../START_HERE.md`. `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`.

## Repositories involved
| Repository | Purpose | In this ZIP? |
|---|---|---|
| `Aeruno-Native-beta` (this one, public) | Native Kotlin/Compose **prototype** plus this handoff package | Yes (root) |
| `Arya-Fit-app` (legacy) | The real app: functionality, data, native services | A read-only copy of v150 in `LEGACY/` (see `SOURCE_MANIFEST.md`); not the live repo and not its git history |

## Which is which
- **Legacy functionality:** `LEGACY/web/` (UI + logic, JavaScript), `LEGACY/native/java/` (Android services/plugins, Java), `LEGACY/tools/` and `LEGACY/.github/workflows/` (build).
- **Native prototype:** `app/` (Kotlin), `gradle/`, `.github/workflows/` at the repo root.
- **Experimental:** everything under `app/`. Also the "V2" layer inside legacy (`LEGACY/web/js/ui/v2-*.js`, `LEGACY/web/css/v2/`) is a visual layer on top of the older UI, still part of the shipped legacy app.
- **Part of the existing (legacy) application:** everything under `LEGACY/` except the docs noted below.

## Native prototype file map (repo root)
| Path | What it is |
|---|---|
| `app/src/main/java/com/aeruno/nativeprototype/MainActivity.kt` | Single activity; edge-to-edge; shows ONE test screen (currently `TopBlurTestScreen` if the N04 update was applied, otherwise the N03/N02 screen) |
| `.../ui/theme/` (`Color.kt`, `Dimens.kt`, `Type.kt`, `Theme.kt`) | Palette, spacing/radii, typography (`AerunoColors`, `Spacing`, `Radii`, `AerunoType`) |
| `.../ui/glass/GlassSurface.kt` | N03. Haze wrapper: `GlassSurface`, `rememberGlassBackdrop`, `glassBackdropSource`, `GlassTuning` |
| `.../ui/glass/ProgressiveEdgeBlur.kt` | N04. `TopProgressiveBlur`, `TopBlurTuning` (Haze progressive blur) |
| `.../ui/cardtest/CardTestScreen.kt` | N03 test screen (three card surfaces A/B/C) |
| `.../ui/topblur/TopBlurTestScreen.kt` | N04 test screen (top progressive blur, A/B) |
| `.../ui/specimen/TypeSpecimenScreen.kt` | N02 type specimen screen (unused since N03) |
| `app/src/main/res/font/*.ttf`, `app/src/main/assets/font-licenses/` | Bundled fonts and OFL licences |
| `gradle/libs.versions.toml`, `app/build.gradle.kts`, `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties` | Build config (pinned versions) |
| `.github/workflows/build.yml`, `apply-update.yml` | Build debug APK; unpack `update.zip` |
| `docs/` | `BASELINE_LEGACY.md`, `DESIGN_TOKENS.md`, `VERSIONS.md`, `log/` (one entry per card) |
| `AGENTS.md`, `START_HERE.md`, `AERUNO_HANDOFF/` | Rules and this handoff |

Caveat [I]: the N03 and N04 files above were delivered as `update.zip` packages in the author's session. Check they exist in your copy; `SOURCE_MANIFEST.md` explains which prototype state this handoff assumed.

## Legacy file map (`LEGACY/`)
| Path | Role |
|---|---|
| `README.md`, `docs/CURRENT.md` | Legacy overview and state (CURRENT.md is the legacy's own "start here") |
| `web/index.html` | Single page: markup for the shell, sheets and views (5 tabs plus day and plans views), 2 tiny theme-preload scripts; loads CSS then 68 classic scripts in a fixed order |
| `web/css/` | `base.css`, `boot.css`, `run-polish.css`, `perf-fallback.css`, `liquid.css`, `heavy-glass-nav.css`; `web/css/v2/` = 14 V2 files (tokens, shell, today, plan, progress, session-run, components, ...) |
| `web/js/core/` | State, storage, plan UI, timers/run, sheets and views, data import/export, steps UI, lifecycle |
| `web/js/features/` | One file per feature: pure engines (`plangen`, `coachcalc`, `levelcalc`, `retest`, `runcalc`, `gpx`, `exdb`) and feature UIs |
| `web/js/ui/` | Settings hub, home, motion, perf governor, V2 layer (`v2-*.js`) |
| `web/js/boot.js` | Loading screen; loaded last |
| `web/sw.js`, `web/manifest.webmanifest` | Service worker (cache `arya-v150`) and web manifest |
| `web/fonts/` | 4 woff2: Big Shoulders Display 900, Instrument Serif Italic, Inter 400 and 700 |
| `web/images/` | `exercises/` (62 webp), `exercise-masks/` (62), `hero/`, `anatomy/` |
| `web/icons/`, `web/v2-kit.html` | PWA icons; a standalone V2 component kit page |
| `native/java/` | 15 Java files: `MainActivity`, `RunService`, `RunTrack`, `RunEnginePlugin`, `StepsPlugin`, `SyncFilePlugin`, `AppWidgetPlugin`, `AppIconPlugin`, `VoiceKit`, `NotifKit`, `NotifText`, `WidgetKit`, three widget providers |
| `native/res/` | Splash, icons (6 selectable launcher icons), widget layouts and XML |
| `tools/` | CI helpers: `android-setup.sh`, `patch-manifest.sh`, `patch_*.py`, `check-web.py`, `check-ids.py`, test runners, icon generator |
| `tests/` | 16 Node tests (`*.test.js`), 34 Python/Playwright tests (`*_test.py`) and helpers |
| `.github/workflows/` | `build.yml` (APK), `apply-update.yml` (unpack `update.zip`). Inside this handoff they are inert copies (GitHub only runs root workflows) |
| `docs/` | `CURRENT.md`, `WORKFLOW.md`, `tasks/BACKLOG.md`, `DEVICE_TEST.md`, `PERMISSIONS.md`, `onboarding/` (plan-engine specs, exercise seed), `v1-simplify/`, `archive/` (history incl. V2 docs), `brand/`, `art/` |
| `signing/` | Fingerprint files only. `debug.keystore` intentionally NOT copied |

**Legacy docs that are NOT about legacy:** `LEGACY/docs/DESIGN_TOKENS.md` is byte-identical to the native prototype's N02 `docs/DESIGN_TOKENS.md` [S: `cmp`]. It describes Compose files (`Color.kt`) that do not exist in the legacy repo. Treat it as misplaced. The legacy app's own tokens are in `LEGACY/web/css/v2/tokens.css`.
