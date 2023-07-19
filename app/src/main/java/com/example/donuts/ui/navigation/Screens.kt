package com.example.donuts.ui.navigation

sealed class Screens(val route: String) {
    object OnBoardingScreen : Screens("onBoarding")
    object HomeScreen : Screens("home")
    object DetailsScreen : Screens("details")
}