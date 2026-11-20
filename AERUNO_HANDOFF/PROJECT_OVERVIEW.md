# Project overview

Evidence tags: see `../START_HERE.md`. Paths without a prefix are relative to the repository root; legacy paths start with `AERUNO_HANDOFF/legacy-reference/` (shortened to `LEGACY/` below).

## What AERUNO is
- A **personal fitness Android app**: workout plans, strength days, run/walk intervals, GPS run tracking, all-day step counting, progress and history, a plan builder, widgets and reminders. Tagline in the brand file: "Personal Fitness. Move · Track · Progress." [V `LEGACY/README.md`, `LEGACY/docs/brand/README.md`]
- Used by one person (the owner) on his own phone (OnePlus Nord CE5, Android 16) [O, D `docs/log/`, `AGENTS.md` section 12]. It is not published on a store [I: no store tooling in the repo; release signing is a "debug" key].
- Built by the owner together with AI assistants. The owner is the product owner and tester, not a professional developer.

## History
| Step | What | Evidence |
|---|---|---|
| Arya Fit | First name; a plain HTML/CSS/JS web app wrapped with Capacitor 6 as an Android APK, built by GitHub Actions. Internal codenames from that time remain everywhere: `arya`, `ax-`, storage key `aryaApp2`, package namespace `com.arya.fit`. | [V `LEGACY/README.md`, `LEGACY/capacitor.config.json`] |
| Many versions | The app evolved through about 150 numbered versions (v1 to v150). The cache name in the service worker is `arya-v150` and Settings shows "AERUNO · v150". | [V `LEGACY/web/sw.js`, `LEGACY/web/js/ui/settings.js`] |
| AERUNO | Public name AERUNO (AF monogram). Codenames deliberately NOT renamed, because renaming `aryaApp2` or the app id would reset user data. | [V `LEGACY/docs/brand/README.md`] |
| V1 simplification and V2 look | v142 to v149 simplified screens ("Home = what do I do now"). A separate "V2" visual layer (dark, iOS-like glass, `js/ui/v2-*.js`, `css/v2/`) was added on top of the old DOM. The owner reported the V2 glass look lagged on his phone; **the cause was never proven.** | [V file headers in `LEGACY/web/js/ui/`; D `AGENTS.md` section 1] |
| Native prototype | 2026-11-19: a new repository, `Aeruno-Native-beta`, started as a small Kotlin + Jetpack Compose prototype to test whether native UI (fonts, glass, blur, smoothness) is worth a migration. | [V `docs/log/2026-11-19_N00.md`, `AGENTS.md`] |
| Redesign reset | 2026-11-20: the owner restarted the effort as a **complete UI/UX redesign** (not incremental patches), asked for an audit, then an architecture investigation, then this handoff package. | [O] |

## Overall objective
Create a completely new AERUNO experience that feels like a thoughtfully designed premium app, not a reskin. Redesign: dashboard, navigation, workout and exercise screens, running/GPS and steps screens, planning, timers, progress/analytics, history, profile, settings, cards/buttons/sheets/dialogs, animation, typography, colour, spacing and overall identity. **The old UI is not a design constraint; the existing functionality is the asset** and should be preserved, reused, adapted or migrated wherever technically sensible. [O]

## Legacy application vs native prototype (do not confuse them)
| | Legacy application | Native prototype |
|---|---|---|
| Repo | The `Arya-Fit-app` repository (not this one). A read-only copy at v150 is in `AERUNO_HANDOFF/legacy-reference/`. | This repository, `Aeruno-Native-beta` (public). |
| Tech | Capacitor 6 WebView, plain ES5 JavaScript, Java native services | Kotlin 2.3.0, Jetpack Compose, Haze 1.7.2 |
| Contains | All real functionality: plans, timers, GPS runs, steps, storage, backup, widgets | **No functionality.** Mock text only: theme, fonts and three visual test screens |
| App id | `com.arya.fit3` in CI (namespace `com.arya.fit`); see `DATA_AND_MIGRATION.md` | `com.aeruno.nativeprototype` (temporary) |
| Status | Working app the owner uses [D `LEGACY/docs/CURRENT.md`]; not re-verified by this handoff | Disposable experiment by its own rules [V `AGENTS.md` section 1, rule 4 of section 3] |

## The ultimate goal
A new UI/UX for AERUNO with the established identity "Old Money x Liquid Glass" (`DESIGN_SYSTEM.md`), keeping the legacy app's functional systems working. Which technology builds it (native Compose, or a rebuilt WebView UI) is **undecided** (`ARCHITECTURE_DECISIONS.md`).
