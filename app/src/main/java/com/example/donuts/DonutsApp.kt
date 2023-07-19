package com.example.donuts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.donuts.ui.navigation.DonutNavGraph
import com.example.donuts.ui.navigation.Screens
import com.example.donuts.ui.screens.composables.BottomNavBar
import com.example.donuts.ui.theme.DonutsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutsApp() {
//    OnBoardingScreen()
    DonutsTheme() {

        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                val visibility = currentRoute(navController) in listOf(
                    Screens.HomeScreen.route,
                )
                BottomNavBar(navController, visibility) }
        ) {
            DonutNavGraph(navHostController = navController, modifier = Modifier.padding(it))
        }
    }

}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}