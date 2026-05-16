package com.shootermind.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shootermind.app.R

@Composable
fun TargetMark(
    modifier: Modifier = Modifier,
    ringColor: Color = MaterialTheme.colorScheme.primary,
    centerColor: Color = MaterialTheme.colorScheme.surface
) {
    Box(
        modifier = modifier.size(156.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val radiusStep = size.minDimension / 10f
            val center = Offset(size.width / 2f, size.height / 2f)

            for (index in 1..5) {
                drawCircle(
                    color = ringColor.copy(alpha = 0.28f),
                    radius = radiusStep * index,
                    center = center,
                    style = Stroke(width = 1.4.dp.toPx())
                )
            }
            drawCircle(
                color = ringColor,
                radius = radiusStep * 5,
                center = center,
                alpha = 0.12f
            )
            drawCircle(
                color = centerColor,
                radius = radiusStep * 1.3f,
                center = center
            )
        }
        Text(
            text = stringResource(R.string.home_target_score),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
