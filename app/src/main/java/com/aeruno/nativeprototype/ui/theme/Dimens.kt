package com.aeruno.nativeprototype.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/** Spacing scale (AGENTS.md section 7). Avoid values outside this list. */
object Spacing {
    val s4 = 4.dp
    val s8 = 8.dp
    val s12 = 12.dp
    val s16 = 16.dp
    val s20 = 20.dp
    val s24 = 24.dp
    val s32 = 32.dp
    val s40 = 40.dp
}

/** Corner radii (AGENTS.md section 7). */
object Radii {
    val button = RoundedCornerShape(12.dp)
    val chip = RoundedCornerShape(14.dp)
    val iconButton = RoundedCornerShape(16.dp)
    val card = RoundedCornerShape(22.dp)
    val hero = RoundedCornerShape(28.dp)
    val nav = RoundedCornerShape(28.dp)
    val sheet = RoundedCornerShape(28.dp)
}
