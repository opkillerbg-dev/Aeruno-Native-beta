# START HERE: AERUNO project handoff

You are an AI assistant that has just been given this repository as a ZIP. You know nothing about AERUNO. This file tells you what to read, in what order, before you suggest or change anything.

**One sentence:** AERUNO (formerly "Arya Fit") is a personal Android fitness app. A working legacy version exists (Capacitor WebView). The owner now wants a completely new UI/UX. This repo holds a small native Kotlin/Compose prototype plus a full copy of the legacy source for reference. **The architecture for the redesign has NOT been decided.**

## Read in this order (all inside `AERUNO_HANDOFF/`)
1. `PROJECT_OVERVIEW.md`: what AERUNO is, history, goal.
2. `REPOSITORY_GUIDE.md`: what is in this repo, file map, what is experimental.
3. `LEGACY_APPLICATION.md`: how the legacy app works, with file paths and symbols.
4. Inspect the legacy source: `AERUNO_HANDOFF/legacy-reference/` (see `SOURCE_MANIFEST.md` first for what it is and what is missing).
5. `ARCHITECTURE.md` and `FEATURE_INVENTORY.md`.
6. `DESIGN_SYSTEM.md` and `PROTOTYPE_HISTORY.md`.
7. `KNOWN_ISSUES.md` and `ARCHITECTURE_DECISIONS.md`.
8. Also read `DATA_AND_MIGRATION.md`, `BUILD_AND_TESTING.md`, `ROADMAP.md`, `GLOSSARY.md` when relevant.
9. Only then recommend or begin work. Then read `AGENTS.md` (root) for working rules.

## Evidence tags used in every handoff document
| Tag | Meaning |
|---|---|
| **[V]** | Verified by reading the named file in this repo |
| **[S]** | Verified by running something in an AI sandbox (never means "works on the phone") |
| **[D]** | Stated in repo documentation or a log; not re-checked |
| **[O]** | Stated by the owner in conversation; not re-checked |
| **[I]** | Inferred by the author of the handoff |
| **[U]** | Unknown / not checked |

"The code exists" is never evidence that a feature works. Device testing is stated only where a source says it happened.

## Ground rules in one screen
- The owner decides everything. ChatGPT leads visual design direction; a coding AI implements and tests; the owner tests on his phone.
- Do not claim anything is tested unless it was. Do not invent files or behaviour.
- Do not touch legacy identity (app id, signing key, storage key `aryaApp2`, backup format) without the owner's explicit OK.
- No secrets, keystores, personal backups in this repo (it is public).
- Neither architecture path is approved (`ARCHITECTURE_DECISIONS.md`). Do not start the redesign.

## Where things are, at a glance
| Need | Go to |
|---|---|
| Native prototype code | `app/src/main/java/com/aeruno/nativeprototype/` |
| Prototype card plan and rules | `AGENTS.md` Part 2 |
| Prototype change log | `docs/log/` |
| Legacy app source (read-only copy) | `AERUNO_HANDOFF/legacy-reference/` |
| Legacy web UI | `AERUNO_HANDOFF/legacy-reference/web/` |
| Legacy native Java | `AERUNO_HANDOFF/legacy-reference/native/java/` |
