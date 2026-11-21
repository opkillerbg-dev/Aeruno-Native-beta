# START HERE: AERUNO project handoff

You are an AI assistant continuing the AERUNO project. Read this file and the current owner-decision documents before relying on historical phase descriptions.

## Current status — read first

0. `design/plan-screen/OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md` — owner's review: current Plan layout is functionally useful but visually too conventional; next pass must explore two distinct creative directions.
1. `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-21.md` — authoritative current owner decisions and superseded historical guidance.
2. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` — current phase, design decisions and next task.
3. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md` — owner clarification about V1, Smooth mode and V2.
4. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md` — completed Type & Depth refinement and the owner's selected type treatment.
5. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` — historical v0.2 exploration; newer decisions supersede earlier open questions.
6. `design/foundation-v1/aeruno-design-foundation.html` — current Design Foundation draft 1 for owner review.
7. `design/type-depth/` — Type & Depth Board, Refinement 1 and phone captures.
8. `design/round-02/` — approved Round 2 visual baseline.

**Current phase: Plan screen creative rework (owner review pending).** The Type & Depth Board checkpoint is closed: the owner selected Variant C (Big Shoulders Display Black at ×1.14 vertical scale) on 2026-11-21 for selective display use only. The owner reports the Foundation Draft 2 correction and review complete on 2026-11-21 (the Draft 2 file is not in this repo copy; draft 1 is at `design/foundation-v1/`; Proposed and Open items stay as tagged). The session-pill timer font is locked to Big Shoulders Display. The first Plan exploration is a useful functional/layout study but is not visually approved; the owner says it lacks the distinctive creative character of the earlier AERUNO boards. Read `design/plan-screen/OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md` and produce two materially different, more art-directed Plan concepts. Do not begin Train until the owner selects a Plan direction. Do not restart earlier design rounds.

## Important precedence and stale-document warning

`OWNER_DECISIONS_OVERRIDE_2026-11-21.md` and `CURRENT_DESIGN_STATE.md` are the current source of truth where older documents conflict. In particular:

- Older statements that the exact type treatment is undecided are superseded. Variant C is selected as a **design direction**; Android implementation and font-scaling feasibility remain untested.
- The original `AGENTS.md` prototype plan and its dated phase statements describe the earlier native prototype experiment. They do not override the current design-only phase.
- Older Lite/Smooth-mode diagnostic suggestions and V2-lag references in `AERUNO_HANDOFF/ARCHITECTURE_DECISIONS.md` and `AERUNO_HANDOFF/KNOWN_ISSUES.md` are historical and must not be treated as current tasks or architecture evidence.

## Important owner clarification about performance history

The owner reports that legacy V1 ran normally on his own phone. Smooth mode was added mainly for friends using lower-end devices; it was not a fix for the owner's V1 performance. V2 was a failed experiment and is not the target. Do not repeat the V1 Smooth/Lite-mode diagnostic or investigate V2 as a prerequisite to the redesign. The new architecture remains undecided and should be evaluated against the new AERUNO design and functional requirements when needed.

## Project overview

AERUNO (formerly Arya Fit) is a personal Android fitness app. The legacy V1 app is a Capacitor WebView app and remains the functional reference for existing capabilities. This repository also contains a small Kotlin/Jetpack Compose prototype. The final architecture remains undecided.

## Working roles

- Owner: final product, design and architecture decisions; tests on the real Android phone.
- ChatGPT: visual direction, creative exploration, critique and design guidance.
- Claude/coding AI: artifact creation, engineering, implementation and testing when authorized.

## Ground rules

- Do not recreate Round 1, Round 2, Foundation v0.1/v0.2 or the Type & Depth Board. Continue from the current Foundation draft only when asked.
- Preserve the owner's preference for Depth B and Depth C.
- Use Variant C only for selective display typography; do not apply it to ordinary UI text, buttons, navigation, chips, body text, exercise names, forms, settings, timers or secondary statistics.
- Keep the Design Foundation work design-only. Do not begin app implementation, migration or architecture changes without explicit owner approval.
- Do not claim build, performance or device testing without evidence.
- Do not touch legacy app ID, signing, `aryaApp2`, storage schema, backup format, native services or legacy reference files without explicit approval.
- This repository is public: never add secrets, keystores, passwords, tokens, private keys or personal backups.
- Keep phases small and reviewable. Do not edit `AERUNO_HANDOFF/legacy-reference/`.

## Evidence tags

| Tag | Meaning |
|---|---|
| **[V]** | Verified by reading the named file in this repo |
| **[S]** | Verified by running something in an AI sandbox; never means phone-tested |
| **[D]** | Stated in repo documentation or a log; not re-checked |
| **[O]** | Stated by the owner; not re-checked |
| **[I]** | Inferred |
| **[U]** | Unknown / not checked |

"The code exists" is never evidence that a feature works.
