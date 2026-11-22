> **HISTORICAL — SUPERSEDED.** Preserved from the old `aeruno_update/` staging folder for audit context. Its next-step instructions predate the 2026-11-21/22 owner decisions and must not be followed.

# AERUNO Continuation Update — 20 November 2026

This is a supplemental handoff update for the next AI account. Reconcile it with the repository's existing `START_HERE.md`, `AGENTS.md`, and `AERUNO_HANDOFF` documentation. Do not blindly overwrite existing documents or source files. Where older docs contradict this update, identify the contradiction and ask for confirmation before changing established decisions.

## Current project status
- AERUNO is a personal, offline-first fitness app; the legacy app is the functional source of truth for feature behavior and data.
- Legacy reference: v150, Capacitor/WebView, plain JavaScript and native Android Java services. The repository handoff contains a read-only copy. Preserve working functionality and data structures unless a carefully justified, user-approved migration is needed.
- Native Compose prototype remains an exploration/prototype, not a functional app. No architecture or implementation path has been approved.
- The user is continuing on a new AI account. This update is meant to transfer the latest checkpoint, not authorize implementation.

## Design checkpoint
The user has reviewed the published Type & Depth evaluation-board screenshots on phone.

Initial user visual feedback conveyed in the conversation:
- The ×1.14 vertical type scaling direction looks promising.
- The Workout Hero composition is strong.
- Depth C route-over-title composition is interesting; readability needs validation at normal viewing distance.
- The ghost numeral is appropriately subtle.
- Depth B looks promising for analytics.

These are initial visual impressions, **not final approvals of the entire design system or implementation**. The board is an evaluation prototype, not the app.

### Board experiments
- A: Big Shoulders baseline (scale 1.00)
- B: ×1.10 vertical scale
- C: ×1.14 vertical scale (labelled approved on the board, but do not treat that label as comprehensive project approval without confirming with the user)
- D: natural larger size ×1.14 without vertical scaling, resulting in increased width
- Workout hero: stacked LOWER / BODY, CTA and contour line detail
- Depth C: stacked TEMPO / RUN with route crossing the title, using a forest casing gap under the route
- Hero stat: 12.4 with a quieter ghost 20, goal also stated in label
- Depth B: 18 behind November summary card

Board URL (user-provided): https://claude.ai/artifact/RgbjfH2Ep66UkxqrXU4FXw

The board author reported that it uses bundled fonts and palette, no animation, and sample numbers. It has not been independently verified for rendering/device behavior beyond the user's screenshots.

## Next immediate task: Lite-mode test — instructions only
The previous AI proposed a simple Lite-mode check to help assess whether observed lag may be related to glass effects. The user has not yet performed the test. Do not claim a result.

Provide the user very simple, step-by-step instructions to open Lite mode in the legacy app, perform a short comparison of normal use/scrolling, and report whether lag noticeably changes. Do not modify the app or repository yet. If the Lite mode UI/steps are not known from inspected source, first inspect the source or ask rather than inventing steps.

## Architecture discussion remains open
Previous AI recommended exploring a redesign on the existing Capacitor shell first, with a small native Compose proof only if useful, because the existing native Java services and data/storage/backup behavior would be easier to preserve. This was a recommendation only, not a decision.

Do not select, migrate, or implement architecture yet. The intended sequence:
1. Explain/perform the Lite-mode test (inspect source for exact UI steps if needed).
2. Review user-reported result.
3. Discuss architecture and evidence, including performance risks and tradeoffs.
4. Obtain explicit user approval before architectural or implementation changes.

## Design and visual direction already established
- Old Money × Liquid Glass, balanced and intentional; avoid overusing glass.
- Palette: Ivory `#F3EFE4`, Deep Forest `#1F3B30`, Terracotta `#C97855`, Surface `#FFFEFA`, Surface Alt `#E7E2D6`, Sage `#DCE5D7`, Text `#202A23`, Muted `#646E65`.
- Fonts: Big Shoulders Display Black (display titles), Instrument Serif Italic (selective editorial accent), Inter (functional/body/labels/metrics).
- Design should remain legible, practical, and accessible; respect reduced motion.
- A single expressive depth composition per screen is the current design exploration rule, not a blanket mandate.

## Working relationship and guardrails
- ChatGPT is design/technical critic and collaborates on direction, critique, visual concepts, and custom assets when useful.
- Claude/new AI account is implementation and source-inspection partner; must inspect actual repository before changing anything, preserve working features, and test meaningful phases.
- User is the decision-maker and phone tester.
- No mass rewrite, data-loss-risk actions, app identity/signing changes, or major migration without explicit approval.
- Preserve CI/build workflows and existing features unless a reasoned and approved change is necessary.
- Do not claim tests, builds, or device checks passed unless actually performed.
- Keep changes small and reviewable; test after each meaningful phase.
- This supplemental update does not authorize code changes. The immediate task is Lite-mode instructions and waiting for the user's test result.

## Suggested status line
"We are at the visual-evaluation checkpoint. The type/depth board has been viewed on phone and received encouraging initial feedback. The next step is a simple Lite-mode comparison, not implementation. Architecture remains unapproved."
