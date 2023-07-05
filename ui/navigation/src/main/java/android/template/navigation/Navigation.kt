package android.template.navigation

import android.template.feature.main.ui.cat.screen.AssessmentScreen
import android.template.feature.main.ui.cat.screen.CatScreen
import android.template.feature.main.ui.products.MainScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.AssessmentScreen.route) {
        composable(Destinations.MainScreen.route) {
            MainScreen(
                onClickNext = { navController.navigate(Destinations.CatScreen.route) },
            )
        }
        composable(Destinations.CatScreen.route) {
            CatScreen()
        }
        composable(Destinations.AssessmentScreen.route) {
            AssessmentScreen(url = "https://goo.gl/gEgYUd")
        }
        // TODO: Add more destinations
    }
}
