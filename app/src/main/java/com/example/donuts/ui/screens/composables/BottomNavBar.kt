package com.example.donuts.ui.screens.composables


import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.donuts.R
import com.example.donuts.ui.navigation.Screens
import com.example.donuts.ui.theme.Primary

@Composable
fun BottomNavBar(navController: NavHostController, visibility: Boolean) {

    val icons = remember {
        mutableStateOf(
            listOf(
                R.drawable.home,
                R.drawable.heart,
                R.drawable.notification,
                R.drawable.buy,
                R.drawable.group,
            )
        )
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    if (visibility) {
        NavigationBar(
            modifier = Modifier.padding(bottom = 8.dp),
            containerColor = Color.White
        ) {
            icons.value.forEach { icon ->

                AddItem(
                    screen = icon,
                    currentDestination = currentRoute,
                    navController = navController
                )
            }
        }
    }


}

@Composable
private fun RowScope.AddItem(
    screen: Int,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val selected = currentDestination?.hierarchy?.any { it.route == Screens.HomeScreen.route } == true

    NavigationBarItem(
        selected = selected,
        icon = {
            Icon(
                painter = painterResource(id = screen),
                contentDescription = null,
                tint = Primary,
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Transparent,
            unselectedIconColor = Color.Transparent,
            indicatorColor = Color.White
        ),
        onClick = {
            navController.navigate(Screens.HomeScreen.route) {
                navController.graph.startDestinationRoute?.let {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        }


    )
}