package com.aeruno.nativeprototype.ui.topblur

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Surface
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.aeruno.nativeprototype.ui.glass.TopProgressiveBlur
import com.aeruno.nativeprototype.ui.glass.glassBackdropSource
import com.aeruno.nativeprototype.ui.glass.rememberGlassBackdrop
import com.aeruno.nativeprototype.ui.theme.AerunoColors
import com.aeruno.nativeprototype.ui.theme.AerunoType
import com.aeruno.nativeprototype.ui.theme.Radii
import com.aeruno.nativeprototype.ui.theme.Spacing

/**
 * N04 top progressive blur test. Mock content scrolls under a top-edge blur; the selector switches
 * A (progressive blur) and B (no blur). Test screen only: no real controls, no navigation.
 */
@Composable
fun TopBlurTestScreen() {
    val backdrop = rememberGlassBackdrop()
    var progressive by remember { mutableStateOf(true) }
    val statusBar = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val navBar = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    Box(modifier = Modifier.fillMaxSize()) {
        // Everything inside this list (including its ivory background) is what the blur samples.
        LazyColumn(
            modifier = Modifier.fillMaxSize().glassBackdropSource(backdrop).background(AerunoColors.Background),
            contentPadding = PaddingValues(
                start = Spacing.s20, end = Spacing.s20,
                top = statusBar + Spacing.s16, bottom = navBar + 112.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(Spacing.s20),
        ) {
            testContent()
            testContent()
        }

        if (progressive) {
            // Status bar + a 72 dp zone where floating controls could sit later (none built here).
            TopProgressiveBlur(
                backdrop = backdrop,
                modifier = Modifier.align(Alignment.TopCenter).fillMaxWidth().height(statusBar + 72.dp),
            )
        }

        Selector(
            progressive = progressive,
            onChange = { progressive = it },
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = navBar + Spacing.s16),
        )
    }
}

private fun LazyListScope.testContent() {
    item {
        Column {
            Text("Good morning", style = AerunoType.accentLarge, color = AerunoColors.Terracotta)
            Text("LOWER BODY", style = AerunoType.displayLarge, color = AerunoColors.DeepForest)
        }
    }
    item { ImageBlock(Modifier.fillMaxWidth().height(200.dp)) }
    item {
        Text(
            "Scroll slowly. Text, cards and images pass under the top edge. The blur should be strongest " +
                "at the very top and fade away with no visible line where it ends.",
            style = AerunoType.bodyLarge,
            color = AerunoColors.Text,
        )
    }
    item {
        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.s12)) {
            StatCard("8,420", "STEPS", Modifier.weight(1f))
            StatCard("42", "MIN", Modifier.weight(1f))
            StatCard("4", "DAYS", Modifier.weight(1f))
        }
    }
    item {
        Column(
            modifier = Modifier.fillMaxWidth().clip(Radii.hero).background(AerunoColors.DeepForest).padding(Spacing.s24),
            verticalArrangement = Arrangement.spacedBy(Spacing.s8),
        ) {
            Text("NEXT UP", style = AerunoType.label, color = AerunoColors.Sage)
            Text("35 MIN", style = AerunoType.heroStat, color = AerunoColors.Background)
            Text("6 exercises · lower body", style = AerunoType.body, color = AerunoColors.Sage)
        }
    }
    item {
        Row(horizontalArrangement = Arrangement.spacedBy(Spacing.s12)) {
            repeat(3) { ImageBlock(Modifier.weight(1f).aspectRatio(1f), seed = it + 1) }
        }
    }
    items(5) { i ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(Radii.card)
                .background(AerunoColors.Surface)
                .border(BorderStroke(1.dp, AerunoColors.Border), Radii.card)
                .padding(Spacing.s16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("Exercise ${i + 1}", style = AerunoType.cardTitle, color = AerunoColors.Text)
                Text("3 sets · 10 reps", style = AerunoType.body, color = AerunoColors.TextMuted)
            }
            Text("${40 + i * 5} KG", style = AerunoType.statNumber, color = AerunoColors.DeepForest)
        }
    }
}

@Composable
private fun StatCard(value: String, label: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(Radii.card)
            .background(AerunoColors.Surface)
            .border(BorderStroke(1.dp, AerunoColors.Border), Radii.card)
            .padding(Spacing.s16),
    ) {
        Text(value, style = AerunoType.statNumber, color = AerunoColors.Text)
        Text(label, style = AerunoType.label, color = AerunoColors.TextMuted)
    }
}

/** Image-like block drawn in code (no image files): gradient plus circles and a stripe. */
@Composable
private fun ImageBlock(modifier: Modifier, seed: Int = 0) {
    Canvas(modifier = modifier.clip(Radii.card)) {
        val c = if (seed % 2 == 0) AerunoColors.DeepForest else AerunoColors.Terracotta
        drawRect(Brush.linearGradient(listOf(c, AerunoColors.Sage), Offset.Zero, Offset(size.width, size.height)))
        drawCircle(AerunoColors.Background, size.minDimension * 0.28f, Offset(size.width * 0.72f, size.height * 0.35f))
        drawCircle(AerunoColors.Terracotta.copy(alpha = 0.9f), size.minDimension * 0.16f, Offset(size.width * 0.3f, size.height * 0.7f))
        drawRect(Color.White.copy(alpha = 0.5f), Offset(0f, size.height * 0.52f), Size(size.width, size.height * 0.04f))
    }
}

@Composable
private fun Selector(progressive: Boolean, onChange: (Boolean) -> Unit, modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = Radii.nav,
        color = AerunoColors.Surface,
        shadowElevation = 6.dp,
        border = BorderStroke(1.dp, AerunoColors.Border),
    ) {
        Row(
            modifier = Modifier.padding(Spacing.s8).selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.s8),
        ) {
            Segment("A  PROGRESSIVE", progressive) { onChange(true) }
            Segment("B  NO BLUR", !progressive) { onChange(false) }
        }
    }
}

@Composable
private fun Segment(label: String, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(Radii.chip)
            .background(if (selected) AerunoColors.DeepForest else AerunoColors.SurfaceAlt)
            .selectable(selected = selected, onClick = onClick, role = Role.RadioButton)
            .padding(horizontal = Spacing.s16, vertical = Spacing.s12),
        contentAlignment = Alignment.Center,
    ) {
        Text(label, style = AerunoType.label, color = if (selected) AerunoColors.Background else AerunoColors.Text)
    }
}
