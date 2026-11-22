# Next Task — G01 V04: Plan Product Completeness and Design QA

**Purpose:** finish the main Plan screen's product and interaction definition without discarding the visual direction established by G01 V03.

**Status:** proposed next task; owner approval is still required for all new design decisions.  
**Scope:** Main Plan screen only. The Manage Plan sheet is a separate following task.

## Required inputs

- `design/plan-screen/aeruno-plan-g01-v03.html`
- `design/plan-screen/G01_V03_DESIGN_HANDOFF.md`
- `design/plan-screen/README.md` (existing functionality research)
- The separate `AERUNO_Visual_Reference_Pack_v1.zip` and its eight images, if the design tool needs visual inspection. The reference pack is complete; do not regenerate it.
- `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-22.md`

## Owner-selected design direction to preserve

Concept B — Program Edition composition + Concept A — Training Route graphic language.

Preserve V03's strong candidate elements:

- Programme-duration Depth B numeral and foreground progress surface.
- Depth C sage route with ivory-ringed terracotta waypoints.
- Localized topographic contours.
- Big Shoulders / Instrument Serif / Inter hierarchy and selective Variant C.
- Compact programme-progress surface.
- Unequal-height weekly rhythm with undulating route thread.
- Deep Forest selected-session hero.
- Natural vertical scrolling.
- Progressive top-edge blur and fixed Liquid Glass navigation.
- Schedule-derived Coming Up sequence.

Do not compress the page to fit one viewport. Do not redesign the visual identity or generate another moodboard.

## Work to complete

### 1. Week navigation and whole-programme access

- Decide how the user moves between programme weeks.
- Keep W1–W4 as progress indicators unless an explicit week-navigation behaviour is designed and explained.
- Define a clear, restrained entry point to a whole-programme/28-day calendar.
- Describe selected-week, active-week and programme-boundary states.
- Do not invent a full calendar behaviour without checking the actual product requirements.

### 2. Weekly rhythm and session states

Specify how the seven-day rhythm and selected-session area represent:

- Completed strength session.
- Completed run.
- Today's planned workout.
- Upcoming strength/run.
- Rest/recovery day.
- Finished/closed day where supported.
- Selected day that is not Today.

Today and Selected must remain independent. The variable bar height should be tied to reliable planned session duration/load data, not decoration. Rest-day markers remain visually distinct.

### 3. Selected-session actions

Define a clean access strategy for:

- Start / review session.
- Edit sets and reps.
- Swap an individual exercise (not an unsupported general session-to-session swap).
- Reschedule with preview.
- Finish / reopen day.
- Rest-day/recovery choices.

Do not turn the selected-session hero into a dense toolbar. Identify which secondary actions belong in the future Manage sheet. Do not design the full Manage sheet in this task.

### 4. Coming Up

- Assess what Coming Up adds beyond the seven-day rhythm.
- Keep it only if it improves scanability or access to upcoming sessions.
- Preserve the schedule-derived relationship to the real sample schedule.
- Explain what tapping a row does and how selection updates.

### 5. Progressive Blur and Liquid Glass QA

Review the current V03 prototype at:

- Top/rest position.
- Early scroll.
- Mid-scroll across mixed light and Deep Forest surfaces.
- Selected-session position.
- Bottom of the page.

Check for visible blur seams, loss of text readability, fixed-navigation obstruction and excessive visual haze. The browser prototype is not Android performance evidence. Keep a non-blur fallback and note real-device testing as Open/Untested.

### 6. Responsive and accessibility review

Review 360, 390 and 412 px widths, plus:

- Day/category label readability.
- Long programme/session names.
- Touch targets.
- Safe-area clearance.
- Enlarged text and content reflow.
- Reduced-motion behaviour.
- Keyboard/focus visibility where applicable.
- Navigation and CTA accessibility while scrolling.

## Deliverables

1. `G01_V04_COMPLETENESS_REVIEW.md` — current behaviour/state inventory, proposed interaction map, Approved/Proposed/Open/Untested distinctions, and explicit source checks performed.
2. If a visual change is genuinely needed, provide a narrowly scoped proposal and wait for owner review before changing V03. Do not produce a broad redesign as part of this task.
3. A short next-step recommendation for the separate Manage Plan design task.

## Evidence and preservation rules

- The prior Plan functionality gaps are historical research observations, not a fresh or exhaustive audit. Verify an individual behaviour against actual source when necessary.
- Distinguish source-verified behaviour from earlier research, sample data, inference and proposal.
- Do not claim an interaction exists because a prototype button is visible.
- Preserve V03 unchanged during the review unless the owner explicitly approves a bounded revision.
- No app source, native services, storage, architecture or repository implementation changes.
- Do not mark the Main Plan design Approved.

## Stop condition

Stop after delivering the completeness review and any clearly bounded proposed corrections. Wait for owner review before starting Manage Plan.
