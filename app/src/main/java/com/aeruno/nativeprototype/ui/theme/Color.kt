package com.aeruno.nativeprototype.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * AERUNO color tokens (AGENTS.md section 7). Palette A "Deep Heritage" (owner-selected 2026-11-20).
 * Brand identity: Background (ivory) + DeepForest + Terracotta. Everything else is neutral or semantic.
 */
object AerunoColors {
    // Brand
    val Background = Color(0xFFF3EFE4) // ivory
    val DeepForest = Color(0xFF1F3B30)
    val Terracotta = Color(0xFFC97855)

    // Neutrals
    val Surface = Color(0xFFFFFEFA)
    val SurfaceAlt = Color(0xFFE7E2D6)
    val Sage = Color(0xFFDCE5D7)
    val Text = Color(0xFF202A23)
    val TextMuted = Color(0xFF646E65)
    val Border = Color(0xFFD8D9CE)

    // Semantic / minor
    val Danger = Color(0xFFB55345)
    val Brass = Color(0xFFA98542) // kept from N01, unused; candidate for removal
}
