package com.example.donuts.ui.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.donuts.ui.theme.PrimaryVariant

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    roundedSize: Int = 8,
    tintColor : Color = PrimaryVariant,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(roundedSize.dp))
            .background(tintColor)
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        content()
    }
}