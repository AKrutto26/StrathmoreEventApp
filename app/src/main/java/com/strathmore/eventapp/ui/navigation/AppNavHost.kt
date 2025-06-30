package com.strathmore.eventapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.strathmore.eventapp.ui.screens.EventDetailScreen
import com.strathmore.eventapp.ui.screens.EventListScreen
import com.strathmore.eventapp.ui.screens.WelcomeScreen
import androidx.navigation.NavHostController

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Welcome
    ) {
        composable(route = NavRoutes.Welcome) {
            WelcomeScreen(onContinueClicked = {
                navController.navigate(NavRoutes.EventList)
            })
        }

        composable(route = NavRoutes.EventList) {
            EventListScreen(navController = navController)
        }

        composable(
            route = "${NavRoutes.EventDetail}/{title}/{description}/{date}/{location}/{imageUrl}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("date") { type = NavType.StringType },
                navArgument("location") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val date = backStackEntry.arguments?.getString("date") ?: ""
            val location = backStackEntry.arguments?.getString("location") ?: ""
            val imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: ""

            EventDetailScreen(
                title = title,
                description = description,
                date = date,
                location = location,
                imageUrl = imageUrl
            )
        }
    }
}
