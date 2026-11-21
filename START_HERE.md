# START HERE: AERUNO project handoff

You are an AI assistant continuing the AERUNO project. Read the current status before relying on older phase descriptions.

## Current status — read first

1. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`
2. `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md`
3. `AERUNO_HANDOFF/TYPE_DEPTH_BOARD_REVIEW.md`
4. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md`
5. `design/type-depth/` — latest Type & Depth Board HTML and phone captures
6. `design/foundation-v02/` — Foundation v0.2 exploration
7. `design/round-02/` — approved Round 2 visual baseline

**Current phase: Design Foundation refinement.** The next task is a small refinement pass on the Type & Depth Board. Do not restart earlier design rounds.

**Important stale-reference warning:** Older sections of `AERUNO_HANDOFF/ARCHITECTURE_DECISIONS.md` and `AERUNO_HANDOFF/KNOWN_ISSUES.md` still mention V1 Lite/Smooth-mode testing or V2 lag as possible architecture evidence. Those suggestions are superseded by `AERUNO_HANDOFF/PROJECT_HISTORY_CLARIFICATION.md`. Do not run that test or diagnose V2. The V2 experiment is closed as a product direction.

## Important owner clarification about performance history

The owner reports that legacy V1 ran normally on his own phone. Smooth mode was added mainly for friends with lower-end devices; it was not a fix for the owner's V1 performance. V2 was a failed experiment and is not the target. Do not repeat the V1 Smooth/Lite-mode diagnostic or investigate V2 as a prerequisite to the redesign. Keep V2 only as historical context. The new architecture remains undecided and should be evaluated against the new AERUNO design and functional requirements when needed.

## Project overview

AERUNO (formerly Arya Fit) is a personal Android fitness app. The legacy V1 app is a Capacitor WebView app and remains the functional reference. This repository also contains a small Kotlin/Jetpack Compose prototype. The final architecture remains undecided.

## Working roles

- Owner: final product, design and architecture decisions; tests on the real Android phone.
- ChatGPT: visual direction, creative exploration, critique and design guidance.
- Claude/coding AI: artifact creation, engineering, implementation and testing when authorized.

## Ground rules

- Continue the Type & Depth Board refinement; do not recreate Round 1, Round 2 or Foundation v0.1/v0.2.
- Preserve the owner's preference for Depth B and Depth C.
- The exact tall-type scale is still open pending the owner's comparison of the specimens.
- Do not use V2's failure as evidence against WebView generally; V2 is not the target.
- Do not ask the owner to perform the legacy V1 Smooth/Lite comparison as an architecture diagnostic.
- Do not claim build, performance or device testing without evidence.
- Do not touch legacy app ID, signing, `aryaApp2`, storage schema, backup format or native services without explicit approval.
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
