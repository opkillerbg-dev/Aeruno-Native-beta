# AERUNO Visual Reference Pack v1 — handoff guide

**Status: COMPLETE.** The owner has finished the 8-image Visual Reference Pack and will attach `AERUNO_Visual_Reference_Pack_v1.zip` separately when starting the next chat. This document records how to use that companion artifact; it does not duplicate the image files inside the repository.

## What the pack contains

Eight original visual references:

1. Visual Language Moodboard
2. Typography Exploration
3. Progress Card / Depth B
4. Tempo Run Hero / route
5. Today Strength Hero
6. Today Dashboard / Full Composition
7. Graphic Language Exploration
8. Plan Screen Reference

The ZIP also contains individual image reviews, a consolidated visual direction, typography/graphic/depth rules, the canonical navigation specification, coding-AI visual handoff instructions, and a reference index/manifest.

## Authority and boundaries

- Use this pack as the primary **creative and art-direction benchmark** for the redesign. It captures the level of expression and visual character the owner wants to preserve.
- Use this repository for the actual project state, owner decisions, Plan functionality research, preservation rules and technical facts.
- The pack is not a replacement for the legacy app's functional requirements. It is not proof that a visual treatment is implemented or performs well on Android.
- The pack is not approval of the first Plan screen exploration. That layout remains a functional/layout study only; its visual direction was not approved.
- Do not reproduce one reference screen literally. Extract the visual language and apply it thoughtfully to the specific information and actions of each screen.
- The pack is already complete. Do not generate another moodboard, rebuild the pack, re-open completed image reviews, or ask the owner to regenerate/re-upload it during the same handoff when it has already been attached.

## Visual language to carry forward

The references establish an expressive AERUNO language rather than a generic fitness dashboard:

- Oversized editorial typography used selectively and with a clear hierarchy.
- Intentional clipping, asymmetry, overlap and occlusion rather than evenly stacked generic cards.
- Quiet ghost numerals with the real metric still stated in readable text.
- Route graphics that interact with or cross in front of large running typography.
- Topographic/contour graphics used with purpose, not as filler.
- Strong solid forest-green surfaces and warm ivory space, with selective liquid glass for functional layers.
- Composition-led layouts with a few strong visual moments, not a dense grid of small cards.
- Refined, restrained details; preserve legibility, touch targets and clear actions.

## Locked decisions that remain authoritative

- Aesthetic: **Old Money × Liquid Glass**.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Font families: Big Shoulders Display Black, Instrument Serif Italic and Inter.
- Variant C: Big Shoulders Display Black at ×1.14 vertical scale, selectively for hero titles, major workout/category words and at most one hero statistic per screen. Do not apply it to ordinary UI, buttons, navigation, chips, body text, exercise names, forms, settings, timers or secondary statistics. Implementation feasibility remains untested.
- Session-pill timer: Big Shoulders Display (Option 2), locked; outside Variant C scaling.
- Depth B: oversized number partially tucked behind a foreground card.
- Depth C: route graphic crossing in front of large typography.
- Canonical navigation: **Today · Plan · Train · Progress · Me**. Some images may show older or inconsistent navigation labels; those labels are not authoritative. Use the canonical navigation above.

## Immediate design task

Use the pack together with:

- `design/plan-screen/OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md`
- `design/plan-screen/README.md`
- `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`

Create two materially different Plan concepts. Each concept must include the main Plan screen and its Manage sheet, preserve the researched feature set and make a distinct compositional choice. Compare the concepts in one review artifact, explain their core visual ideas briefly, recommend one with reasons, and stop for the owner's selection. Do not begin Train, implementation, migration or architecture work before the relevant owner approvals.

## New-chat upload checklist

Attach both files to the new chat:

1. The current `Aeruno-Native-beta` repository ZIP downloaded from the GitHub `main` branch, after the documentation update in this handoff is applied.
2. `AERUNO_Visual_Reference_Pack_v1.zip` (the completed visual pack).

Then ask the new chat to read `START_HERE.md`, this guide, and the current design-state / owner-decision documents before doing any work. The first response should confirm what is complete, what is locked, what remains open and the immediate next task. It should not generate anything or modify code until that state is established.
