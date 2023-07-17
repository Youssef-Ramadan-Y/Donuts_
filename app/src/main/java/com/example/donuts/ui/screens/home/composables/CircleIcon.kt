package com.example.donuts.ui.screens.home.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donuts.R
import com.example.donuts.ui.theme.White

@Preview
@Composable
fun PreviewCircleIcon() {
    CircleIcon()
}


@Composable
fun CircleIcon(
    modifier: Modifier = Modifier,
) {
    Box(contentAlignment = Alignment.Center,modifier = modifier.padding(15.dp)) {
        Circle(tint = White, circleSize = 45f)
        Icon(
            modifier = Modifier
                .align(Alignment.TopStart),
            painter = painterResource(id = R.drawable.baseline_favorite_border_24),
            contentDescription = "Favorite Icon",
            tint = MaterialTheme.colorScheme.primary,
        )
    }

}

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    tint : Color,
    circleSize : Float = 15f
) {
    Canvas(
        modifier = modifier,
        onDraw = {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = tint,
                center = Offset(canvasWidth / 2, canvasHeight / 2),
                radius = circleSize,
            )
        }
    )
}