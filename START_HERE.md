# START HERE: AERUNO project handoff

You are continuing the existing AERUNO project. Do not restart completed design work. Read this file and the linked current handoff documents before proposing or changing anything.

## Current owner decision — 2026-11-23

**Path A is selected: a complete native Android app using Kotlin + Jetpack Compose.** This is the owner's architecture decision. Path B (a redesigned Capacitor/WebView UI) is no longer the planned route.

This decision does **not** mean HTML prototypes are automatically converted into Kotlin. HTML files are visual and interaction specifications. Each approved screen will be deliberately recreated in Jetpack Compose, then connected to Kotlin application logic, persistence and Android services.

The existing `Aeruno-Native-beta` repository is the current native development workspace. Its existing app is still a prototype, not a finished production app. The temporary package ID `com.aeruno.nativeprototype`, final release package ID, signing and release identity remain separate decisions and must not be changed without explicit owner approval.

## Current project status

1. **Architecture:** Path A — Kotlin + Jetpack Compose — selected by the owner. See `AERUNO_HANDOFF/OWNER_ARCHITECTURE_DECISION_2026-11-23.md`.
2. **Implementation route:** See `AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md` for the step-by-step route from HTML design prototypes to native Compose screens and a complete Android app.
3. **Current design phase:** G01 Plan experience. The Manage Plan V05.2.1 design is the current baseline. The next design task is Day Actions, followed by Full Plan Calendar and an end-to-end Plan review.
4. **Visual authority:** The completed eight-image `AERUNO_Visual_Reference_Pack_v1.zip` is the primary creative/art-direction reference. Its guide is `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md`.
5. **Functional authority:** The frozen legacy V1 source in `AERUNO_HANDOFF/legacy-reference/` is the read-only reference for existing behaviour, data formats and native integrations. Do not modify it from this repository.
6. **Native proof work:** The existing Compose prototype and its N04/N05 visual-quality/performance checks remain useful validation work. They do not reopen the owner's Path A choice by default; they identify implementation risks that must be addressed.

## Read these first

1. `AERUNO_HANDOFF/OWNER_ARCHITECTURE_DECISION_2026-11-23.md` — the owner's selected architecture and boundaries.
2. `AERUNO_HANDOFF/IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md` — how design prototypes become native app features, in the intended order.
3. `AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md` — the exact current design checkpoint and next task.
4. `AERUNO_HANDOFF/ROADMAP.md` — full phased route to the native app.
5. `AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-21.md` — authoritative visual and project decisions; its V1/Smooth/V2 performance correction remains valid.
6. `AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md` — contents, authority and use of the completed visual pack.
7. `AERUNO_HANDOFF/ARCHITECTURE.md` — legacy/native integration facts and reuse map; estimates remain evidence-tagged.
8. `AERUNO_HANDOFF/FEATURE_INVENTORY.md` — existing features, source locations and test coverage.
9. `AERUNO_HANDOFF/DATA_AND_MIGRATION.md` — legacy data and migration constraints.
10. `AGENTS.md` — mandatory repository rules and update workflow.

## Key distinction: design prototype vs native app

- HTML/CSS/JavaScript screen prototypes are for visual exploration, owner review and interaction specification.
- Approved HTML prototypes are **not** production app screens and are not automatically transpiled or embedded in the native app.
- The native implementation recreates the approved layout and interactions with Kotlin/Jetpack Compose.
- Colours, typography, spacing, shapes, graphics and motion decisions should be translated into the native design system. Suitable image/vector assets may be reused where licensing and technical requirements permit.
- Functional rules must be implemented in Kotlin/domain code or through deliberately adapted Android services. Legacy JavaScript is a behaviour reference; it is not automatically executed by the native app.

## Project overview

AERUNO is a personal Android fitness app. The legacy V1 app is a Capacitor WebView application containing the currently working functional reference. The new AERUNO app will follow Path A and be built natively with Kotlin + Jetpack Compose. The legacy and native codebases remain separate during development and migration.

## Working roles

- Owner: final product, design, architecture and release decisions; tests on the real Android phone.
- ChatGPT: product direction, visual critique, planning and handoff guidance.
- Coding AI/engineer: inspect source, implement approved work, run tests/CI and report evidence honestly.

## Ground rules

- Path A is selected. Do not silently switch back to Path B.
- Continue design in small, reviewable tasks. Current next design task: G01 V06 Day Actions; Full Plan Calendar follows.
- Once a screen design is approved, recreate it in Compose; do not copy HTML into production as a WebView shortcut.
- Build one vertical feature slice at a time: UI, state, domain logic, persistence/native integration, tests and owner verification.
- Keep the legacy reference folder read-only. Do not modify the separate legacy repository, its app ID, signing, `aryaApp2` storage key/schema, backup format or services without explicit owner approval.
- The temporary native prototype package ID is not a release identity. Final package ID, signing and distribution remain open.
- No secrets, keystores, tokens, personal data or personal backups in this public repository.
- Do not claim a build, test, visual result or device behaviour unless it was actually performed. A sandbox/browser check is not an Android phone test.
- The update workflow expects one `update.zip` at the repository root. ZIP entries must use exact repository-relative paths, with no enclosing top-level folder. See `AGENTS.md` and `.github/workflows/apply-update.yml`.

## Evidence tags

| Tag | Meaning |
|---|---|
| **[V]** | Verified by reading the named source file in this repository |
| **[S]** | Verified by running something in an AI sandbox; not phone-tested |
| **[D]** | Documented in project files; not re-checked in this task |
| **[O]** | Owner decision or statement |
| **[I]** | Inference or recommendation |
| **[U]** | Unknown / not checked |

The existence of code or a prototype is not evidence that the feature works.
