# AGENTS.md: rules for any AI working in this repository

Read `START_HERE.md` and the documents in `AERUNO_HANDOFF/` before suggesting or changing anything. This file has two parts: **Part 1** general rules (this section), **Part 2** the native prototype's own plan and protocol (the original AGENTS.md, kept intact below).

## Part 1. General rules (all AI assistants)

1. **Inspect before you act.** Open the real files. Repo documentation can be stale; the source and the `AERUNO_HANDOFF/` evidence tags tell you how far to trust a statement.
2. **Evidence honesty.** Never say "tested", "works", "smooth" or "fast" without naming what was run and where. A sandbox run is not a phone test. See the tags in `START_HERE.md`.
3. **The owner decides.** Architecture, identity, signing, design direction. Offer two options and a recommendation; never settle a disagreement silently.
4. **Current architecture (owner decision 2026-11-23): Path A — Kotlin + Jetpack Compose.** The owner selected the native Android route. HTML files are design/interaction specifications, not automatically converted production screens. Approved screens must be recreated in Compose. Follow `AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`; do not silently switch to Path B.
5. **Two codebases, do not mix them up.** The legacy app (`AERUNO_HANDOFF/legacy-reference/`, a read-only copy at v150) is the functional asset. The native prototype (`app/`) is an experiment. Never edit `AERUNO_HANDOFF/legacy-reference/`; if legacy needs changing, that happens in the legacy repository and only with the owner's explicit OK.
6. **Frozen without explicit OK:** legacy app id (`com.arya.fit3`) and signing key, storage key `aryaApp2`, storage schema and backup format, native service architecture. The prototype's own id (`com.aeruno.nativeprototype`) is temporary.
7. **Security.** The repo is public. No keystores, passwords, tokens, API keys, personal data or backups. The legacy `debug.keystore` was deliberately not copied here.
8. **Scope.** Small, reviewable phases. No unrelated changes, no new dependencies without a one-line reason, no big rewrites in one step.
9. **Design.** Use the established identity in `AERUNO_HANDOFF/DESIGN_SYSTEM.md` (Old Money x Liquid Glass; fixed palette and fonts). Visual decisions belong to the owner with ChatGPT's direction; implement them, raise technical concerns.
10. **Talk to the owner in plain words** (see Part 2, "Talking to the owner"). He tests on a real Android phone.
11. **Record what you do** in `docs/log/` (prototype) and say what is untested.

---

## Part 2. Native prototype plan and rules (historical proof-work plan)

The owner selected Path A on 2026-11-23. The N00–N08 cards below were written for the earlier bounded native prototype experiment, not as the full production-app roadmap. N04/N05 and related remaining cards are still useful native visual-quality/performance checks. They do not automatically reopen the Path A vs Path B choice. Follow `AERUNO_HANDOFF/ROADMAP.md` and `IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md` for the actual full-app sequence. Card numbers N04 and later changed meaning once (see `AERUNO_HANDOFF/PROTOTYPE_HISTORY.md`).

# AERUNO Native Prototype: plan and rules for every AI

Repo: `opkillerbg-dev/Aeruno-Native-beta` (public). Read this whole file first. Keep it under ~250 lines; when a fact changes, change it here.
Created 2026-11-19. N00 to N03 were completed as bounded prototype work. N04 (top progressive blur) was delivered, but its owner build/visual gate was not confirmed in the source snapshot used for this update. On 2026-11-23 the owner selected Path A. The remaining cards are native quality/benchmark checks, not the full app delivery plan.

## 0. Current state (update after every card)

