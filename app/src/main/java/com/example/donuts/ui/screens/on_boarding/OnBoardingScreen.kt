package com.example.donuts.ui.screens.on_boarding

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.donuts.R
import com.example.donuts.ui.screens.composables.LargeButton
import com.example.donuts.ui.screens.composables.SpacerVertical
import com.example.donuts.ui.screens.home.navigateToHomeScreen
import com.example.donuts.ui.theme.Secondary
import com.example.donuts.ui.theme.Type

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    OnBoardingContent { navController.navigateToHomeScreen() }
}

@Composable
fun OnBoardingContent(
    navToHomeScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Secondary)
    ) {
        val transition = rememberInfiniteTransition()
        val offsetY by transition.animateFloat(
            initialValue = -20f,
            targetValue = 20f,
            animationSpec = infiniteRepeatable(
                animation = tween(5000),
                repeatMode = RepeatMode.Reverse
            )
        )

        val offsetX by transition.animateFloat(
            initialValue = -20f,
            targetValue = 20f,
            animationSpec = infiniteRepeatable(
                animation = tween(5000),
                repeatMode = RepeatMode.Reverse
            )
        )

        val scale by transition.animateFloat(
            initialValue = 2f,
            targetValue = 1.8f,
            animationSpec = infiniteRepeatable(
                animation = tween(5000),
                repeatMode = RepeatMode.Reverse
            )
        )

        Image(
            modifier = Modifier
                .size(400.dp)
                .padding(top = 64.dp)
                .offset(x = offsetX.dp, y = offsetY.dp)
                .align(Alignment.TopCenter)
                .scale(scale),
            painter = painterResource(id = R.drawable.on_boarding_img),
            contentDescription = "donuts"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Gonuts With Donuts",
                style = Type.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 60.dp),
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
                navToHomeScreen()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeBackground() {
}