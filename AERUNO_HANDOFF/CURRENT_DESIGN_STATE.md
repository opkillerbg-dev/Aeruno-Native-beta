# AERUNO current design state — 2026-11-23

## Current architecture

**Path A — native Android with Kotlin + Jetpack Compose — selected by the owner on 2026-11-23.** The final app is to be implemented natively. HTML screen files are visual/interaction prototypes and specifications; they are not automatically converted to Kotlin or shipped as WebView production screens. See `OWNER_ARCHITECTURE_DECISION_2026-11-23.md` and `IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`.

The existing `Aeruno-Native-beta` repository is the current native development workspace, but the current app remains a prototype. The temporary package ID `com.aeruno.nativeprototype` is not the final production identity. Release identity/signing and the final production repository strategy remain open.

## Current product/design phase — G01 Plan experience

The immediate work is to finish the Plan experience as a coherent set of screens and interactions, then recreate the approved result in Compose during the Plan implementation slice.

| Area | Current state |
|---|---|
| AERUNO visual language | Eight-image Visual Reference Pack v1 complete; primary creative benchmark |
| Round 2 Today designs | Existing reviewed/archived baseline; do not restart without a concrete reason |
| Main Plan | V03 editorial Plan prototype is the working design reference; Plan research remains in `design/plan-screen/` |
| Manage Plan | V05.2.1 is the current Manage Plan design baseline |
| Day Actions | **Next design task: G01 V06** |
| Full Plan Calendar | Follows Day Actions |
| Plan package review | Required after Day Actions and Calendar to check the end-to-end Plan journey |
| Native Compose implementation | Not yet started for the redesigned G01 Plan feature set |

The older first Plan exploration remains useful for functional research but its conventional visual execution is not the visual benchmark. Use the Visual Reference Pack for art direction and the legacy V1 source for functional requirements.

## Immediate next task

Create the G01 V06 Day Actions Sheet using the Visual Reference Pack, the selected G01 Plan direction and verified legacy behaviour. Its main job is to manage a selected day: edit workout, swap eligible exercises, preview rescheduling, finish or reopen the day. Preserve distinctions between completed, manually closed, rest, in-progress, ready and future states. Keep prototype actions in sample/demo state only.

After V06 owner review, design the Full Plan Calendar. Then review main Plan + Manage + Day Actions + Calendar together before closing the Plan design package.

## Locked visual direction

- Aesthetic: **Old Money × Liquid Glass**. Solid surfaces carry important information; glass is selective and functional.
- Palette: Ivory `#F3EFE4`; Deep Forest `#1F3B30`; Terracotta `#C97855`; Surface `#FFFEFA`; Surface Alt `#E7E2D6`; Sage `#DCE5D7`; Text `#202A23`; Muted `#646E65`.
- Font families: Big Shoulders Display Black, Instrument Serif Italic and Inter. No new network font dependency or font family without owner approval.
- Navigation: **Today · Plan · Train · Progress · Me**.
- Variant C: Big Shoulders Display Black at ×1.14 vertical scale, used selectively for hero titles, major workout/category words and at most one hero stat per screen. Not for ordinary UI, buttons, chips, body text, forms, timers or secondary stats.
- Session-pill timer: Big Shoulders Display (Option 2), locked; outside Variant C scaling.
- Preserve Depth B (number partially behind a foreground card) and Depth C (route crossing typography). Depth A remains exploratory. Keep real information readable.
- Keep solid Deep Forest hero surfaces, generous warm-ivory space, restrained terracotta markers and selective Liquid Glass. Do not copy the reference boards literally or use every motif at once.

## Visual Reference Pack authority

`AERUNO_Visual_Reference_Pack_v1.zip` is complete. Its eight original images, reviews, visual direction, typography/graphic rules and navigation specification are the primary art-direction source. Do not regenerate the pack or use a contact sheet as a substitute for inspecting its individual images when a task requires visual access.

## Functional authority and preservation

- Legacy V1 in `AERUNO_HANDOFF/legacy-reference/` is a frozen, read-only behaviour/data/native-integration reference.
- Existing feature capabilities and known tests are listed in `FEATURE_INVENTORY.md`.
- Legacy Smart Week, plan editing, exercise swapping, rescheduling, closure states, GPS/steps, timers, widgets and backup rules must be source-verified before being represented as real behaviour.
- Do not edit the legacy reference copy or change its app ID `com.arya.fit3`, signing, `aryaApp2` key/schema, backup format or native services without explicit owner approval.
- The native app must receive legacy user data only through a deliberate, validated import path; do not assume private app storage can be shared.

## Native proof/implementation status

- Existing Compose app: prototype/technical starting workspace, not the finished app.
- N04 progressive top blur: delivered in prototype; owner build/visual gate remains to be confirmed unless a later log proves otherwise.
- N05 benchmark and owner device measurement: pending unless later evidence proves completion.
- Full Plan feature implementation in Compose: not started.
- Room/DataStore schema, final app identity and signing: open for the appropriate implementation/release decision gates.

## Evidence and decision discipline

Use `[V]` verified in source, `[S]` sandbox run, `[D]` documented, `[O]` owner decision, `[I]` inference and `[U]` unknown/untested. Use Approved / Proposed / Open / Untested explicitly. Browser rendering does not prove Android rendering, and a prototype does not prove production functionality.
