# Pinned versions (N01)

Looked up on 2026-11-19 in the official Android and Gradle release pages. **None of these has been compiled together yet**; compatibility is proven only when the GitHub build is green. If a build fails because of a version, change it here and in `gradle/libs.versions.toml`, and log why.

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

GitHub Actions used: `actions/checkout@v4`, `actions/setup-java@v4`, `gradle/actions/setup-gradle@v4` (installs Gradle 8.13), `actions/upload-artifact@v4`. The first two and the last were used by the owner's older project's build and ran fine (with deprecation warnings). `setup-gradle@v4` is new here. Update them together in a later card.

Not included on purpose: Gradle wrapper (needs a binary file that cannot be downloaded in the coding sandbox), Haze or any blur library (N03), fonts (N02), tests, release signing.

Dependencies in the app: Compose UI, Compose Foundation, Material 3 (only as a base for the custom theme) and activity-compose. Nothing else.
