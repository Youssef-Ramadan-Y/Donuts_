package com.example.donuts.ui.screens.home

import com.example.donuts.ui.navigation.Screens
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeRoute(navHostController : NavHostController){
    composable(Screens.HomeScreen.route) { HomeScreen(navHostController) }
}

fun NavController.navigateToHomeScreen() {
    navigate(Screens.HomeScreen.route)
}