- **Done:** N00 baseline. N01 skeleton + CI: GitHub Actions run "Build debug APK #4" (commit 93a3528) was green and produced the artifact `aeruno-native-debug-apk`; the owner installed it and saw the blank AERUNO screen on his phone (his screenshot). The Gradle build compiled Kotlin 2.3.0, Compose BOM 2026.05.00, AGP 8.13.2, Gradle 8.13 together; the app id and minSdk 31 were checked inside the built APK by the workflow.
- **N02 (done 2026-11-20: owner confirmed green build, status bar and display type on his phone):** typography tokens, bundled fonts + OFL licenses, type specimen screen (now the only screen), `docs/DESIGN_TOKENS.md`. Fonts are the owner-approved set Big Shoulders Display 900, Instrument Serif Italic, Inter Regular/Bold (same as the legacy app), replacing the Manrope plan. Refinement 1 (owner approved palette and type): Palette A Deep Heritage, dark status-bar icons, compact stats in Inter Bold tnum, font notices checked. Refinement 2 (UNTESTED): status-bar cover so scrolling content no longer passes under the clock/icons; tighter, larger display styles. 
- **N03 (done 2026-11-20: owner confirmed the build and that variant A is real backdrop blur):** `ui/glass/GlassSurface.kt`, `ui/cardtest/CardTestScreen.kt`, Haze 1.7.2 (`docs/VERSIONS.md`). Screen file stays in the repo, unused.
- **N04 (owner brief 2026-11-20, delivered, UNTESTED, gate pending):** top-edge progressive blur test. Owner redefined N04; the old "Today screen" card is now N04b (deferred). Files: `ui/glass/ProgressiveEdgeBlur.kt` (Haze `HazeProgressive.verticalGradient`, 1.7.2, no new dependency), `ui/topblur/TopBlurTestScreen.kt` (now the only screen), `MainActivity.kt` (shows it; nav-bar icons back to dark). Log: `docs/log/2026-11-20_N04.md`. Not `[x]` until a green build and the owner confirms the look on the phone.
- **Next native proof task:** close the N04 build/phone review gate, then N05 benchmark. These checks validate native visual/performance quality within the selected Path A direction; they are not a renewed architecture vote.
- **How code reaches the repo:** the owner uploads `update.zip` (changed files, repo paths) to the repo root; the `Apply update` workflow unpacks it and starts a build. Files under `.github/` are skipped by it and are pasted in by hand.
- **Installing:** every CI build has a fresh debug key, so the owner uninstalls the previous prototype first.
- **Not verified yet:** that the N04 code builds, that the top blur looks right, speed. Fonts, palette and status bar were confirmed by the owner in N02.
- **Legacy source:** `AERUNO_HANDOFF/legacy-reference/` (read-only copy of legacy repo v150, never edited, never built; see `AERUNO_HANDOFF/SOURCE_MANIFEST.md`). The older `reference/` folder, if the owner added it, is a smaller frozen subset and is superseded.

## 1. What this is (and is not)

A small, bounded **native UI/quality prototype**: it contains early Compose/theme/glass experiments and is not the complete AERUNO application. The owner has since selected Path A (native Kotlin + Jetpack Compose) on 2026-11-23. This prototype is a technical starting point and evidence source, not automatically a production-ready app. Follow `AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md` for the full migration and implementation sequence.

The legacy app (Arya Fit / AERUNO, Capacitor, `com.arya.fit3`) stays untouched and stable in its separate repository. The N04/N05 cards validate native UI quality/performance; they do not decide between Path A and Path B.

The web "V2" glass look lagged badly on the owner's phone (OnePlus Nord CE5, 8 GB, high refresh rate). **The cause is unproven.** Never state blur, WebView or GPU as the cause without measurement.

## 2. People and roles

| Who | Role |
|---|---|
| Owner (19, learning, not a professional developer; see "Talking to the owner") | Makes every decision. Installs the APK, tests on the real phone, says GO / NO-GO. Explain things in plain words. |
| ChatGPT | Visual direction and taste (section 7). Reviews screenshots and results. Does not own code. |
| Claude (and any coding AI) | Builds, tests what can be tested, runs the CI, reports honestly. |

Disagreements go to the owner as a short question with two options, never settled silently.

### Talking to the owner (every AI must follow this)

The owner is a 19-year-old learning by building. He is not a professional developer and does not know deep technical words. That is fine and expected; he is doing the real work of deciding and testing, and he should never feel talked down to.

