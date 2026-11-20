# START HERE: AERUNO project handoff

You are an AI assistant continuing the AERUNO project. Read the current status before relying on older phase descriptions.

## Current status — read first

1. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` is the authoritative current project/design status.
2. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` records the owner's review of the latest Foundation v0.2 exploration.
3. `design/foundation-v02/aeruno-foundation-v02.html` is the original Foundation v0.2 HTML export.
4. `design/round-02/` contains the completed Round 2 Today strength, navigation and Today running visual baseline.

**Current phase: Design Foundation refinement.** Round 2 is complete. Foundation v0.1 established the first system board; Foundation v0.2 is an exploration that now needs targeted refinement. Do not restart earlier rounds.

App implementation, migration and architecture selection are NOT approved yet. Design exploration is authorized to continue. The current-state document supersedes older phase labels in `AGENTS.md` and historical handoff notes where they conflict. The native prototype task list in Part 2 of `AGENTS.md` remains historical/on hold unless the owner explicitly resumes it.

## Project overview

AERUNO (formerly Arya Fit) is a personal Android fitness app. The functional legacy app is a Capacitor WebView app. This repository contains a small Kotlin/Jetpack Compose prototype plus a read-only copy of the legacy source for reference. The final architecture (native Compose or rebuilt WebView) remains undecided.

## Read in this order

1. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`
2. `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md`
3. `AERUNO_HANDOFF/PROJECT_OVERVIEW.md`
4. `AERUNO_HANDOFF/REPOSITORY_GUIDE.md`
5. `AERUNO_HANDOFF/LEGACY_APPLICATION.md`
6. `AERUNO_HANDOFF/ARCHITECTURE.md` and `FEATURE_INVENTORY.md`
7. `AERUNO_HANDOFF/DESIGN_SYSTEM.md` and `PROTOTYPE_HISTORY.md`
8. `AERUNO_HANDOFF/KNOWN_ISSUES.md` and `ARCHITECTURE_DECISIONS.md`
9. Read `AGENTS.md` for working rules; apply the current-state override above where older phase labels conflict.
10. Read `DATA_AND_MIGRATION.md`, `BUILD_AND_TESTING.md`, `ROADMAP.md` and `GLOSSARY.md` when relevant.

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

## Ground rules

- The owner decides design, architecture, identity, signing and implementation.
- ChatGPT leads visual design direction; the coding AI implements and tests; the owner tests on the real Android phone.
- Continue with Foundation v0.2 refinement. Preserve the owner's preference for Depth B and Depth C; do not restart Round 1, Round 2 or Foundation v0.1.
- Treat proposed stretch factors, Depth A, ghost numerals and implementation techniques as unresolved until the owner approves them.
- Do not claim build/performance/device testing without evidence.
- Do not touch legacy app ID, signing, `aryaApp2`, storage schema, backup format or native services without explicit owner approval.
- This repository is public: never add secrets, keystores, passwords, tokens, private keys or personal backups.
- Keep phases small and reviewable. Do not edit `AERUNO_HANDOFF/legacy-reference/`.

## Repository map

| Need | Location |
|---|---|
| Current design/project state | `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` |
| Foundation v0.2 review | `AERUNO_HANDOFF/FOUNDATION_V02_REVIEW.md` |
| Foundation v0.2 source HTML | `design/foundation-v02/aeruno-foundation-v02.html` |
| Round 2 design baseline | `design/round-02/` |
| Prototype source | `app/src/main/java/com/aeruno/nativeprototype/` |
| Prototype change log | `docs/log/` |
| Legacy app reference, read-only | `AERUNO_HANDOFF/legacy-reference/` |
