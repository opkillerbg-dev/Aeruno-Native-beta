# 2026-11-21: Plan screen design exploration

Design and documentation only. No app source, build workflow, app id, signing, storage, native service or legacy file touched.

- Verified the owner decisions in the repo. Fixed stale "timer font open" and "Foundation review pending" wording in `OWNER_DECISIONS_OVERRIDE`, `CURRENT_DESIGN_STATE`, `UPDATE_MANIFEST`, `DESIGN_SYSTEM`, `START_HERE`. Timer font recorded as LOCKED (Big Shoulders Display). Nothing Proposed or Open was promoted.
- Found: the Foundation Draft 2 file is not in this repo copy; recorded as owner-reported and asked for the upload.
- Researched Plan functionality in the legacy v150 source (plan-ui.js, index.html plan views, swap.js, coach.js, builder, onboarding spec).
- New `design/plan-screen/`: README (hierarchy, legacy capability table, Approved / Proposed / Open), HTML export of two boards (Plan week view, Manage sheet), render checks at 360, 390, 412 px. Also published to the design canvas.
- Evidence: [S] headless Chromium render checks, no overflow, fonts loaded. [U] phone, Android implementation, 200% font scale, TalkBack, performance.
- Not done by design: Train, other Plan states (rest, edit, reschedule, run day), any implementation or architecture choice.
- Next: owner review of the Plan exploration.