1. **Plain words first.** Explain like to a smart friend who has never coded. If a technical term is unavoidable, give it in one short everyday sentence right there ("a build is the step where GitHub turns the code into an app file").
2. **Answer first, details after.** Start with what happened and what he needs to do. Technical detail goes in the log files, not the chat reply.
3. **Short steps, exact taps.** He works mostly from a phone. Say where to tap and what to type or paste. One thing at a time.
4. **No unexplained labels.** Words like UNTESTED, CI, lane or gate need a plain meaning the first time they appear in a reply.
5. **Say what could go wrong and what to do then**, in a sentence. Ask for a screenshot when something fails and say which part to capture.
6. **Decisions as simple choices.** Give two options, say which one you would pick and why, and keep the question to one at a time. Never hide a decision inside technical detail.
7. **Be honest, be kind.** Never claim something works when it was not tested. Mistakes are normal: say what went wrong and how it is fixed, without drama.
8. **Offer to teach, don't lecture.** A one-line "want me to explain how this works?" is welcome; long explanations he did not ask for are not.
9. **Files for the owner come with instructions** on where to put them and how to check they worked.

## 3. Hard rules (frozen without the owner's explicit OK)

1. Do not touch the legacy repo, its app id `com.arya.fit3`, its signing key, its data or its workflows.
2. Prototype app id: `com.aeruno.nativeprototype` (temporary, NOT a release identity). Release identity and signing are decided by the owner in a later phase.
3. **Debug builds only.** No keystores, passwords, tokens, API keys, personal data or backup files in the repo (it is public). No repo secrets needed; if a step seems to need one, stop and ask.
4. Mock data only. No GPS, steps, database, migration, notifications, onboarding, full navigation.
5. One card at a time (section 9). Do only that card, inside its lane. Do not start the next phase.
6. Never claim "builds", "smooth" or "fast" without the evidence named in section 10.
7. Keep it minimal: no extra architecture, no dependency without a one-line reason in the log.

## 4. Lanes

| Lane | Files | 
|---|---|
| BUILD | `build.gradle.kts`, `settings.gradle.kts`, `gradle/`, `.github/`, `.gitignore`, `tools/` |
| UI | `app/src/main/java/**`, `app/src/main/res/**` |
| DOCS | `README.md`, `docs/**`, this file |
| REFERENCE | `reference/**` | Read-only copy of legacy source and plans. No card edits it. It is not part of any build. |

A card names its lane. Touching another lane needs a note in the log saying why. Docs entries under `docs/log/` are always allowed.

## 5. Session protocol

1. Read only: this file, `docs/log/` (last 3 entries) and your task card in section 9.
2. Take the card the owner names; if none, the first open card whose dependencies are done.
3. Do only that card. If the work is bigger than it looked, stop at a green state and write `docs/log/WIP_<card>.md` (what is done, what is next).
4. Finish with: a log entry `docs/log/YYYY-MM-DD_<card>.md` + `update.zip` (changed files only, same paths as the repo) + a 5-line reply in plain words.
5. Log entry sections: Changed, Evidence, Untested, Needs (owner), Next. Label every claim as VERIFIED (how) or UNTESTED.
6. Mark the card `[x]` in section 9 only when its gate passed.

## 6. Tech decisions (proposed, owner may change)

- Kotlin + Jetpack Compose, Material 3 as a base only; custom theme, not a stock Material look.
- `minSdk 31` for the prototype (real RenderEffect blur starts at Android 12; avoids fallback code paths). The owner's phone runs Android 16 (owner-confirmed 2026-11-19), so minSdk 31 is accepted.
- Backdrop blur: **Haze 1.7.2** (chosen in N03; see `docs/VERSIONS.md`). `Modifier.blur()` on the card itself is foreground blur and does NOT count as glass. Keep the blur behind one `GlassSurface` composable so the library can be removed without touching callers. Pin exact versions; the implementer must check that the chosen versions exist and are compatible (Compose BOM, Kotlin, AGP, Gradle) because versions cannot be verified offline.
- Fonts bundled in `res/font`, no downloads (owner-approved 2026-11-20, replacing Manrope): Big Shoulders Display Black (display), Instrument Serif Italic (accent), Inter Regular + Bold (UI). All SIL OFL. Android cannot keep text files in `res/font`, so the license files live in `app/src/main/assets/font-licenses/` (packed into the APK).
- Measurement: platform `FrameMetrics` through `Window.OnFrameMetricsAvailableListener` (no extra dependency). JankStats is optional. Macrobenchmark is NOT used: it needs a connected device or emulator, which the CI does not have.
- Pinned versions and why: `docs/VERSIONS.md` (AGP 8.13.2, Gradle 8.13, Kotlin 2.3.0, Compose BOM 2026.05.00, compileSdk 36). Not proven until CI is green.
- CI: GitHub Actions workflow builds `assembleDebug` and uploads the APK as an artifact. No secrets, no signing.

