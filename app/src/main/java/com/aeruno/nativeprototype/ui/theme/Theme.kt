package com.aeruno.nativeprototype.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

private val AerunoColorScheme = lightColorScheme(
    primary = AerunoColors.DeepForest,
    onPrimary = AerunoColors.Background,
    secondary = AerunoColors.Terracotta,
    onSecondary = AerunoColors.Text,
    tertiary = AerunoColors.Brass,
    background = AerunoColors.Background,
    onBackground = AerunoColors.Text,
    surface = AerunoColors.Surface,
    onSurface = AerunoColors.Text,
    surfaceVariant = AerunoColors.SurfaceAlt,
    onSurfaceVariant = AerunoColors.TextMuted,
    secondaryContainer = AerunoColors.Sage,
    onSecondaryContainer = AerunoColors.DeepForest,
    outline = AerunoColors.Border,
    error = AerunoColors.Danger,
)

private val AerunoShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(22.dp),
    large = RoundedCornerShape(28.dp),
)

/**
 * AERUNO theme: colors, shapes, spacing, radii (N01) and typography (N02:
 * Big Shoulders Display, Instrument Serif Italic, Inter; see Type.kt).
 */
@Composable
fun AerunoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AerunoColorScheme,
        shapes = AerunoShapes,
        typography = AerunoTypography,
        content = content,
    )
}
