# Owner architecture decision — 2026-11-23

**Decision: Path A — Native Android with Kotlin + Jetpack Compose.**

**Decision status:** Owner-selected. This is the architecture direction for the new AERUNO Android app.

## What the owner selected

AERUNO will be rebuilt as a native Android application. The production UI will be written in Kotlin using Jetpack Compose. The app will not use the redesigned Capacitor/WebView interface as its main UI architecture.

## What happens to the HTML prototypes?

The HTML files created during design are not converted automatically into Kotlin. They are working visual/interaction prototypes and specifications. Once a screen is reviewed and approved:

1. Extract its visual rules (layout, typography, spacing, colour, surfaces, graphics and motion).
2. Extract its interaction/state rules and connect them to verified legacy behaviour.
3. Recreate the screen with Kotlin and Jetpack Compose.
4. Connect it to native application state, domain logic and repositories.
5. Add persistence and Android service integration where the feature needs them.
6. Test the feature in CI and on the owner's Android phone.

The HTML remains a reference artifact. It is not copied into the app as a WebView shortcut and is not a source of live production data.

## What happens to the legacy app?

The existing Arya Fit/AERUNO V1 app stays in its separate repository and remains the working functional reference while the native app is developed. Its frozen copy under `AERUNO_HANDOFF/legacy-reference/` is read-only.

- Preserve the legacy package ID `com.arya.fit3`, signing, local storage key `aryaApp2`, data schema, backup/export format and native services unless the owner separately authorises a specific change.
- Port pure JavaScript business engines to Kotlin with equivalent unit tests. Do not mechanically translate DOM-dependent code or preserve the old global-variable architecture.
- Review each Java Android service. Reuse platform-independent portions where sound; replace Capacitor-only plugin wrappers with native Kotlin-facing interfaces/adapters where necessary.
- Build and test a deliberate legacy export/import route. Do not assume the new app can safely read or rewrite the old app's private storage directly.

## Current repository and app identity

`opkillerbg-dev/Aeruno-Native-beta` is the current native development workspace. Its existing application is still a prototype and is not automatically production-ready. The current package ID `com.aeruno.nativeprototype` remains temporary.

The final production repository strategy, application ID, signing and distribution are not decided by this architecture selection. Keep debug builds only until separately authorised.

## What this decision does not claim

This choice is not proof that all features have been migrated, that the existing prototype is complete, that native performance targets have been met, or that data migration is solved. Those are delivery gates in the implementation plan.

## Next approved project activity

Continue the G01 Plan design sequence: Day Actions next, then Full Plan Calendar, followed by an end-to-end Plan review. Use the completed Visual Reference Pack as the primary visual benchmark and the legacy source as the behaviour reference. After the relevant design approvals, proceed through the Path A technical foundation and vertical implementation gates in `IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`.

## Authority

This record documents the owner's explicit Path A selection made on 2026-11-23. It supersedes the earlier `UNDECIDED` status in `ARCHITECTURE_DECISIONS.md` and the historical instruction to keep the architecture undecided in `ARCHITECTURE_DECISION_OVERRIDE_2026-11-21.md`. That older override remains authoritative for its separate correction: do not use the V1 Smooth/Lite or failed V2 lag history as evidence against WebView or as a prerequisite for architecture selection.
