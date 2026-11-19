package com.aeruno.nativeprototype.ui.cardtest

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aeruno.nativeprototype.ui.glass.GlassBackdrop
import com.aeruno.nativeprototype.ui.glass.GlassSurface
import com.aeruno.nativeprototype.ui.glass.SurfaceVariant
import com.aeruno.nativeprototype.ui.glass.glassBackdropSource
import com.aeruno.nativeprototype.ui.glass.rememberGlassBackdrop
import com.aeruno.nativeprototype.ui.theme.AerunoColors
import com.aeruno.nativeprototype.ui.theme.AerunoType
import com.aeruno.nativeprototype.ui.theme.Radii
import com.aeruno.nativeprototype.ui.theme.Spacing

/**
 * N03 card test. One static background, one sample card, a selector for A / B / C.
 * Mock text only. Nothing animates. Not the Today screen (that is N04).
 */
@Composable
fun CardTestScreen() {
    val backdrop = rememberGlassBackdrop()
    var variant by remember { mutableStateOf(SurfaceVariant.Glass) }

    Box(modifier = Modifier.fillMaxSize()) {
        TestBackground(backdrop)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(horizontal = Spacing.s20, vertical = Spacing.s24),
        ) {
            Text("CARD TEST", style = AerunoType.screenTitle, color = AerunoColors.DeepForest)
            Text(
                "Switch A, B, C. Only the card surface changes.",
                style = AerunoType.body,
                color = AerunoColors.DeepForest,
            )
            Spacer(Modifier.weight(1f))
            GlassSurface(
                backdrop = backdrop,
                variant = variant,
                modifier = Modifier.fillMaxWidth(),
                shape = Radii.hero,
            ) { SampleCardContent() }
            Spacer(Modifier.weight(1f))
            VariantSelector(selected = variant, onSelect = { variant = it })
        }
    }
}

/** Static background. Everything inside the source Box is what the glass blurs. No animation. */
@Composable
private fun TestBackground(backdrop: GlassBackdrop) {
    Box(modifier = Modifier.fillMaxSize().glassBackdropSource(backdrop)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val dp = density

            // Cream (top) to deep forest (bottom).
            drawRect(
                brush = Brush.verticalGradient(
                    0f to AerunoColors.Background,
                    0.25f to AerunoColors.Background,
                    1f to AerunoColors.DeepForest,
                    startY = 0f,
                    endY = h,
                ),
            )
            // Soft shapes.
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(AerunoColors.Sage, Color.Transparent),
                    center = Offset(w * 0.15f, h * 0.38f),
                    radius = 190 * dp,
                ),
                radius = 190 * dp,
                center = Offset(w * 0.15f, h * 0.38f),
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(AerunoColors.Terracotta.copy(alpha = 0.55f), Color.Transparent),
                    center = Offset(w * 0.85f, h * 0.62f),
                    radius = 200 * dp,
                ),
                radius = 200 * dp,
                center = Offset(w * 0.85f, h * 0.62f),
            )
            // Hard-edged shapes straddling the card area: blurred edges are the clearest test.
            drawCircle(
                color = AerunoColors.Terracotta,
                radius = 70 * dp,
                center = Offset(w * 0.78f, h * 0.44f),
            )
            drawCircle(
                color = AerunoColors.Background,
                radius = 54 * dp,
                center = Offset(w * 0.22f, h * 0.55f),
                style = Stroke(width = 10 * dp),
            )
            drawRect(
                color = AerunoColors.DeepForest,
                topLeft = Offset(w * 0.40f, h * 0.40f),
                size = Size(14 * dp, 140 * dp),
            )
            drawRect(
                color = AerunoColors.Sage,
                topLeft = Offset(w * 0.08f, h * 0.50f),
                size = Size(w * 0.5f, 10 * dp),
            )
        }
        // Sharp text behind the card: it blurs under glass, shows through in B, is hidden in C.
        Text(
            "AERUNO",
            style = AerunoType.heroStat,
            color = AerunoColors.Terracotta,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center).offset(y = (-120).dp),
        )
    }
}

/** Identical in every variant: same text, layout, spacing, button. */
@Composable
private fun SampleCardContent() {
    Column(
        modifier = Modifier.padding(Spacing.s24),
        verticalArrangement = Arrangement.spacedBy(Spacing.s8),
    ) {
        Text("TODAY", style = AerunoType.label, color = AerunoColors.TextMuted)
        Text("LOWER BODY", style = AerunoType.displayMedium, color = AerunoColors.DeepForest)
        Text("35 min · 6 exercises", style = AerunoType.body, color = AerunoColors.Text)
        Spacer(Modifier.height(Spacing.s8))
        Button(
            onClick = { /* mock: nothing happens */ },
            shape = Radii.button,
            colors = ButtonDefaults.buttonColors(
                containerColor = AerunoColors.DeepForest,
                contentColor = AerunoColors.Background,
            ),
            modifier = Modifier.fillMaxWidth(),
        ) { Text("Start Workout", style = AerunoType.button) }
    }
}

@Composable
private fun VariantSelector(selected: SurfaceVariant, onSelect: (SurfaceVariant) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Radii.card)
            .background(AerunoColors.Surface)
            .padding(Spacing.s12),
        verticalArrangement = Arrangement.spacedBy(Spacing.s8),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.s8),
        ) {
            Segment("A  GLASS", selected == SurfaceVariant.Glass) { onSelect(SurfaceVariant.Glass) }
            Segment("B  CLEAR", selected == SurfaceVariant.Translucent) { onSelect(SurfaceVariant.Translucent) }
            Segment("C  SOLID", selected == SurfaceVariant.Solid) { onSelect(SurfaceVariant.Solid) }
        }
        Text(
            text = when (selected) {
                SurfaceVariant.Glass -> "A: real backdrop blur (16 dp) + 65% white + cream tint."
                SurfaceVariant.Translucent -> "B: 75% white, no blur."
                SurfaceVariant.Solid -> "C: solid #FFFEFA, no blur."
            },
            style = AerunoType.caption,
            color = AerunoColors.TextMuted,
        )
    }
}

@Composable
private fun RowScope.Segment(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(Radii.chip)
            .background(if (selected) AerunoColors.DeepForest else AerunoColors.SurfaceAlt)
            .selectable(selected = selected, onClick = onClick, role = Role.RadioButton)
            .padding(vertical = Spacing.s12),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            label,
            style = AerunoType.label,
            color = if (selected) AerunoColors.Background else AerunoColors.Text,
        )
    }
}
