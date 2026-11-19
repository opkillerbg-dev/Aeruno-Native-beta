# AERUNO Native (prototype)

A small test app to see whether the "Verdant Glass" look can run smoothly on a real phone. It is **not** the real AERUNO app; the real one lives in a different repo and is not touched here.

Plan and rules for everyone working here: [`AGENTS.md`](AGENTS.md). What the old app has: [`docs/BASELINE_LEGACY.md`](docs/BASELINE_LEGACY.md). Tool versions: [`docs/VERSIONS.md`](docs/VERSIONS.md).

**Status:** N01 and N02 done. N03 delivered, waiting for its check: the app now shows a card test (one card, three surfaces A glass / B clear / C solid) to see whether real backdrop blur looks right on the phone. Next: N04 after N03 passes.

- App id: `com.aeruno.nativeprototype` (temporary, debug builds only).
- Needs Android 12 or newer (minSdk 31).
- No keys, passwords or secrets live in this repo, and none are needed.

## How the app gets built (nothing to install on your computer)

GitHub builds it for you. The workflow `Build debug APK` runs on every push to `main`, or when you start it by hand: **Actions tab > Build debug APK > Run workflow**.

## Get the app onto your phone

1. Open the repo in your phone browser, tap **Actions**, then tap the newest **Build debug APK** run. A green tick means it worked.
2. Scroll to **Artifacts** and tap **aeruno-native-debug-apk**. A zip file downloads (you must be logged in to GitHub).
3. Open the zip in your Files app and extract it. Tap the `.apk` inside.
4. Android will ask to allow installs from that app (Files or Chrome). Allow it, then tap Install.
5. **Before installing a newer build, uninstall the previous "AERUNO Native (proto)".** Every build is signed with a fresh debug key, so Android refuses to update over an older one. Nothing is lost: there is no data in the prototype.

If the run is red, tap it, tap the red **Build debug APK** job, and screenshot the first red error line.

## How changes get into this repo

Easiest way: upload one file named `update.zip` to the top folder of the repo (Add file > Upload files). The workflow `Apply update` unpacks it into the right folders, deletes the zip, commits, and starts a build.

Workflow files (anything inside `.github/`) are **skipped** in a zip on purpose; GitHub does not let the built-in token change them. Add those by hand: Add file > Create new file, type the path (for example `.github/workflows/build.yml`), paste the content, commit.

## Building on your own computer (optional)

You need JDK 17 and Gradle 8.13. This repo does not include the Gradle wrapper, so run `gradle assembleDebug` yourself (not `./gradlew`). The APK appears in `app/build/outputs/apk/debug/`.
