# AERUNO Current Design State — 2026-11-22

**Current milestone:** Milestone 1 — Product and design foundation.  
**Current screen:** Plan — G01 V03 scroll-aware editorial prototype.  
**Status:** Direction selected; V03 is a strong candidate but is **NOT Approved**.  
**Implementation:** Not started.  
**Architecture:** Native Kotlin/Compose vs redesigned Capacitor/WebView remains undecided.

## 1. Current handoff in one minute

AERUNO is not a new project. Continue the existing redesign from the completed visual foundation and the supplied Visual Reference Pack v1.

The owner selected **Concept B — Program Edition + Concept A — Training Route topographic language** for the Plan screen. Gemini produced G01 V03, which introduces the intended editorial hero, Depth B programme-duration numeral, Depth C route, variable-height weekly rhythm, Deep Forest session, Coming Up list, Progressive Blur and floating Liquid Glass navigation.

The owner likes this direction and wants natural scrolling. The previous instruction to fit every section and the CTA into one 844 px viewport is withdrawn. Do not compress the page just to avoid scrolling. The earlier unequal-height weekly rhythm is preferred over uniform bars.

The V03 HTML and handoff are now stored in `design/plan-screen/`. Owner-supplied captures are stored separately from formal render checks. The handoff says no automated headless-browser capture or Android/device test was performed by the artifact author. The owner's browser screenshots are visual review evidence only; they do not establish exact CSS viewport measurements or Android performance.

## 2. Completed work — do not repeat

- Eight-image **AERUNO Visual Reference Pack v1** and its reviews/rules/handoff: complete; supplied separately as a companion ZIP. It is the primary creative benchmark. Do not regenerate it or recreate the same review work.
- Round 2 visual baseline: Today strength, navigation states and Today running boards are complete and retained in `design/round-02/`.
- Type & Depth Board: refinement checkpoint complete; owner selected Variant C ×1.14 selectively. `design/type-depth/` is retained as a reference.
- Foundation Draft 1 is stored at `design/foundation-v1/aeruno-design-foundation.html`. The owner reports Foundation Draft 2 correction/review complete, but the actual Draft 2 file is absent from this repository copy. Treat Draft 2 as owner-reported context only; do not reconstruct or approve it.
- First Plan exploration `design/plan-screen/aeruno-plan-screen.html`: retained as functional/layout research only. Its earlier gaps are prior observations, not a fresh or exhaustive audit.
- Plan creative development: G01 V01/V02 led to G01 V03. V03 is the current proposed candidate; do not restart from earlier concepts.

## 3. Locked and selected direction

Inherited locked visual baseline:

- Old Money × Liquid Glass.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Fonts: Big Shoulders Display Black, Instrument Serif Italic and Inter.
- Selective Variant C: Big Shoulders Display Black ×1.14 vertical scale. Implementation remains untested.
- Session-pill timer: Big Shoulders Display Option 2, locked; outside Variant C scaling.
- Depth B: oversized number partially occluded by a foreground card.
- Depth C: route interacting with oversized typography.
- Navigation: Today · Plan · Train · Progress · Me.

Selected Plan treatment (not final-screen approval):

- Concept B composition plus Concept A's topographic route language.
- Programme-duration numeral, not the current-week number, anchors Depth B.
- Unequal weekly bars encode planned session duration where data supports it.
- Today and selected-day states are independent.
- Natural scroll is welcome; don't squeeze all content into one viewport.
- Progressive Blur is strongest at the top edge and fades downward without a visible cutoff.
- Liquid Glass is selective, especially for fixed bottom navigation; solid surfaces remain responsible for content and controls.

## 4. Current Plan artifact

- `design/plan-screen/aeruno-plan-g01-v03.html` — latest editable browser prototype.
- `design/plan-screen/G01_V03_DESIGN_HANDOFF.md` — design and implementation notes, proposed/open items, responsive intentions and evidence limits.
- `design/plan-screen/owner-captures/` — owner-supplied screenshots of the browser preview (not automated responsive captures).

V03 prototype includes:

- Programme identity and total-duration numeral `4` for the sample four-week plan.
- Depth C sage route with ivory-ringed terracotta markers.
- Compact three-metric current-week progress surface and segmented week status.
- Variable-height weekly rhythm with undulating route thread and `STR / RUN / REST` labels.
- Deep Forest selected-session hero.
- Schedule-derived Coming Up rows.
- Six-layer scroll-aware Progressive Blur prototype and fixed translucent Liquid Glass navigation.

The V03 actions for Manage, other tabs and workout launch are prototype notices, not implemented application flows. W1–W4 segments are visual progress, not approved week-navigation controls. Whole-plan calendar access and secondary session controls remain open.

## 5. Current next task

**G01 V04 — Product Completeness and Design QA** (brief: `AERUNO_HANDOFF/NEXT_TASK_G01_V04.md`). Do not start a new moodboard or re-generate the hero. Decide/represent the outstanding Plan behaviours:

1. Week browsing and the entry point to the full programme calendar.
2. Strength, run, rest/recovery, completed and upcoming session states.
3. Contextual access to edit sets/reps, individual exercise swap, reschedule preview, finish/reopen and rest-day choices.
4. Today versus selected-day independence.
5. Coming Up's role and selection behaviour.
6. Progressive Blur and Liquid Glass behaviour at multiple scroll positions, with readability and fallback.
7. Responsive, enlarged-text, touch-target and accessibility review.

After Main Plan is coherent, design **Manage Plan** as its own task. Then finish the other essential screen designs and shared user journeys. Follow `AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md`.

## 6. Wider milestones

1. **Product and design foundation:** essential screens, design system, interaction patterns, feature requirements and user journeys.
2. **Technical validation:** compare native Compose and redesigned Capacitor/WebView with focused, measured tests and compatibility checks. The existing native prototype is not the final architecture.
3. **Actual app development:** implement the selected architecture and approved product incrementally, preserve V1 functionality/data/workflows and test every phase.

## 7. Open / untested

- Final approval of the Plan screen and V03 composition.
- Week switching and whole-programme calendar entry.
- Manage Plan sheet and contextual secondary actions.
- Some conditional session states and detailed interaction flows.
- Progressive Blur and Liquid Glass performance and fallback on actual Android devices.
- Exact font metrics with bundled Android fonts, enlarged text, TalkBack and dark-mode behaviour.
- Native Compose vs Capacitor/WebView architecture.
- Foundation Draft 2 source file is not present; do not reconstruct it.

## 8. Preservation and evidence rules

- No app implementation, Android code, migration or architecture decision during current design work.
- Do not touch `AERUNO_HANDOFF/legacy-reference/`, legacy app IDs/signing, storage keys/schema, backups, native services or GitHub workflows.
- Keep old design artifacts when they contain useful history or functional research; clearly label them superseded rather than pretending they never existed.
- Do not infer that a browser prototype works on Android. Separate source inspection, browser preview, CI build and real-device evidence.
- Do not investigate V2 or repeat the old Smooth/Lite diagnostic.