## 7. Design direction: AERUNO, Verdant Glass

Editorial x athletic x premium. Calm, distinctive, minimal without feeling empty. Not a Material demo, not a glassmorphism template, not a dashboard of tiny boxes, not a ported web app. Solid surfaces carry information; blur and translucency add depth only where they earn it. Glass is a candidate technique, not the goal.

**Colors (use only these). Palette A "Deep Heritage", owner-selected 2026-11-20. Brand = ivory + deepForest + terracotta:**

| Token | Hex | Role |
|---|---|---|
| background (ivory) | #F3EFE4 | Brand. Screen background. |
| deepForest | #1F3B30 | Brand. Primary: buttons, headings, dark surfaces. |
| terracotta | #C97855 | Brand accent (replaces olive): fills, lines, icons, large decorative type. |
| surface | #FFFEFA | Neutral. Cards. |
| surfaceAlt | #E7E2D6 | Neutral. |
| sage | #DCE5D7 | Neutral. Soft fill. |
| text | #202A23 | Neutral. |
| textMuted | #646E65 | Neutral. Darkened from #687167 so it keeps 4.5 on the darker ivory. |
| border | #D8D9CE | Neutral. |
| danger | #B55345 | Semantic. |
| brass | #A98542 | Left from N01, unused. Candidate for removal. |

Removed in N02 refinement: olive #729900, the old forest #243D30 and the old deepForest #172A21 (merged into the new deepForest).

**Contrast checked (WCAG ratio, computed 2026-11-20):** text on ivory 12.9, on surface 14.7; textMuted on ivory 4.6, on surface 5.2; ivory on deepForest 10.6; surface on deepForest 12.1. **Below 4.5, so not for small text:** terracotta on ivory 2.9, on surface 3.3 (even large type on ivory is just under the 3.0 guide, so use terracotta for fills, lines, icons and decorative display only); text on terracotta 4.45 (terracotta buttons use text-colored labels, just under 4.5); deepForest on terracotta 3.65 and ivory on terracotta 2.9 (do not use); textMuted on surfaceAlt or sage 4.1; danger on ivory 4.3 (on surface 4.9). Primary button: deepForest fill with ivory text. Re-check any new combination.

**Type (Big Shoulders display, Instrument Serif accent, Inter UI; sizes in sp, size/line height):**

| Style | Font | Size |
|---|---|---|
| Hero stat | Big Shoulders Black | 72/66, tracking -0.5 |
| Display large / medium | Big Shoulders Black | 60/55, 44/40 (tracking 0, 0.3) |
| Screen title | Big Shoulders Black | 36/33 (tracking 0.3) |
| Accent large / medium | Instrument Serif Italic | 40/44, 28/32 |
| Headline | Inter Bold | 22/28 |
| Card title | Inter Bold | 18/24 |
| Body large / body | Inter Regular | 16/24, 14/20 |
| Button | Inter Bold | 15/20 |
| Label | Inter Bold | 12/16 (uppercase, tracking 0.8) |
| Caption | Inter Regular | 11/16 |
| Timer / stat numbers | Inter Bold, `tnum` | 32/36, 22/28 |

Big Shoulders is already condensed with tall capitals, so it is used at real larger sizes with tight leading (about 0.92 em), never stretched or scaled. Use it for uppercase, 1 to 3 word headings only; Instrument Serif sparingly as an editorial accent, never for body copy. Inter has only Regular and Bold bundled (no Medium or SemiBold). Values are first guesses until the owner checks them on the phone. Source: `Type.kt`; details: `docs/DESIGN_TOKENS.md`.

