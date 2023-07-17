package com.example.donuts.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.donuts.ui.theme.Type

@Composable
fun LargeButton(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onAddToCartClicked: () -> Unit,
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(67.dp),
        onClick = {onAddToCartClicked()},
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text = text,
            color = textColor,
            style = Type.labelLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }


}