# Roadmap (current recommended sequence; flexible until the architecture decision)

Tags: see `../START_HERE.md`. This is a sequence of phases, not a commitment. **Phase 2 is open: neither Path A nor Path B is approved** (`ARCHITECTURE_DECISIONS.md`). Do not start phase 3 or later without the owner's go.

| # | Phase | Notes |
|---|---|---|
| 1 | Complete project and architecture understanding | In progress. Audit and architecture investigation done as written reports; this handoff package is the portable record. Remaining: the missing materials in `KNOWN_ISSUES.md` section H |
| 2 | Finalize the application architecture | Owner decides Path A or B, repository for the final app, whether the app id and signing change, migration method. Evidence that would help: Lite-mode lag test, CSS review, native benchmark (`ARCHITECTURE_DECISIONS.md`) |
| 3 | Establish the new design system and application shell | Palette, type, tokens, navigation, base components (cards, buttons, sheets). Reuse prototype findings only as experiments (`PROTOTYPE_HISTORY.md`) |
| 4 | Design the individual screens | ChatGPT leads direction; owner approves. Screen concept, visual direction, then implementation |
| 5 | Create custom visual assets where needed | Only with a clear purpose and consistent art direction; propose concept first; prefer local bundled assets; mind size and offline use (`LEGACY/docs/art/EXERCISE_IMAGE_PROMPTS.md` shows the earlier approach for exercise images) |
| 6 | Implement the redesigned screens | In small reviewable phases, one major system at a time |
| 7 | Integrate existing functionality | Reuse, adapt, port or migrate per `FEATURE_INVENTORY.md` |
| 8 | Test features and data handling | Port or reuse Node tests; import/export fidelity; unit and UI tests |
| 9 | Real-device testing | Owner's phone; GPS background, steps, notifications, widgets, performance measurement |
| 10 | Prepare a stable release | Identity and signing decisions executed only with explicit owner approval |

Workflow for custom visuals: screen concept -> visual direction -> asset creation -> implementation -> phone testing -> refinement.
Principles: inspect before changing; preserve working systems; no unrelated changes; never claim tested without testing; report limitations honestly.
