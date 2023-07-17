package com.example.donuts.ui.screens.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.donuts.ui.theme.Type

@Composable
fun HeaderText(modifier: Modifier = Modifier,
               title: String,
               subTitle: String,
) {
    Column(
        modifier = modifier,

    ) {
        Text(
            text = title,
            style = Type.headlineMedium,
            color = MaterialTheme.colorScheme.primary,

        )
        Text(
            text = subTitle,
            style = Type.bodyMedium,
            color = Color.LightGray,
        )
    }

}


@Preview
@Composable
fun PreviewHeaderText() {
    HeaderText(
        title = "Let's Gonuts!",
        subTitle = "Order your favourite donuts from here",
    )
}