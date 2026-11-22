# AERUNO — Native prototype repository and product handoff

> **Start with [`START_HERE.md`](START_HERE.md).** It identifies the active design phase, current source-of-truth documents and exact next task.

This public repository contains:

- AERUNO's project handoff and design archive.
- A read-only reference copy of legacy V1 under `AERUNO_HANDOFF/legacy-reference/`.
- A small experimental Kotlin/Jetpack Compose prototype under `app/`.
- Design prototypes and supporting review records under `design/`.

It is **not yet the production AERUNO application**. The legacy app remains separate and must not be modified from this repository.

## Current phase

**Milestone 1 — Product and design foundation.** The current main Plan candidate is `design/plan-screen/aeruno-plan-g01-v03.html`; its status is Proposed / owner review pending, not Approved. The selected direction is Concept B — Program Edition + Concept A — Training Route. Natural scrolling, variable-height weekly rhythm, Progressive Blur and selective Liquid Glass are part of the working direction.

The completed eight-image Visual Reference Pack v1 is supplied separately as a companion ZIP and is the primary creative benchmark. Do not regenerate it.

Architecture (native Compose vs redesigned Capacitor/WebView), implementation and migration remain undecided/not approved. The native prototype is an experiment, not the final architecture.

## Where to read

- [`START_HERE.md`](START_HERE.md) — current handoff and precedence.
- [`AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md`](AERUNO_HANDOFF/CURRENT_DESIGN_STATE.md) — detailed current state.
- [`AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-22.md`](AERUNO_HANDOFF/OWNER_DECISIONS_OVERRIDE_2026-11-22.md) — newest owner decisions.
- [`AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md`](AERUNO_HANDOFF/PRODUCT_AND_DEVELOPMENT_PLAN.md) — three development milestones.
- [`AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md`](AERUNO_HANDOFF/VISUAL_REFERENCE_PACK_GUIDE.md) — companion reference pack rules.
- [`design/plan-screen/README.md`](design/plan-screen/README.md) — Plan research and current artifact links.
- [`AGENTS.md`](AGENTS.md) — working rules for coding/design AIs.

## Safety

This repository is public. Never add credentials, API keys, keystores, personal data, personal backups or release signing material. Do not edit `AERUNO_HANDOFF/legacy-reference/`. Preserve the existing app ID, storage contracts, backup format, native services and build workflows unless the owner explicitly approves a change.

## Repository update workflow

The established workflow accepts one file named `update.zip` at the repository root. It writes or replaces repo-relative files, commits them, removes the uploaded ZIP and attempts to start the debug build. It **does not delete existing files**; cleanup deletions require a separate GitHub repository action. Files inside `.github/` are skipped and must be handled manually if ever necessary.
