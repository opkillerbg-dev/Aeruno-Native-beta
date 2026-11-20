# AERUNO Current Design State — 2026-11-20

**Current phase: Design Foundation.** The Round 2 visual baseline is complete and archived. No app implementation, migration, native/WebView architecture decision, or performance benchmark has been completed or approved.

## Source-of-truth order

1. This file is the current design/project status.
2. `design/round-02/claude-artifact-export.html` is the standalone HTML export containing the latest three boards.
3. `design/round-02/claude-artifact-export.pdf` is the matching three-page visual export.
4. `design/round-02/boards/` contains clean rendered page images from that PDF.
5. `design/round-02/phone-captures/` contains the owner's phone screenshots of the same three boards.

**Important metadata correction:** The downloaded files were named `AERUNO shell and Today (design round 1).html` and `.pdf`, and the HTML document's `<title>` also says `design round 1`. That label is stale. It does NOT describe the embedded board content. The HTML and PDF were checked directly and both contain the latest Round 2 state described below. Do not place these exports in `design/round-01/`.

## Round 2 deliverables (verified)

### Board 1 — Today: strength day (PDF page 1)
- Date label: Tuesday · 20 Nov.
- Greeting: Good morning.
- Hero: Week 2 · Day 3; LOWER BODY; 35 min; 6 exercises; Start workout.
- Stats: 8,420 steps / goal 10,000; 42 min active; 4 day streak.
- Up Next: Back squat (4 × 8 · 60 kg), Romanian deadlift (3 × 10 · 50 kg), Walking lunge (3 × 12 · 20 kg).
- Visual hierarchy uses the ivory canvas, forest hero, topographic contours, terracotta focal dot, serif greeting and large display type.

### Board 2 — Floating navigation states (PDF page 2)
- Five destinations: **Today, Plan, Train, Progress, Me**.
- Resting state shown with **Train** active.
- Live workout state: session pill with 12:48 timer, Back squat, Set 2 of 4, “tap to reopen”, and pause control.
- Paused state: timer dims, label changes to “Paused · tap to reopen”, control becomes Resume.
- Scrolling down: nav retreats to a compact 48 px dock; it returns on scroll up and is never fully hidden.
- Board spec: nav height 64; side margin 16; radius 28; blur 16; white 62%; border white 55%; active forest pill; 220 ms slide; bottom content inset 112 px; retreat 220 ms ease-out to 48 px dock.

### Board 3 — Today: running day (PDF page 3)
- Date label: Thursday · 22 Nov · 16° clear.
- Hero: Run · Week 2 · Day 4; TEMPO RUN; 5.0 km; 32 min; 6:24/km; Start run.
- Stats: 12.4 km this week / goal 20; pace 6:24/km; 4 day streak.
- Today's run: Warm-up (5 min · easy · 7:00/km), Tempo (3.0 km · 6:05/km), Cool-down (5 min · easy).
- Running hero extends the same topographic motif with a route/path line.

## Approved visual direction

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry content; glass is selective and functional, not applied everywhere.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Typography: Big Shoulders Display Black, Instrument Serif Italic, Inter.
- Today layout: date/greeting/profile header; strong workout hero; large divider-separated stats; concise next-activity rows.
- Navigation: five tabs and contextual session-pill states as above.

## Decisions still open

- Exact compact-dock expansion interaction and how all five destinations remain reachable from that compact state.
- Rest-day and recovery-day Today variants.
- Full screen designs for Plan, Train, Progress and Me.
- Detailed reusable component specs and final motion/accessibility rules.
- Architecture choice: native Kotlin/Compose versus rebuilt WebView remains undecided.
- Glass performance benchmark remains unperformed. The boards are visual designs, not evidence of app performance.

## Next phase: Design Foundation

Define the reusable design tokens, spacing, typography roles, surface treatments, buttons, cards, navigation, sheets, interactions, motion and accessibility rules. Continue design work before implementation.

Do not change app IDs, signing, storage keys/schema, backup format, services, or the legacy app. Do not start implementation or migration until the owner explicitly approves the architecture and implementation phase.

## Export integrity

- HTML original bytes SHA-256: `0d620656dceb43e10529ad323f03091bba8a723ec151c743de9126a83e698f73`
- PDF original bytes SHA-256: `e9e31c71b5d41cfcd484526e3baea11e33641089edc11f99ebceaba249e19dd4`
- Both source exports are stored in `design/round-02/` byte-for-byte; only the archive paths have been normalized.
