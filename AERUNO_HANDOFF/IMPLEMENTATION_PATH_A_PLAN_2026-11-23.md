# AERUNO Path A — implementation plan

**Target:** Native Android app using Kotlin + Jetpack Compose.  
**Owner decision:** Path A selected on 2026-11-23.  
**Current project phase:** Finish and approve the G01 Plan design flow; then pass native foundation gates and implement approved feature slices.

This plan explains how the current HTML design work becomes a real native Android app. It is the execution companion to `OWNER_ARCHITECTURE_DECISION_2026-11-23.md`.

---

## 1. The key workflow: HTML design → native Compose implementation

HTML prototypes are not compiled or automatically converted into Kotlin. They have a different job: make the screen's appearance and interaction clear enough to implement accurately.

For each feature/screen:

1. **Research:** inspect the legacy source, current feature inventory, data states, edge cases and existing tests.
2. **Design:** create an HTML prototype showing layout, responsive states and interaction behaviour. Use the completed AERUNO Visual Reference Pack as the art-direction benchmark.
3. **Review:** owner and ChatGPT review the prototype; correct visual and functional mismatches. Record Approved / Proposed / Open / Untested status.
4. **Specification:** record screen states, user actions, validation, empty/error/disabled states, data inputs/outputs and source evidence in a concise handoff.
5. **Compose build:** recreate the approved design in Kotlin/Jetpack Compose. Reuse the existing bundled fonts, design tokens and suitable local assets where appropriate. Do not embed the prototype HTML as the production screen.
6. **Logic and data:** implement state holders/ViewModels, Kotlin domain/use-case logic and repositories. Port pure JS algorithms with equivalent Kotlin tests; replace DOM/global-dependent controllers with clean native state flows.
7. **Android integration:** connect required permissions, foreground services, sensors, location, notifications, widgets and file access through native Android APIs or reviewed Kotlin adapters.
8. **Verification:** run unit tests, Compose UI tests and CI build. Owner installs the APK and verifies the behaviour on the real phone. Mark anything not run as UNTESTED.
9. **Close:** record changed files, evidence, untested items, owner decisions and next task in `docs/log/`. Only then start the next vertical slice.

One HTML screen is therefore a **design blueprint**, not a finished app feature. A feature is complete only when the Compose UI, behaviour, data, tests and phone verification have passed its gate.

---

## 2. Current stage — finish the Plan experience design

The Plan area should be designed as one connected user journey before its full native implementation begins.

| Order | Design task | Current status / purpose |
|---|---|---|
| G01 Plan main screen | Main programme identity, week navigation, rhythm, selected session and upcoming sessions | Existing V03 baseline and research; keep as current reference, review status separately |
| Manage Plan | Programme-level management actions | V05.2.1 is the current owner-reviewed design baseline |
| G01 V06 Day Actions | Selected-day context, edit, swap, reschedule, finish/reopen | **Next design task** |
| G01 V07 Full Plan Calendar | Full-programme overview and date/day navigation | Follows Day Actions |
| G01 Plan system review | Main Plan + Manage + Day Actions + Full Plan Calendar; verify states and cross-navigation | Required before closing the Plan design package |

After the Plan package is reviewed, continue designing the remaining app areas using the existing Round 2 screens and legacy feature inventory as references. Do not redesign completed screens without a concrete owner-approved reason.

Suggested screen-design sequence after Plan:

1. Workout/Train experience: exercise detail, active workout, set logging, rest timer, pause/resume/finish and session summary.
2. Run experience: pre-run, active GPS session, paused state, route/map, finish summary and history.
3. Progress and history: weekly/monthly views, personal records, session history and trends.
4. Me/Profile and settings: profile, preferences, reminders, voice, appearance and help.
5. Supporting flows: onboarding/retest, plan builder, exercise library, import/export, widgets and notifications.

The order can be adjusted when feature dependencies require it. Keep each task small and owner-reviewed.

---

## 3. Native technical foundation and quality gates

Path A has been selected, but the native prototype is still a prototype. Before broad feature implementation:

- Inspect the current Compose source and N04 progressive top-blur implementation.
- Finish the N04 build/device review gate or document a concrete replacement decision.
- Complete the native N05 benchmark or a documented equivalent relevant to AERUNO's real screen effects. Compare the glass, translucent and solid surfaces under repeatable conditions; do not claim native smoothness without measured results on the owner's phone.
- Confirm CI builds the current native app and produces a debug APK.
- Establish the Compose app shell and canonical navigation: Today · Plan · Train · Progress · Me.
- Translate the approved design tokens and bundled AERUNO fonts into the Compose theme. Do not add remote font dependencies.
- Define a consistent state/navigation pattern and reusable primitives only after the actual screens establish what is needed.
- Review accessibility, system insets, larger text, reduced motion, back behaviour and dark/light system interactions.

The N04/N05 work is a native-quality validation gate, not a reconsideration of Path A versus Path B. If a serious blocker appears, document evidence and ask the owner before changing direction.

---

## 4. Domain and data foundation

Before or as part of the first real feature slice, define the minimum shared foundations:

