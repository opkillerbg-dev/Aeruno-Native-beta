# START HERE: AERUNO project handoff

You are continuing the existing AERUNO project. Do not restart the design process. Read this file, the current handoff documents and the separately supplied Visual Reference Pack before proposing or changing anything.

## Current status — read first

1. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` — current phase and immediate next task.
2. `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md` — status, contents and authority of the completed visual pack. The owner supplies `AERUNO_Visual_Reference_Pack_v1.zip` separately with this repository.
3. `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-21.md` — authoritative owner decisions and superseded historical guidance.
4. `design/plan-screen/OWNER_REVIEW_CREATIVE_DIRECTION_2026-11-21.md` — owner's review of the first Plan exploration and the required creative rework.
5. `design/plan-screen/README.md` — researched Plan functionality, information hierarchy, and its Proposed/Open gaps.
6. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md` — correction about V1, Smooth mode and V2.
7. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md` — completed Type & Depth refinement and selected type treatment.
8. `design/round-02/` — approved Round 2 visual baseline.
9. `design/type-depth/` — Type & Depth Board and refinement captures.
10. `design/foundation-v1/aeruno-design-foundation.html` — Foundation draft 1; the owner reports Draft 2 correction/review complete, but that Draft 2 file is not in this repo copy.

**Current phase: Plan screen creative rework (owner review pending).** Round 2 and the separate 8-image Visual Reference Pack are complete. The first Plan exploration is useful functional/layout research but its visual direction is not approved. Use the Visual Reference Pack as the primary creative benchmark, while using the Plan README and legacy V1 source for functional requirements. The next task is two materially different Plan concepts, each showing the Plan screen and Manage sheet, compared in one review artifact. Stop for the owner's selection. Do not begin Train until a Plan direction is selected. Do not recreate earlier design rounds or regenerate the Visual Reference Pack.

## Important precedence and stale-document warning

`AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`, `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-21.md`, and the addendum in `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md` are the current source of truth. Where older prototype or phase documents conflict with them, follow the current handoff. In particular:

- Variant C is selected as a **design direction**: Big Shoulders Display Black at ×1.14 vertical scale, used selectively. Android implementation and font-scaling feasibility remain untested.
- The session-pill timer font is locked to Big Shoulders Display (Option 2), outside Variant C scaling.
- The original `AGENTS.md` prototype plan and its dated phase statements describe the earlier native prototype experiment; they do not override the current design-only phase.
- Older Lite/Smooth-mode diagnostic suggestions and V2-lag references are historical and must not be treated as current tasks or architecture evidence.
- The Visual Reference Pack is a completed external companion artifact. Do not describe it as missing from the repo as a blocker, ask the owner to recreate it, or start another moodboard/reference-generation round. It will be attached separately to the new chat.

## Important owner clarification about performance history

The owner reports that legacy V1 ran normally on his own phone. Smooth mode was added mainly for friends using lower-end devices; it was not a fix for the owner's V1 performance. V2 was a failed experiment and is not the target. Do not repeat the V1 Smooth/Lite-mode diagnostic or investigate V2 as a prerequisite to the redesign. The new architecture remains undecided and should be evaluated against the new AERUNO design and functional requirements when needed.

## Project overview

AERUNO (formerly Arya Fit) is a personal Android fitness app. The legacy V1 app is a Capacitor WebView app and remains the functional reference for existing capabilities. This repository also contains a small Kotlin/Jetpack Compose prototype. The final architecture remains undecided.

## Working roles

- Owner: final product, design and architecture decisions; tests on the real Android phone.
- ChatGPT: visual direction, creative exploration, critique and design guidance.
- Claude/coding AI: artifact creation, engineering, implementation and testing when authorized.

## Ground rules

- Do not recreate Round 1, Round 2, Foundation v0.1/v0.2 or the Type & Depth Board. Continue from the current Plan creative rework; use the Foundation material as reference, not as a reason to restart.
- Preserve the owner's preference for Depth B and Depth C.
- Use Variant C only for selective display typography; do not apply it to ordinary UI text, buttons, navigation, chips, body text, exercise names, forms, settings, timers or secondary statistics.
- Keep current work design-only. Do not begin app implementation, migration or architecture changes without explicit owner approval.
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
