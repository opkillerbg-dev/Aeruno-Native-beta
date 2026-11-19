# Pinned versions (N01)

Looked up on 2026-11-19 in the official Android and Gradle release pages. **Compiled together successfully** in GitHub Actions run "Build debug APK #4" (2026-11-19, commit 93a3528): `assembleDebug` succeeded, and the APK installed and opened on the owner's Android 16 phone. If a build fails because of a version, change it here and in `gradle/libs.versions.toml`, and log why.

| Tool | Version | Why this one |
|---|---|---|
| Android Gradle Plugin (AGP) | 8.13.2 | Newest 8.x. Official notes: needs Gradle 8.13 and JDK 17, supports Android API 36. Chosen over AGP 9.x because 9.x changes how Kotlin and the build files work; a smaller jump is safer for a first build that nobody can test locally. |
| Gradle | 8.13 | The minimum and default version for AGP 8.13 (official table). |
| JDK | 17 (Temurin) | Required by AGP 8.13. |
| Kotlin and Compose compiler plugin | 2.3.0 | Google's own doc pairs AGP 8.13.2 with Gradle 8.13 and Kotlin 2.3.0. AGP 8.13.2 notes say its code shrinker supports Kotlin 2.3. The Compose compiler plugin must match Kotlin. |
| Compose BOM | 2026.05.00 | The Android compose-samples repo uses this BOM with `compileSdk 36` and activity-compose 1.13.0. Newer Compose releases exist, but release notes show recent versions moving toward `compileSdk 37`, so they were avoided for this first build. |
| activity-compose | 1.13.0 | Latest stable on the AndroidX page; same version as that samples repo. |
| compileSdk / targetSdk | 36 | Android 16, which is the owner's phone. AGP 8.13 supports up to 36. |
| minSdk | 31 | Owner-approved (AGENTS.md section 6). |

GitHub Actions used: `actions/checkout@v4`, `actions/setup-java@v4`, `gradle/actions/setup-gradle@v4` (installs Gradle 8.13), `actions/upload-artifact@v4`. The first two and the last were used by the owner's older project's build and ran fine (with deprecation warnings). `setup-gradle@v4` worked in run #4. Update them together in a later card.

Not included on purpose: Gradle wrapper (needs a binary file that cannot be downloaded in the coding sandbox), tests, release signing.

Dependencies in the app: Compose UI, Compose Foundation, Material 3 (only as a base for the custom theme), activity-compose and, since N03, Haze. Nothing else.

## Haze (added in N03)
| Library | Version | Why this one |
|---|---|---|
| `dev.chrisbanes.haze:haze` | 1.7.2 | Last stable 1.x release (2026-02-10; 1.7.0 notes call it the last of the 1.x line). Built against Kotlin 2.2.20 and Jetpack Compose 1.9.x; this project uses Kotlin 2.3.0 and BOM 2026.05.00, and a newer compiler reads older library metadata. Android 12+ uses the platform blur (the project's minSdk is 31). |

Checked 2026-11-20 on the official Haze changelog (chrisbanes.github.io/haze). **Not chosen:** Haze 2.0.x and 2.1.0 (2.1.0 released 2026-11-02): per the changelog they are built with Kotlin 2.4.x and Jetpack Compose 1.12.x, newer than this project's Kotlin 2.3.0 and BOM 2026.05.00, and Haze 2 moved blur to a separate `haze-blur` artifact with a different API. Upgrading is a later decision. **Compatibility with this project is not proven until a CI run is green.** If the build fails because of Haze, stop and report (no fake blur).