- Kotlin data models for plans, scheduled days, exercises, workout logs, runs, steps, goals and settings.
- Repository interfaces separating UI from storage and Android services.
- State holders/ViewModels and one-way UI state/event flow.
- Persistence and schema versioning. Room is the current migration-plan proposal for structured records; DataStore is the proposal for settings/preferences. Validate the final boundaries before committing the schema.
- Unit-test structure for business rules and migration edge cases.
- Date/time rules, time zones, day rollover and background update behaviour.
- Backup/export envelope and compatibility strategy with the legacy format.

Do not build a large abstract framework before the first feature requires it. Establish only the foundations needed for reliable vertical slices.

---

## 5. Feature implementation — vertical slices

Each slice includes native UI, Kotlin logic, data, Android integration where required, tests, CI and owner device review.

| Suggested order | Feature slice | Main responsibilities |
|---|---|---|
| 1 | Plan & schedule | Plan models, week/day state, Plan UI, Manage, Day Actions, calendar, builder, Smart Week rules |
| 2 | Exercise library | Exercise catalogue, search/filter, exercise detail/media, same-muscle swap rules |
| 3 | Workout sessions | Set logging, reps/sets, progression, PRs, rest/countdown/interval timers, active session lifecycle |
| 4 | Running | GPS foreground service, route, pause/resume, run/walk levels, summary, GPX and history |
| 5 | Steps and activity | All-day step recording, permissions, boot/restart, daily totals and history |
| 6 | Progress and history | Aggregates, charts, weekly review, personal records, recovery/volume insights |
| 7 | Profile and settings | Goals, profile, preferences, appearance, notifications, voice, help |
| 8 | Supporting integrations | Widgets, file sync, import/export, sharing and other inventory items |

Reorder only for genuine technical dependencies, and record why. A feature is not marked migrated because its screen exists; its behaviour and data must also be verified.

---

## 6. Legacy functionality and service reuse

Use the frozen V1 source as the behaviour and data reference, not as the new UI architecture.

- **Pure JS engines:** port to Kotlin one by one. Keep the existing Node tests as behavioural specifications and create equivalent Kotlin unit tests before replacing each engine.
- **DOM/global-coupled JS:** do not port the old `APP`, `st`, `PR` and DOM controller structure wholesale. Extract rules into Kotlin domain/use-case classes and state holders.
- **Java Android services:** review service classes that do not depend on Capacitor for direct reuse or careful migration. Check manifests, permissions, foreground-service types, receivers, lifecycle and target SDK compatibility.
- **Capacitor plugins:** do not carry plugin wrappers into the native app. Replace them with Kotlin interfaces/adapters that call Android services directly.
- **Capacitor-dependent data wrappers:** explicitly remove/replace `JSObject` and `PluginCall` boundaries (for example around run state) with Kotlin data models or Android-neutral DTOs.
- **Exercise images/data:** reuse bundled data/assets after checking licensing, size, naming and offline behaviour.
- **Tests:** port/recreate tests for plan generation, Smart Week, set progression, timers, GPS calculations, GPX, storage, backup and other covered logic.

`AERUNO_HANDOFF/legacy-reference/` is read-only. Any change to the live legacy repository requires a separate explicit owner instruction.

---

## 7. Legacy data migration and safety

The native app must not silently assume the legacy app's private storage can be shared.

1. Document the actual legacy export format and current schema.
2. Design an explicit import flow in the native app.
3. Validate incoming files before committing them.
4. Test normal, large, malformed, duplicate, interrupted and partially invalid imports.
5. Verify plans, workout logs, runs/routes, steps, PRs, settings and media references as applicable.
6. Keep the original legacy app/data untouched during testing; never use a personal backup in the public repository.
7. Require explicit user action to import and provide a clear success/failure summary.
8. Verify restore/export round trips before release.

The old package ID, signing key, `aryaApp2` storage key/schema and backup format remain frozen until the owner explicitly authorises a separate migration/release action.

---

## 8. Device validation and release

### Device validation

Test on the owner's actual Android phone, including:

- Permissions granted, denied and later revoked.
- GPS foreground tracking, lock screen, backgrounding, interruptions and recovery.
- Steps across app closure, reboot and midnight.
- Timers and workout lifecycle across app switching, screen lock and process recreation.
- Notifications, widgets and Android back behaviour.
- Accessibility: TalkBack, touch targets, font scaling, reduced motion and contrast.
- Frame pacing, startup, memory, battery and temperature under repeatable conditions.
- Data backup, restore, upgrade and import compatibility.

### Release decisions (still open)

Before any production release, separately decide the production package ID, signing/keystore custody, distribution method, privacy/permissions disclosures, backup policy and release channel. The current prototype ID is temporary. Do not create or commit release secrets in this public repository.

---

## 9. Definition of done for the new AERUNO app

The app is ready only when:

- Approved designs are faithfully implemented in Compose.
- Required legacy capabilities are migrated or explicitly excluded by owner decision.
- Core domain rules have tests and pass.
- Persistence, backup and legacy import/restore are verified.
- GPS, steps, notifications, widgets and background features pass device tests where included.
- Accessibility, lifecycle and failure states are reviewed.
- CI builds reproducibly and the owner has tested the release candidate on-device.
- No legacy app data or identity was changed without explicit approval.

Never mark a feature migrated or production-ready based on a visual prototype alone.
