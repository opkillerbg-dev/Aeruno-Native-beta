package com.aeruno.nativeprototype.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

private val AerunoColorScheme = lightColorScheme(
    primary = AerunoColors.Forest,
    onPrimary = AerunoColors.Background,
    secondary = AerunoColors.Olive,
    onSecondary = AerunoColors.DeepForest,
    tertiary = AerunoColors.Brass,
    background = AerunoColors.Background,
    onBackground = AerunoColors.Text,
    surface = AerunoColors.Surface,
    onSurface = AerunoColors.Text,
    surfaceVariant = AerunoColors.SurfaceAlt,
    onSurfaceVariant = AerunoColors.TextMuted,
    secondaryContainer = AerunoColors.Sage,
    onSecondaryContainer = AerunoColors.Forest,
    outline = AerunoColors.Border,
    error = AerunoColors.Danger,
)

private val AerunoShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(22.dp),
    large = RoundedCornerShape(28.dp),
)

/**
 * Theme foundation only (N01): colors, shapes, spacing and radii exist.
 * Typography still uses the Material defaults; Manrope and Inter arrive in N02.
 */
@Composable
fun AerunoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AerunoColorScheme,
        shapes = AerunoShapes,
        content = content,
    )
}