Rules: numbers visually dominant; tight tracking on big stats; tabular numerals (`fontFeatureSettings = "tnum"`) on timers and compact stats (Inter has it; Big Shoulders does not, so its big numbers are not tabular). Compact stats next to a hero number use Inter Bold 28 (`statCompact`); uppercase only for small labels; never shrink text to fit decoration; workout title prominent.

**Spacing (dp):** 4, 8, 12, 16, 20, 24, 32, 40. **Radii (dp):** button 12, chip 14, icon button 16, card 22, hero card 28, bottom nav 28, sheet 28.

**Motion:** button feedback 100 ms, press scale 0.97, selection 160 ms, card appear 220 ms, mock nav 220 ms, sheet 280 ms. Animate only transform and opacity. No continuously animated blur, background or shadow. No heavy transitions in benchmark mode.

**Glass parameters (start values, tune by eye and by measurement):** blur radius 16 dp (test up to 20), white surface alpha ~0.65, cream tint ~0.12, white border alpha ~0.35, minimal shadow.

## 8. The three-way card test

Three cards identical in size, content, type, layout, background, interaction and animation. **Only the surface differs:**

| Variant | Surface |
|---|---|
| A, real glass | Backdrop blur + translucent white + cream tint + thin white border + minimal shadow |
| B, translucent | White at ~75% opacity, NO blur, white border ~40% alpha, minimal shadow |
| C, solid | Solid #FFFEFA, no transparency, subtle neutral border, minimal shadow |

A selector switches A / B / C. The test background is static (cream-to-forest gradient plus a few soft shapes) so blur and translucency are visibly different. Never animate it.

## 9. Task cards

Order: N00 -> N01 -> N02 -> N03 -> N04 -> N05 -> N06 -> N07 -> N08. Each card ends with its gate.

