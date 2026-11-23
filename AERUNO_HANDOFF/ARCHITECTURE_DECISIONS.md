# Architecture decision record

**STATUS: PATH A SELECTED BY OWNER — 2026-11-23.** The target architecture for the new AERUNO Android app is a complete native Android application using **Kotlin + Jetpack Compose**. This supersedes the previous `UNDECIDED` status. The owner has selected Path A; Path B is not the planned implementation route.

Decision record: [`OWNER_ARCHITECTURE_DECISION_2026-11-23.md`](OWNER_ARCHITECTURE_DECISION_2026-11-23.md). Execution plan: [`IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md`](IMPLEMENTATION_PATH_A_PLAN_2026-11-23.md).

## What this decision means

- The new AERUNO user interface and application flows will be implemented natively in Kotlin + Jetpack Compose.
- The existing `Aeruno-Native-beta` repository is the current native development workspace. Its current contents are still a prototype and must be inspected before treating any component as production-ready.
- HTML/CSS/JavaScript design prototypes are visual and interaction specifications. They are **not automatically converted to Kotlin**, transpiled, or shipped as production WebView screens. Approved designs are recreated as Compose UI.
- Legacy V1 remains a separate, read-only functional reference during this work. Existing business rules are ported or reimplemented in Kotlin with tests; native Java services are reused or adapted only after source and build review.
- Existing user data is preserved through a deliberately designed export/import migration. No destructive in-place rewrite of legacy data is authorised.

## Decisions not included in Path A

The owner has not thereby approved or finalised:

- The production application ID/package name or signing/release strategy. `com.aeruno.nativeprototype` remains temporary.
- Whether this repository remains the final production repository or a later clean production repository is created.
- The complete database schema, Room migrations, DataStore keys, or final repository/domain module boundaries.
- The detailed legacy data migration/import UX and release cutover date.
- Permissions, privacy disclosures, distribution channel or store-release settings.

These require separate documented decisions before the relevant implementation/release work.

## The two paths (historical comparison)

- **Path A — selected:** Complete native Android redesign using Kotlin + Jetpack Compose. The native app owns its UI, state, domain logic and persistence. Existing Java Android services may be reused behind Kotlin-facing interfaces after review. Legacy JavaScript logic is ported/reimplemented in Kotlin with tests.
- **Path B — not selected:** Complete Capacitor/WebView UI redesign retaining the web shell and much of the JavaScript runtime. Do not begin this route unless the owner explicitly reverses the decision.

## Evidence and rationale

- **[O] Owner decision (2026-11-23):** The owner explicitly chose Path A.
- **[V] Repository evidence:** The native repository already contains a Kotlin/Compose prototype, a bundled AERUNO type/palette foundation, a Haze glass experiment and Android build workflow.
- **[V] Legacy architecture evidence:** `ARCHITECTURE.md` and the frozen legacy source show that several Android services are plain Java or mostly independent of Capacitor, while some plugin wrappers and `RunService` data wrappers are Capacitor-coupled and need adaptation.
- **[I] Engineering implication:** Path A requires more deliberate porting and data migration than Path B, but creates a native Android UI and application runtime as selected by the owner.
- **[U] Not proven by this decision:** Full feature parity, final-device performance, background GPS/step reliability, migration fidelity and production readiness. These require implementation and testing.

The choice is an owner decision, not a claim that the previous comparative performance study conclusively proved native is faster. Do not invent benchmark results or describe untested features as migrated.

## Implementation constraints

1. Keep `AERUNO_HANDOFF/legacy-reference/` read-only.
2. Do not change legacy app ID `com.arya.fit3`, signing, `aryaApp2` storage, schema or backup format without explicit approval.
3. Treat `com.aeruno.nativeprototype` as temporary; do not silently promote it to the release ID.
4. Port pure JavaScript engines and their tests one at a time. Rework DOM/global-coupled code into native domain/state layers rather than carrying the old global architecture forward.
5. Reuse/adapt Android Java services only after checking Capacitor dependencies, manifests, foreground-service declarations, permissions and lifecycle behaviour.
6. Design a validated import path for existing user data before release. Keep the original legacy install/data untouched until restore is verified.
7. Implement one vertical feature slice at a time with unit tests, Compose UI tests, CI build evidence and owner device review.
