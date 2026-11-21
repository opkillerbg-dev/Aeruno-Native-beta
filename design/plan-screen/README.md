# AERUNO Plan screen: design exploration (2026-11-21)

**Status: first exploration reviewed; visual direction not approved.** The functionality map and information hierarchy remain useful, but the owner says the visual execution is too conventional and lacks the creative character established in the Round 2 boards. See `OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md` for the required rework. Design only: no app code, architecture, identity, signing or data touched. Train is not started.

Files: `aeruno-plan-screen.html` (both boards, fixed 390 px frames, sample data, Google Fonts for browser preview only; the app uses its bundled fonts) and `render-checks/` (headless Chromium at 360, 390, 412 px). The live design canvas also exists in the owner's Claude session.

## 1. Decisions checked in the repository before designing

| Owner decision | Found | Action |
|---|---|---|
| Session-pill timer font: Big Shoulders Display (Option 2), locked | Correct in `TIMER_FONT_DECISION_2026-11-21.md` and its log. Stale "still open" wording in `OWNER_DECISIONS_OVERRIDE`, `CURRENT_DESIGN_STATE`, `UPDATE_MANIFEST`, `DESIGN_SYSTEM` (older "timers use Inter tabular") and `START_HERE` | Corrected in this update. Foundation draft 1 HTML still shows the question as Open: left untouched as a historical draft |
| Foundation decisions stay intact; Proposed/Open not promoted | Owner reports Draft 2 correction and review done. The Draft 2 file is NOT in this repo copy | Recorded as owner-reported. Nothing promoted. Please upload Draft 2 if it should be archived |
| V1 was fine for the owner; Smooth mode was for friends' low-end phones; V2 failed and is not a baseline | Correct in `PROJECT_HISTORY_CLARIFICATION` and the override | No V2 or Smooth-mode work done here |
| Legacy source | This repo copy has legacy docs only (`AERUNO_HANDOFF/legacy-reference`), not the JS | Functionality below was read from the original legacy zip (v150) supplied earlier |

## 2. What Plan must support (legacy functionality, read from code)

| Capability | Legacy source | In this exploration |
|---|---|---|
| Week N of W, date range, previous/next week | `core/plan-ui.js` `grid()` | Week selector + W1 to W4 segments |
| 7-day strip with progress, today, selected, done, rest | `grid()` | "Week rhythm" strip |
| Completion %, days done, streak | `stats()` | 30% and streak caption. Days-done count not shown (Open) |
| Whole-plan calendar ("See all days") | `index.html` `ax-all` | **Not placed (Open)** |
| Session: day n of N, name, summary, rounds, tags (Today, Light week, Rest day, Closed, starts in) | `day()` | Kicker, title, summary, Today chip. Other tags Open |
| Edit sets and reps; per-exercise Swap (non-destructive) | `day()`, `features/swap.js` | Button only. Edit mode not designed |
| Reschedule with shift preview | `day()` | Button only. Flow not designed |
| Session progress and status (Ready when you are, In progress, Complete, Rest, Closed) | `day()` | "Ready when you are" shown |
| Exercises by group, tick, per-exercise timers, run/walk start, pictures | `day()` | 2 of 6 rows + "4 more". Groups, timers, pictures Open |
| Finish day / Reopen day | `ax-pclose` | **Open** |
| Several plans, each with own progress; switch | `ax-v-plans` | Manage sheet |
| Add plan from file or pasted text, with Check plan | `ax-v-plans` | Sheet row. Flow not designed |
| Export / copy plan; guide for an AI assistant | `ax-v-plans` | Sheet rows |
| Build my plan (3 steps); Personalise (retest every 4 weeks) | `features/builder.js`, `onboard.js` | Sheet rows |
| Smart week: suggest, apply, undo; own edits win | `features/coach.js` | Sheet card (Preview, Undo last) |
| Readiness-based adjustment, light weeks, planned rest days | `readiness.js`, `plan-ui.js` | Not shown (Open) |
| Workout, run and GPS time tags on a day | `day()` | Not shown (Open) |

## 3. Information hierarchy

1. What is this and how far am I: plan name, week, 30%, W1 to W4.
2. Which day, and what is it: the week rhythm strip (bar height = session length).
3. What exactly is the selected session, and can I act: one expanded session card with Start, Edit, Reschedule.
4. What is next: "Coming up".
5. Everything about plans lives behind **Manage** (a sheet), not in the main flow.

Idea: the legacy app had separate week and day views. Here the selected day opens in place under the strip.

## 4. Status of design choices

**Approved (inherited baseline, not re-decided):** Old Money x Liquid Glass; palette; Big Shoulders Display Black, Instrument Serif Italic, Inter; tabs Today, Plan, Train, Progress, Me with the floating glass nav; Variant C (x1.14) only for hero titles and major workout words (used once, on "LOWER BODY"); session-pill timer = Big Shoulders (locked); list rows with softer borders and radius 16 (Round 2 refinement); glass only on nav, top-edge fade and sheets.

**Proposed (new here, owner to decide):**
- Week rhythm strip: one bar per day, height = session length; filled forest = done, terracotta = today, outline = upcoming, short sage = rest.
- Expanded session card under the strip instead of a separate day screen.
- W1 to W4 segmented progress with one hero statistic ("30%", unscaled).
- "Coming up" list; Manage sheet (glass, sections: Your plans, Smart week, Add or change).
- Component values: card radius 22, row radius 16, buttons 44 high (radius 12), primary 52 high, "Today" chip forest with ivory text, content bottom inset 112 px above the nav.
- Serif italic accent used once: "One session at a time." (legacy copy).

**Open (not decided or not designed):** where the 28-day calendar lives; rest-day, edit-sets (with swap), reschedule preview, run-day, light-week and finished-day states; Finish/Reopen day placement; per-exercise timers and exercise pictures; how Plan shows readiness or retest prompts; multi-plan effect on Today; 200% font scale and long plan names; real data lengths. Sample dates follow Round 2 for continuity (20 Nov 2026 is really a Friday).

## 5. Rules respected

- Terracotta only as fills, bars, dots and the button arrow circle: never as small text (2.90:1 on Ivory, 3.30:1 on Surface per Foundation notes, not re-measured here). Small text uses Text `#202A23` or Muted `#646E65`.
- Tap targets 44 px or more; icon-only buttons have labels; every day button has a descriptive label (day, session, state).
- Solid surfaces carry information. Glass only on the nav and the sheet.

## 6. Evidence

- [S] Headless Chromium with the bundled TTF fonts at 360, 390 and 412 px: no horizontal overflow, all three fonts loaded, visual inspection of first screen, full-length scroll and the sheet.
- [S] Both boards were published to the design canvas.
- [U] Real phone, Android/Compose/WebView implementation, performance, 200% system font, dark mode, TalkBack, the exact blur result.
- HTML renders are not implementation proof.


## 7. Owner visual review — 2026-11-21

The first layout remains a functional reference, not the selected Plan design. Do not mistake clean spacing or the lack of overflow for visual approval. The next pass must explore two materially different art-directed compositions, including the Manage sheet, and return for owner selection before Train begins. The existing functionality table and Proposed/Open states remain in force.
