package com.example.donuts.ui.screens.on_boarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.donuts.ui.navigation.Screens

fun NavGraphBuilder.boardingRoute(navHostController : NavHostController){
    composable(Screens.OnBoardingScreen.route) { OnBoardingScreen(navHostController) }
}