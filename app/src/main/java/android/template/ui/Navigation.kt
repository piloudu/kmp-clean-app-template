package android.template.ui

import android.template.feature.main.ui.cat.screen.CatScreen
import android.template.feature.main.ui.products.MainScreen
import android.template.navigation.Destinations
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.MainScreen.route) {
        composable(Destinations.MainScreen.route) {
            MainScreen(
                onClickNext = { navController.navigate(Destinations.CatScreen.route) },
            )
        }
        composable(Destinations.CatScreen.route) {
            CatScreen()
        }
        // TODO: Add more destinations
    }
}
