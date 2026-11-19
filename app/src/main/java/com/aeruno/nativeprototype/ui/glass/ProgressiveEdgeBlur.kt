package com.aeruno.nativeprototype.ui.glass

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aeruno.nativeprototype.ui.theme.AerunoColors
import dev.chrisbanes.haze.HazeProgressive
import dev.chrisbanes.haze.hazeEffect

/**
 * N04. Second (and last) file that imports Haze, next to GlassSurface.kt. Callers use only
 * [TopProgressiveBlur] and the backdrop helpers from GlassSurface.kt.
 */
object TopBlurTuning {
    val MaxBlurRadius = 20.dp          // blur at the very top edge
    val Easing: Easing = LinearEasing  // how fast the blur falls off; try EaseOut for a longer tail
    const val TintTopAlpha = 0.70f     // ivory veil at the top edge
    const val TintMidAlpha = 0.30f     // ivory veil half way down
    const val NoiseFactor = 0f
}

/**
 * Progressive blur for the top edge. Size it with [modifier] (status bar + a control zone).
 * Blur is strongest at the top and falls to zero at the bottom of the box, so there is no
 * edge where it "ends". The ivory tint fades on the same path (never a flat rectangle).
 * It blurs what [glassBackdropSource] marked; it never touches the content above it.
 */
@Composable
fun TopProgressiveBlur(
    backdrop: GlassBackdrop,
    modifier: Modifier = Modifier,
    tint: Color = AerunoColors.Background,
) {
    Box(
        modifier = modifier
            .hazeEffect(state = backdrop.state) {
                blurRadius = TopBlurTuning.MaxBlurRadius
                noiseFactor = TopBlurTuning.NoiseFactor
                progressive = HazeProgressive.verticalGradient(
                    easing = TopBlurTuning.Easing,
                    startIntensity = 1f,
                    endIntensity = 0f,
                )
            }
            .background(
                Brush.verticalGradient(
                    0f to tint.copy(alpha = TopBlurTuning.TintTopAlpha),
                    0.5f to tint.copy(alpha = TopBlurTuning.TintMidAlpha),
                    1f to tint.copy(alpha = 0f),
                ),
            ),
    )
}
