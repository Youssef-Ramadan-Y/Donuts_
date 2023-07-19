package com.example.donuts.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.donuts.ui.screens.donuts_details.detailsRoute
import com.example.donuts.ui.screens.home.homeRoute
import com.example.donuts.ui.screens.on_boarding.boardingRoute

@Composable
fun DonutNavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screens.OnBoardingScreen.route
    ) {

        homeRoute(navHostController)

        boardingRoute(navHostController)

        detailsRoute(navHostController)
    }
}