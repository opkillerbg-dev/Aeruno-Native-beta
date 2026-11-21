# Owner review — Plan screen needs a stronger creative direction

**Date:** 2026-11-21  
**Status:** Current Plan exploration is useful as a functional/layout study, but its visual execution is **not approved**. This is a creative-direction correction, not a rejection of the researched functionality.

## Owner's feedback

The owner says the Plan screen has lost the creativity and distinctive visual character established in the Round 2 Today boards and the Type & Depth explorations. The current output feels too conventional and template-like.

## What is working and should be preserved

- The legacy Plan functionality has been researched and mapped. Keep that work; do not repeat the same research unless a specific uncertainty requires it.
- The main information sequence is sensible: plan progress, current week, selected day/session, then upcoming sessions.
- The selected-day-in-place concept is a useful proposal.
- The Manage sheet correctly groups multiple plans, Smart week, build/personalise, import, export and assistant-guide actions.
- The approved AERUNO palette, three bundled font families, Variant C selective display direction, Big Shoulders session-pill timer, floating navigation, Depth B and Depth C remain the baseline.
- Keep all capability gaps and unresolved Plan states marked Open. Do not pretend the current visual mock-up has designed the whole Plan feature.

## Why the current visual is not there yet

The current screen relies too heavily on a repeated stack of conventional UI patterns:

- a standard rounded progress card;
- a small, evenly spaced calendar/date strip;
- a white session card with a conventional checklist;
- a Manage sheet made mostly of similar bordered rows.

The result is clean and legible, but the visual hierarchy is predictable. The oversized LOWER BODY title is the only strong expressive moment, and it sits inside an otherwise ordinary card. The Plan screen does not yet feel like it belongs to the more art-directed AERUNO visual world.

The Manage sheet is especially generic: it reads like a settings/action menu rather than a deliberately composed AERUNO surface.

## Creative direction required for the next pass

Do not merely polish the current cards, add a few decorative lines, or change colours. Re-think the composition while preserving the useful information and functional requirements.

Bring back the signature AERUNO visual language:

1. **Editorial scale and asymmetry.** Use Big Shoulders and Instrument Serif with stronger intentional hierarchy. Give the week, plan progress or selected session a distinctive composition rather than making every section the same visual weight. Use Variant C only within its approved selective display role.
2. **Purposeful depth.** Explore Depth B (an oversized number partially occluded by a solid card) for a meaningful weekly/plan-progress moment. Keep the number decorative and the real information readable. Do not force Depth B onto every card.
3. **A graphic weekly rhythm.** Reimagine the seven-day strip as a designed visual system that communicates the rhythm of training, rest and session length. It should feel custom to AERUNO, not like a default calendar widget. A connecting path, contour or carefully composed sequence may be explored, but it must remain readable and not become decoration without meaning.
4. **A session with a clear identity.** The selected workout should feel like a hero moment—potentially a forest surface, selective contour/graphic treatment, oversized workout title and well-separated actions—rather than another white list card. Keep the actual exercises, progress and actions accessible.
5. **A designed Manage sheet.** Give the sheet its own art direction and hierarchy. Make the active plan and Smart week feel like meaningful featured modules; group secondary actions with restraint. Avoid presenting every action as an identical settings row.
6. **Controlled materials.** Solid surfaces carry information; glass is reserved for functional layers such as the nav and sheet. Avoid generic glassmorphism, heavy shadows, random gradients, clutter or excessive decoration.

## Required exploration and deliverables

- Create **two materially different Plan visual concepts**, not the same layout with different colours or minor rearrangements.
- Each concept should show the main Plan screen and its Manage sheet, using the existing researched feature set and the established AERUNO visual baseline.
- The two concepts should differ in their core composition, information hierarchy and graphic treatment. Explain the design idea behind each in a few concise lines.
- Compare them side-by-side in one review artifact, then recommend the stronger direction with reasons. The owner will choose; do not mark either concept Approved.
- Render-check realistic phone widths and inspect the actual rendered output. State clearly that this is headless-browser evidence, not a real-phone or Android test.
- Preserve the current exploration as an archive/reference. Do not delete it.
- Do not begin Train until the owner selects and approves a Plan direction.

## Scope boundaries

- Design-only. No app source, implementation, architecture migration, storage, services, app identity, signing or build workflow changes.
- Do not re-open the timer font decision: session-pill timer is locked to Big Shoulders Display. Do not apply Variant C's ×1.14 scaling to timers.
- Do not change the approved palette or fonts.
- Do not diagnose V2 or run the V1 Smooth/Lite-mode test.
- Do not infer owner approval from a render, a previous proposal or Claude's recommendation.
