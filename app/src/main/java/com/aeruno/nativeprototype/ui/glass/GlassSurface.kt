package com.aeruno.nativeprototype.ui.glass

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.aeruno.nativeprototype.ui.theme.AerunoColors
import com.aeruno.nativeprototype.ui.theme.Radii
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState

/**
 * N03. The ONLY file that knows about the blur library (Haze 1.7.2). Callers use
 * [rememberGlassBackdrop], [glassBackdropSource] and [GlassSurface]. To replace Haze later,
 * rewrite this file; nothing else changes.
 */
enum class SurfaceVariant { Glass, Translucent, Solid }

/** Handle for "the content behind the glass". Wraps the library's state so callers never see it. */
@Stable
class GlassBackdrop internal constructor(internal val state: HazeState)

@Composable
fun rememberGlassBackdrop(): GlassBackdrop {
    val state = rememberHazeState()
    return remember(state) { GlassBackdrop(state) }
}

/** Mark the content that glass surfaces should blur. Put it on the background, never on the card. */
fun Modifier.glassBackdropSource(backdrop: GlassBackdrop): Modifier = hazeSource(state = backdrop.state)

/** Start values from AGENTS.md section 7 and 8. Tune here. */
object GlassTuning {
    val BlurRadius = 16.dp
    const val NoiseFactor = 0f              // no grain, so the test shows blur only
    val GlassWhite = Color.White.copy(alpha = 0.65f)
    val GlassCream = AerunoColors.Background.copy(alpha = 0.12f)
    val GlassBorder = Color.White.copy(alpha = 0.35f)
    val TranslucentWhite = Color.White.copy(alpha = 0.75f)
    val TranslucentBorder = Color.White.copy(alpha = 0.40f)
    val SolidBorder = AerunoColors.Border
    val ShadowColor = AerunoColors.Text.copy(alpha = 0.18f)
    val ShadowElevation = 6.dp
}

/**
 * One surface, three looks. Same size, shape, border width and shadow in every variant; only the fill
 * differs. Glass = real backdrop blur of what [glassBackdropSource] marked, plus white and cream tint.
 * The blur is applied to the content BEHIND the surface, never to the surface's own children.
 */
@Composable
fun GlassSurface(
    backdrop: GlassBackdrop,
    variant: SurfaceVariant,
    modifier: Modifier = Modifier,
    shape: Shape = Radii.card,
    content: @Composable BoxScope.() -> Unit,
) {
    val base = modifier
        .shadow(
            elevation = GlassTuning.ShadowElevation,
            shape = shape,
            clip = false,
            ambientColor = GlassTuning.ShadowColor,
            spotColor = GlassTuning.ShadowColor,
        )
        .clip(shape)

    val styled = when (variant) {
        SurfaceVariant.Glass -> base
            .hazeEffect(state = backdrop.state) {
                blurRadius = GlassTuning.BlurRadius
                noiseFactor = GlassTuning.NoiseFactor
            }
            .background(GlassTuning.GlassWhite)
            .background(GlassTuning.GlassCream)
            .border(1.dp, GlassTuning.GlassBorder, shape)

        SurfaceVariant.Translucent -> base
            .background(GlassTuning.TranslucentWhite)
            .border(1.dp, GlassTuning.TranslucentBorder, shape)

        SurfaceVariant.Solid -> base
            .background(AerunoColors.Surface)
            .border(1.dp, GlassTuning.SolidBorder, shape)
    }

    Box(modifier = styled, content = content)
}
