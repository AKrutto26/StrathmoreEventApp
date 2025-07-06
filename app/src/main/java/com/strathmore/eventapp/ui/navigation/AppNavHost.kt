package com.strathmore.eventapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.strathmore.eventapp.ui.screens.EventDetailScreen
import com.strathmore.eventapp.ui.screens.EventListScreen
import com.strathmore.eventapp.ui.screens.LoginScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login
    ) {
        composable(route = NavRoutes.Login) {
            LoginScreen(navController = navController)
        }

        composable(route = NavRoutes.EventList) {
            EventListScreen(navController = navController)
        }

        composable(
            route = "${NavRoutes.EventDetail}/{title}/{description}/{date}/{location}/{imageUrl}/{formLink}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("date") { type = NavType.StringType },
                navArgument("location") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType },
                navArgument("formLink") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            fun decode(arg: String?): String =
                URLDecoder.decode(arg ?: "", StandardCharsets.UTF_8.name())

            val title = decode(backStackEntry.arguments?.getString("title"))
            val description = decode(backStackEntry.arguments?.getString("description"))
            val date = decode(backStackEntry.arguments?.getString("date"))
            val location = decode(backStackEntry.arguments?.getString("location"))
            val imageUrl = decode(backStackEntry.arguments?.getString("imageUrl"))
            val formLink = decode(backStackEntry.arguments?.getString("formLink"))

            EventDetailScreen(
                title = title,
                description = description,
                date = date,
                location = location,
                imageUrl = imageUrl,
                formLink = formLink
            )
        }
    }
}
