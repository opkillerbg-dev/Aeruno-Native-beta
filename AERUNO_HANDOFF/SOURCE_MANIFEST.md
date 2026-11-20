# Source manifest

Tags: see `../START_HERE.md`. This file says exactly which source material is in the package, where it came from, and what is missing.

## 1. Legacy snapshot (primary, authoritative)
| Field | Value |
|---|---|
| Source | ZIP of the legacy repository `Arya-Fit-app` (branch `main`), uploaded by the owner on 2026-11-20 as `Arya-Fit-app-main__2_.zip` (shown as "Arya-Fit-app-main (2).zip" in some browsers) [V upload name] |
| Commit | `e55d0768be92126b169f6b12e98f803afe7e2301`, read from the ZIP archive comment (GitHub archive format) [V comment; I that it is the commit hash] |
| App version | **v150** (`web/sw.js` cache `arya-v150`; About page "AERUNO · v150") [V] |
| Original archive | 469 entries, 423 files, about 6.4 MB compressed, 7.2 MB unpacked [V] |
| Location here | `AERUNO_HANDOFF/legacy-reference/` (original folder structure preserved, files byte-identical to the ZIP) [S: `diff -rq`] |
| Files copied | **422** (all files except one) |
| Size here | 7.2M |

### Contents by folder (files)
- `.github/`: 2 files
- `docs/`: 46 files
- `native/`: 75 files
- `tests/`: 52 files
- `tools/`: 16 files
- `web/`: 225 files
- `signing/`: 2 files
- root files: `README.md`, `package.json`, `capacitor.config.json`, `.gitignore`
- `web/` detail: css 20, js 68, fonts 4, images 126, icons 3 (+ `index.html`, `sw.js`, `manifest.webmanifest`, `v2-kit.html`)
- `native/` detail: java 15, res 60

### Excluded or not obtainable
| Item | Why |
|---|---|
| `signing/debug.keystore` | Signing material; never included. The two fingerprint text files in `signing/` are included |
| Git history, `.git` | Not in the ZIP |
| Generated `android/` project, merged `AndroidManifest.xml` | Created by CI at build time; not in the repo |
| `package-lock.json`, `node_modules` | Not in the repo / not copied |
| `docs/log/` (referenced by `CURRENT.md`), legacy `AGENTS.md` (referenced by `WORKFLOW.md`) | Absent from the ZIP |
| APKs, CI run logs, real user backups, device-test results | Not provided; none included |

## 2. Comparison with the earlier legacy snapshot
An earlier, partial snapshot (the "handoff reference" frozen at v150 plus two CI helper scripts) was inspected before this ZIP. **All 178 files in it exist in this ZIP with identical bytes; the old snapshot has nothing this ZIP lacks.** This ZIP additionally provides: all CSS (20 files), fonts (4), images (126 exercise/hero/anatomy assets), icons, the native Android resources (46), `sw.js`, `manifest.webmanifest`, `v2-kit.html`, both workflows, `README.md`, `.gitignore`, `signing/` fingerprints, and docs (`CURRENT.md` was already there; new: `WORKFLOW.md`, `tasks/BACKLOG.md`, `DEVICE_TEST.md`, `PERMISSIONS.md`, `onboarding/`, `v1-simplify/`, `archive/`, `brand/`, `art/`, `RELEASE_NOTES.md`, `THIRD-PARTY-NOTICES.md`, `licenses/`). The old snapshot was not copied (redundant). One historical planning document from that bundle is kept separately: `AERUNO_HANDOFF/historical/AERUNO-Native-Migration-Plan.md`.

**Historical, not current:** `historical/AERUNO-Native-Migration-Plan.md` is an early plan that assumes a native migration. It is **not an approved plan**; the architecture is undecided (`ARCHITECTURE_DECISIONS.md`). Also historical inside legacy: `LEGACY/docs/archive/`.

## 3. Native prototype
| Field | Value |
|---|---|
| Repository | `opkillerbg-dev/Aeruno-Native-beta` (public) [V `AGENTS.md`] |
| Base | ZIP `Aeruno-Native-beta-main__1_.zip`, commit `cafb90b3c3a2d1bc5c914b9761e3388c3475266c` (ZIP comment) at the state seen on 2026-11-20 (cards through N02 delivered) [V] |
| Added by deliveries in the same session (applied on top as `update.zip` files) | N03 (`ui/glass/GlassSurface.kt`, `ui/cardtest/CardTestScreen.kt`, Haze dependency) and N04 (`ui/glass/ProgressiveEdgeBlur.kt`, `ui/topblur/TopBlurTestScreen.kt`, `MainActivity` switch) |
| This package | Adds `START_HERE.md`, `AGENTS.md` (general rules + original prototype plan), `AERUNO_HANDOFF/`, `docs/log/2026-11-20_handoff.md`, a README pointer |
| Caveat | The author could not see the owner's live repo. Whether the N03 and N04 deliveries were applied exactly as produced is only partly known (N03 confirmed by the owner; N04 not recorded) [U] |

## 4. Package size
Legacy reference: about 7.2 MB (422 files). The 14 handoff documents: about 140 KB. Whole `update.zip` contents unpacked: about 7.3 MB (441 files); the zip itself is compressed (size reported in the delivery message). The package is far below GitHub's 25 MB browser-upload limit.

## 5. Which material is current, old, or incomplete
| Material | Status |
|---|---|
| `legacy-reference/` | Current legacy at v150, complete except the items in section 1 |
| `historical/` and `legacy-reference/docs/archive/` | Old / historical |
| `legacy-reference/docs/DESIGN_TOKENS.md` | Misplaced (native doc); ignore for legacy |
| Native prototype `app/` | Current prototype; experimental; N04 unconfirmed |
