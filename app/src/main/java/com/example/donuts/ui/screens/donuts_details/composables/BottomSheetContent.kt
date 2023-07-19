package com.example.donuts.ui.screens.donuts_details.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donuts.ui.screens.composables.NormalButton
import com.example.donuts.ui.screens.composables.RoundedButton
import com.example.donuts.ui.screens.donuts_details.DetailsUiState
import com.example.donuts.ui.theme.Primary
import com.example.donuts.ui.theme.Type



@Composable
fun BottomSheetContent(
    state: DetailsUiState,
    modifier: Modifier = Modifier,
    onDecreaseQuantity: () -> Unit,
    onIncreaseQuantity: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, start = 32.dp, end = 32.dp, bottom = 16.dp)
    ) {
        Text(text = state.title, style = Type.headlineSmall.copy(color = MaterialTheme.colorScheme.primary))
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = "About Donut",
            style = Type.bodyLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = state.description,
            style = Type.bodyMedium.copy(color = MaterialTheme.colorScheme.onSecondary)
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Quantity",
            style = Type.bodyLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
        )
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RoundedButton(
                modifier = Modifier.graphicsLayer(
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    ),
                    shadowElevation = 10f,
                    spotShadowColor = Color.Gray,
                ),
                tintColor = Color.White,
                roundedSize = 12,
                onClick = onDecreaseQuantity
            ) {

                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "-",
                    style = Type.displayLarge,
                    color = Color.Black,
                )
            }

            RoundedButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                roundedSize = 12,
                tintColor = Color.Transparent,
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = state.quantity.toString(),
                    style = Type.displayLarge.copy(color = Color.Black)
                )

            }
            RoundedButton(
                roundedSize = 12,
                tintColor = Color.Black,
                onClick = onIncreaseQuantity
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "+",
                    style = Type.displayLarge,
                    color = Color.White
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "€${state.price}",
                style = Type.displayLarge,
                color = Color.Black,
            )
            NormalButton(modifier = Modifier.padding(start = 16.dp), buttonColor = Primary, textColor = Color.White, text = "Add to Cart") {}
        }

    }

}

@Preview
@Composable
fun Show() {

}