- [x] **N00 Baseline (DOCS)** (done and reviewed 2026-11-19). Inspect the repo (branches, files, workflows). Confirm it is the native prototype repo and empty. Write `docs/BASELINE_LEGACY.md`: what the legacy app has, only from files the owner supplies; mark anything unverified. *Gate: file exists, every line marked verified or unverified.*
- [x] **N01 Skeleton + CI (BUILD, UI)** (done 2026-11-19: Build debug APK #4 green, APK installed and opened on the owner's Android 16 phone). Gradle project, `com.aeruno.nativeprototype`, one blank themed screen, `.gitignore`, workflow building `assembleDebug` and uploading the APK, README with build steps. *Gate: a green GitHub Actions run with the APK artifact (owner screenshot or log). Not "done" before that.*
- [x] **N02 Tokens + fonts (UI, DOCS)** (done 2026-11-20, owner confirmed on phone). Theme with the section 7 tokens, fonts bundled with licenses, a type-specimen screen, `docs/DESIGN_TOKENS.md`. *Gate: green build; specimen looks right on the phone.*
- [x] **N03 Card test (UI)** (done 2026-11-20, owner confirmed). Static background, `GlassSurface` (Haze evaluated, reason logged), variants A/B/C, selector. *Gate: green build; owner confirms A looks like real backdrop blur, not a flat tint.*
- [ ] **N04 Top progressive blur (UI)** (owner brief 2026-11-20; delivered, gate pending). Test screen only: scrolling mock content under a top-edge progressive blur (blur strongest at the top, fading to zero, ivory tint fading with it), A progressive / B no blur selector. No real controls, no navigation, not applied to other screens. *Gate: green build; owner confirms the transition is soft with no hard cutoff and content stays visible.*
- [ ] **N04b Today screen (UI)** (deferred; was N04 before the owner's brief). Greeting, date label, avatar button, hero "Lower Body" card (35 min, 6 exercises, Start Workout button), sample stats (8,420 steps; 42 min active; 4 day streak), minimal mock navigation, motion per section 7. Mock data only. *Gate: green build; owner reviews the look.*
- [ ] **N05 Benchmark (UI).** Benchmark mode: scripted scroll sequence (same distance, same timing every run) over the same content for a fixed duration, per variant; `FrameMetrics` collection; refresh rate recorded at start and end; battery temperature at start and end; results screen with a copy-to-clipboard text report. Optional live overlay (variant, mode, frame time, FPS estimate, slow-frame flag), updated at most twice per second, hidden in benchmark mode. *Gate: green build; a run finishes and shows the report.*
- [ ] **N06 Docs (DOCS).** README (build and install), `docs/BENCHMARK.md` (procedure, results template, limitations), verified/not-verified list. *Gate: a stranger could follow it.*
- [ ] **N07 Owner device test (OWNER).** Follow `docs/BENCHMARK.md`. Paste the reports into chat or `docs/results/`.
- [ ] **N08 Native proof-quality review (OWNER).** Review look, type, glass quality, responsiveness, measured numbers, battery/thermal feel and maintainability. Path A is already selected; this gate confirms implementation readiness/risks and does not reopen the architecture choice by default. ChatGPT reviews visuals; a coding AI summarises measured results.

## 10. Evidence rules

- **Build:** verified only by a real GitHub Actions run. The coding sandbox cannot download Android tools, so code is UNTESTED until CI is green. Never write "builds" before then.
- **Rendering and performance:** verified only on the owner's phone. CI says nothing about smoothness.
- **Each variant:** same conditions, at least 5 runs, order rotated between rounds (A,B,C then C,B,A), a short cool-down between runs, and runs with clearly different battery temperature are not compared. One run proves nothing.
- **Report per variant:** frame-time p50, p90, p95, p99 and max; slow-frame percentage against the real frame budget (8.33 ms at 120 Hz, 16.67 ms at 60 Hz); refresh rate at start and end; battery temperature at start and end; count of frames over 700 ms; run duration and date. Budget uses the measured refresh rate, not an assumed one (the phone may drop below 120 Hz).
- **Not measurable in-app, so not reported:** CPU load, GPU load. Do not invent them. Mark estimates as estimates.
- **Known limits to state in the results:** FrameMetrics reports platform frame timing, not what the eye sees; scripted scroll differs from a finger; blur cost depends on screen size and content behind it; a single phone model.

## 11. Known issues in the original brief (resolved here)

- Macrobenchmark was listed as "if feasible": it is not feasible in CI, so the scripted in-app benchmark replaces it.
- Terracotta (formerly olive) and brass fail the contrast check for small text on light surfaces (section 7).
- "Same refresh-rate configuration" cannot be forced from the app on every phone: record it, do not assume it.
- Library versions are not chosen here on purpose; N01 pins and logs them.

## 12. Decisions and open questions

**Decided by the owner (2026-11-19):**
1. The phone runs Android 16. `minSdk 31` is accepted.
2. `Aeruno-Native-beta` stays public.
3. Temporary app id `com.aeruno.nativeprototype` is approved.
4. Claude / the DOCS-lane AI keeps the section 9 checkboxes current after a card's gate passes.
5. Deliveries are an `update.zip` with changed files and their repo paths. The owner may add files by hand if needed.

**Proposed by N01 (both worked on 2026-11-19; owner has not objected):**
1. `Apply update` workflow: uploading `update.zip` to the repo root unpacks and commits it (needs no secrets; skips `.github/` files, which are added by hand).
2. Every CI build is signed with a fresh debug key, so the owner uninstalls the previous prototype before installing the next. Committing a key is forbidden (rule 3). Alternative later if this annoys: keep a generated debug key in the GitHub cache.

**Still open for later app phases:** production package ID, release signing/distribution, exact persistence schema, detailed data-import rules and any release-specific decisions. These do not change the completed Path A architecture selection.

## 13. Definition of done for the bounded native proof

The native visual proof is complete when it looks acceptable on the real phone; the type hierarchy is clear; variant A is confirmed as true backdrop blur; the variants are measured under the rules above; the verified/not-verified list is clear; and nothing in the frozen list was touched. This closes the prototype quality gate and informs Path A implementation; it is not a Path A vs Path B vote. The owner approves the next implementation slice separately.
