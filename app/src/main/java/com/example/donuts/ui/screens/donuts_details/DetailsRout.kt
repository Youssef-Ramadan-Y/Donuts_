package com.example.donuts.ui.screens.donuts_details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.donuts.ui.navigation.Screens


private val ROUTE = Screens.DetailsScreen.route

fun NavController.navigateToDetailsScreen(id : Int) {
    navigate("$ROUTE/$id")
}

fun NavGraphBuilder.detailsRoute(navHostController: NavHostController) {
    composable(
        "$ROUTE/{${DetailsArgs.ARG_ID}}",
        arguments = listOf(
            navArgument(DetailsArgs.ARG_ID) { NavType.IntType }
        )
    ) { DetailsScreen(navController = navHostController) }
}

class DetailsArgs(savedStateHandle: SavedStateHandle) {
    val id = checkNotNull(savedStateHandle[ARG_ID])

    companion object {
        const val ARG_ID = "id"
    }
}