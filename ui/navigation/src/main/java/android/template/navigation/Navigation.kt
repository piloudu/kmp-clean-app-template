package android.template.navigation

import android.template.feature.main.ui.cat.screen.CatScreen
import android.template.feature.main.ui.products.MainScreen
import android.template.feature.main.ui.rickandmorty.RickAndMortyScreen
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
                onClickGoToCatScreen = { navController.navigate(Destinations.CatScreen.route) },
                onClickGoToRickAndMortyScreen = { navController.navigate(Destinations.RickAndMorty.route) },
            )
        }
        composable(Destinations.CatScreen.route) {
            CatScreen()
        }
        composable(Destinations.RickAndMorty.route) {
            RickAndMortyScreen()
        }
    }
}
