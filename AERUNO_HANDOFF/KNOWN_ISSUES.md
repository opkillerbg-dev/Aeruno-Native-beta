# Known issues and missing information

Each item is labelled **VERIFIED** (seen in files or run), **DOCUMENTED** (stated in a repo document, not re-checked), **INFERRED** (author's reasoning) or **UNKNOWN**. `LEGACY/` = `AERUNO_HANDOFF/legacy-reference/`.

## A. Incomplete or conflicting source material
| # | Item | Label |
|---|---|---|
| A1 | `LEGACY/signing/debug.keystore` was deliberately **not copied** (signing material). Fingerprint files are included. | VERIFIED |
| A2 | No git history, no `.git`. The legacy commit is known only from the ZIP comment (`SOURCE_MANIFEST.md`). | VERIFIED |
| A3 | No generated `android/` project and no final merged `AndroidManifest.xml` (CI creates them). Permissions/services can only be read from `tools/patch-*.sh/py` and `docs/PERMISSIONS.md`. | VERIFIED |
| A4 | No `package-lock.json`; `build.yml` uses `npm install`. Dependency versions float within `^` ranges. | VERIFIED |
| A5 | `LEGACY/docs/log/` does not exist although `CURRENT.md`/`BACKLOG.md` cite log files (e.g. `docs/log/2026-11-16_baseline.md`). `LEGACY/AGENTS.md` does not exist although `WORKFLOW.md` names it. | VERIFIED |
| A6 | `LEGACY/docs/DESIGN_TOKENS.md` is byte-identical to the native prototype's N02 tokens doc and describes Compose files absent from legacy. Misplaced. | VERIFIED |
| A7 | `LEGACY/docs/RELEASE_NOTES.md` (v106 to v115) says 77 of 108 exercises have text only; the current tree has 62 exercise pictures (so 46 without). The note is stale for v150. | VERIFIED |
| A8 | `docs/CURRENT.md` says both "installed app id unverified" (line 43) and "confirmed by the owner 2026-11-16 ... same id and key" (line 16). | VERIFIED (conflict) |
| A9 | The older partial legacy snapshot used in an earlier audit is a strict subset of this ZIP (all 178 shared files byte-identical), so nothing was lost by using only this one. | VERIFIED |
| A10 | The native prototype state assumed here is the base ZIP plus the N03 and N04 deliveries as the author produced them. The owner's live repo may differ. | UNKNOWN |
| A11 | No real user backup, no real data, no APKs, no CI logs, no screenshots of the running app (only `LEGACY/docs/v1-simplify/*.jpg` UI screenshots from an earlier phase). | VERIFIED |

## B. Unverified features
| # | Item | Label |
|---|---|---|
| B1 | Background GPS during a run, step counter after reboot, hidden step notification: untested on a real device. | DOCUMENTED (`LEGACY/docs/CURRENT.md`) |
| B2 | All rows of `LEGACY/docs/DEVICE_TEST.md` have blank results. | VERIFIED |
| B3 | 34 Python/Playwright UI tests were not run by the handoff author. | VERIFIED |
| B4 | The Java services were first compiled by CI after the v141 edits and build #128 was green; not re-run here. | DOCUMENTED |
| B5 | Whether backup export/import round-trips every important field (`DEVICE_TEST.md` D1 blank). Items missing from the export are listed in `DATA_AND_MIGRATION.md`. | INFERRED |
| B6 | Widgets, icon switching, voice, nudges under Doze, weather: no recorded device results. | VERIFIED (absence) |
| B7 | New-user experience ("Diwali" test) not done. | DOCUMENTED |

## C. Performance questions
| # | Item | Label |
|---|---|---|
| C1 | The V2 liquid-glass look lagged on the owner's phone. **Cause unproven**; do not assume blur, WebView or GPU without measurement. | DOCUMENTED + OWNER |
| C2 | Legacy contains a performance governor (`web/js/ui/perf.js`) and a Lite mode that lower glass cost during scroll; their effect was never measured here. | VERIFIED (code), UNKNOWN (effect) |
| C3 | No performance measurement exists for the native prototype's glass or progressive blur. | VERIFIED |
| C4 | Whether the legacy lag disappears in Lite mode is untested (a 2-minute owner test would show it). | UNKNOWN |

## D. Architecture decisions unresolved
Path A vs Path B, repository for the final app, application id and signing, data migration method, whether to keep legacy running in parallel: all **UNDECIDED** (`ARCHITECTURE_DECISIONS.md`).

## E. Native service risks
| # | Item | Label |
|---|---|---|
| E1 | `RunService` stores the track in static in-memory fields and is not sticky; run recovery relies on JS storage (`aryaRun1`). | VERIFIED |
| E2 | GPS filtering exists in `RunTrack.java` and `runcalc.js`; keeping them in step is manual. | VERIFIED |
| E3 | Foreground-service types `location`/`health`, boot receiver, background-location permission (declared; no request for it found in repo code per `PERMISSIONS.md`) at targetSdk 36 / Android 16: behaviour untested. | DOCUMENTED + UNKNOWN |
| E4 | `StepsPlugin` bundles plugin, service and receiver in one file. | VERIFIED |
| E5 | Legacy `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` is Play-restricted if a store release is ever planned. | DOCUMENTED |

## F. Data migration uncertainties
Real data size (routes inside one JSON blob), exact `PR` key list, fidelity of import, whether native SharedPreferences carry anything the export lacks (voice, widget, icon choice), in-place update viability (needs legacy id and key): see `DATA_AND_MIGRATION.md`. Labels: INFERRED / UNKNOWN.

## G. Testing gaps
No automated tests for native services, widgets, notifications, GPS; CI gates are thin (only `store.test.js` blocks); no tests for the Compose prototype; no performance harness executed (`BUILD_AND_TESTING.md`).

## H. Missing materials that would raise confidence
Real redacted backup (verify import and size); legacy CI run log or the merged `AndroidManifest.xml` from a build; results of `DEVICE_TEST.md`; System WebView version of the owner's phone; the owner's Lite-mode lag test; the owner's confirmation of the N04 build/look; live legacy repository state if it moved past v150.
