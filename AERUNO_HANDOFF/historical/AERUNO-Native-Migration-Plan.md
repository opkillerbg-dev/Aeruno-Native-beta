# AERUNO Native Migration Plan

## Decision
Build a new Android-native AERUNO project using Kotlin + Jetpack Compose. Keep the current Capacitor app as the stable legacy version during migration. Do not overwrite, rebrand, sign, or change the app ID of the legacy app as part of this project.

## Principles
- Native-first UI and interaction.
- Performance is a design requirement; glass is used selectively and benchmarked.
- Preserve features and data. Do not simplify by deleting functionality.
- Implement in vertical slices, with a runnable build and tests at each phase.
- Keep legacy and native project separate until migration and data-import strategy are validated.
- Never make release signing / identity / migration decisions without owner approval.

## Stack (initial proposal)
- Kotlin
- Jetpack Compose + Material 3 (custom AERUNO design system)
- MVVM / unidirectional data flow
- Navigation Compose
- Room for structured records
- DataStore for preferences
- Android location APIs and foreground services for active run tracking
- Sensor APIs / supported recording APIs for steps, evaluated separately
- Unit tests, Compose UI tests, integration/device tests

## Phase 0: Audit and baseline
- [x] Inspect latest legacy ZIP and current documentation
- [x] Inventory top-level feature areas and native Java components
- [ ] Create feature-by-feature migration matrix (logic, data, UI, native dependencies, test coverage)
- [ ] Identify data formats and export/import compatibility requirements
- [ ] Define baseline performance metrics and target device test scenarios

## Phase 1: Native skeleton
- Create separate native repository/project and package namespace (not yet chosen for release)
- Gradle/version catalog, dependency choices, build workflow, lint and tests
- Theme tokens: color, typography, spacing, shape, elevation, motion
- Navigation scaffold and screen-state architecture
- No access to legacy data yet; use sample data

## Phase 2: UI prototype and benchmark
- Today dashboard
- Bottom navigation and shell
- Cards, sheets, dialogs, controls and chart primitives
- BitChord visual/performance study; reproduce reference effects in a small isolated benchmark
- Benchmark glass vs opaque/translucent alternatives; avoid broad blur layers and overdraw
- Approve design direction before expanding screens

## Phase 3: Data and domain foundation
- Define models and repositories
- Room schema and migrations
- DataStore settings
- Backup/export format and compatibility mapping
- Unit tests for domain logic

## Phase 4: Feature migration (vertical slices)
1. Today / dashboard and navigation
2. Plan / schedule / plan generation
3. Exercise library and media
4. Workout session, timers, progression, loads, PRs
5. Progress / analytics / summaries
6. Steps and widgets
7. Run tracking, GPS, background service, run history, GPX
8. Voice / hands-free and notifications
9. Backup/import/export, settings and onboarding

Each slice must include UI, domain logic, persistence where needed, tests, and a verification checklist before the next slice.

## Phase 5: Legacy data migration
- Read and document legacy export format
- Build a migration/import tool in the native app
- Test valid, large, malformed, interrupted and duplicate imports
- Keep original data untouched and require explicit user action

## Phase 6: Device validation
- Permissions and permission revocation
- Foreground/background GPS and locked screen
- Battery saver and lifecycle interruptions
- Steps across app closure, reboot and midnight
- Backup/restore and upgrade/import scenarios
- Frame pacing, scroll performance, startup, memory and battery benchmarks

## Phase 7: Release decisions
- Decide app identity/package ID and signing strategy
- Internal testing track / store release readiness
- Privacy, permissions, accessibility, crash reporting and release checklist
- iOS scope decision only after Android-native foundation is stable

## Legacy feature inventory (initial)
- Plan UI and plan engine
- Exercise database, library, media and swaps
- Builder and coaching/calculation systems
- Progression, loads and PRs
- Readiness and retesting
- Timers and workout-session UI
- Running: GPS engine, service, maps, route, extras, summary, GPX
- Steps, progress, notifications and widgets
- Voice / hands-free
- Backup, sync and data import/export
- Onboarding, settings, profile, nudges and help

## Guardrails
- Legacy app remains usable during native development.
- No legacy data schema, package ID, signing key, or workflow changes for the native project without explicit approval.
- No feature marked migrated until tested.
- Avoid premature abstraction and unnecessary dependencies.
