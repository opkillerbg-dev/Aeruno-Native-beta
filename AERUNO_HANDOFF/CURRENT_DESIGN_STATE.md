# AERUNO Current Design State — 2026-11-20

**Current phase: Design Foundation refinement (v0.2 review).** Round 2 visual screens are complete and archived. Foundation v0.1 established the first token/component board. Foundation v0.2 is now archived as a visual exploration; it is not yet fully approved. No app implementation, migration, native/WebView architecture decision, or performance benchmark has been completed or approved.

## Source-of-truth order

1. This file is the authoritative current project/design status.
2. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` records the owner's current preferences and what remains open.
3. `design/foundation-v02/aeruno-foundation-v02.html` is the original HTML export of Foundation v0.2.
4. `design/round-02/` contains the approved Round 2 Today strength, navigation and Today running visual baseline (HTML/PDF exports, page images and phone captures).
5. `AERUNO_HANDOFF/DESIGN_SYSTEM.md` contains the established brand direction, palette, approved font families and prior token guidance.

The Foundation v0.2 file is correctly named and titled `AERUNO Foundation v0.2`. Treat its content as the latest exploration, but do not treat every proposal in it as approved.

## Completed visual baseline — Round 2

### Board 1 — Today: strength day
- Week 2 · Day 3; LOWER BODY; 35 min; 6 exercises; Start workout.
- Stats: 8,420 steps / goal 10,000; 42 min active; 4 day streak.
- Up Next: Back squat, Romanian deadlift and Walking lunge.
- Ivory canvas, forest hero, topographic contours, terracotta focal dot, serif greeting and large display typography.

### Board 2 — Floating navigation states
- Five destinations: **Today, Plan, Train, Progress, Me**.
- Live session pill with timer, exercise/set, tap-to-reopen and pause control.
- Paused state with dimmed timer and resume control.
- Navigation retreats to a compact dock while scrolling down, returns on scroll up and is never fully hidden.
- Round 2 board specifies 64 px nav height, 16 px side margin, 28 px radius, 16 px blur, 62% white, 55% white border, 220 ms transition and 112 px bottom content inset.

### Board 3 — Today: running day
- Tempo Run; 5.0 km; 32 min; 6:24/km; Start run.
- Stats: 12.4 km this week / goal 20; pace 6:24/km; 4 day streak.
- Warm-up, tempo and cool-down rows; route line extends the topographic visual language.

## Approved visual direction

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry content; glass is selective and functional.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Font families: Big Shoulders Display Black, Instrument Serif Italic and Inter.
- Navigation: Today, Plan, Train, Progress, Me, plus contextual live/paused session states.

## Foundation v0.2 — current review state

The v0.2 HTML is in `design/foundation-v02/`. It explores tall typography, ordinary-vs-expressive type, three depth compositions, number styling and usage rules. See `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` for detailed owner feedback.

**Strongly preferred and to be retained:**
- **Depth B (v0.2 section 4):** oversized decorative number tucked behind a summary card. Use selectively for weekly/monthly summaries; keep the real statistic stated in readable text.
- **Depth C (v0.2 section 5):** route line crossing in front of oversized running typography. Preserve the route-over-type interaction for running hero exploration.

**Direction wanted, details still open:**
- Selective tall/elongated display typography. The owner wants this in selected high-impact places, not throughout the UI. Exact technique and scale are undecided. The v0.2 suggestion of `scaleY` around 1.10–1.15 is a proposal, not an approved code token. The 1.30 sample is not recommended. Anton is an unapproved alternative-font specimen only.

**Needs refinement:**
- Depth A (title sinking behind a ledge): not selected as-is; refine overlap and ensure the full title remains identifiable.
- Ghost numeral treatment: refine size, tone and placement so it does not compete with the primary metric.
- Ordinary-vs-expressive type comparison and usage rules: make them clearer and test at mobile sizes.

The v0.2 HTML uses Google Fonts for its browser preview. The Android app must keep using locally bundled approved fonts; do not add a network-font dependency based on this artifact.

## Decisions still open

- Final implementation approach for selective tall display typography (larger native size/tighter leading versus a restrained vertical transform).
- Final treatment for Depth A and the ghost-number treatment.
- Exact limits for text cropping and how to keep every essential word/readout accessible.
- Compact-dock expansion interaction; tap-to-expand is a preferred proposal but is not yet recorded as an explicit owner decision in the archived Round 2 board.
- Rest-day and recovery-day Today variants.
- Full screen designs for Plan, Train, Progress and Me.
- Final reusable component specifications and motion/accessibility rules.
- Architecture choice: native Kotlin/Compose versus rebuilt WebView remains undecided.
- Glass performance benchmark remains unperformed. Design boards do not establish app performance.

## Next phase task

Refine Foundation v0.2, not restart it:
1. Retain and polish Depth B and Depth C.
2. Explore selective tall display type and compare native size/leading against mild vertical scaling; do not lock the exact scaling value without owner review.
3. Refine Depth A and ghost-number composition.
4. Clarify use/avoidance rules and accessibility safeguards.
5. Produce a clean, mobile-readable visual board for owner review.

Do not change app IDs, signing, storage keys/schema, backup format, services, or the legacy app. Do not start implementation or migration until the owner explicitly approves the architecture and implementation phase.
