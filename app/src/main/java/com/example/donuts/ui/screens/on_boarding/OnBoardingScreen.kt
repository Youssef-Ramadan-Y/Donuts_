package com.example.donuts.ui.screens.on_boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.donuts.R
import com.example.donuts.ui.composables.LargeButton
import com.example.donuts.ui.composables.SpacerVertical
import com.example.donuts.ui.theme.Type

@Composable
fun OnBoardingScreen() {
    OnBoardingContent()
}

@Composable
fun OnBoardingContent() {
    Box(
        Modifier.background(MaterialTheme.colorScheme.tertiary)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(400.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.on_boarding_img),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(vertical = 32.dp, horizontal = 56.dp),

            ) {
            Text(
                text = "Gonuts With Donuts",
                style = Type.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            SpacerVertical(height = 19)
            Text(
                text = "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                style = Type.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            SpacerVertical(height = 60)
            LargeButton(
                text = "Get Started",
                textColor = MaterialTheme.colorScheme.onPrimary,
                backgroundColor = MaterialTheme.colorScheme.background,
            ) {


            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeBackground() {
    OnBoardingScreen()
}