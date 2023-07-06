package android.template.navigation

import android.net.Uri
import android.template.feature.main.ui.cat.CatUiModel
import android.template.feature.main.ui.cat.screen.CatScreen
import android.template.feature.main.ui.products.MainScreen
import android.template.navigation.utils.parcelableData
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.MainScreen.route) {
        val catScreenDestination = Destinations.CatScreen("testModel")
        composable(Destinations.MainScreen.route) {
            MainScreen(
                onClickNext = {
                    val jsonSerializer = Json { ignoreUnknownKeys = true }
                    val testModel = CatUiModel(owner = "", mimeType = "", url = "")
                    val json = Uri.encode(jsonSerializer.encodeToString(testModel))
                    navController.navigate(Destinations.CatScreen(json).route)
                },
            )
        }
        composable(
            route = catScreenDestination.route,
            arguments = listOf(
                navArgument(catScreenDestination.modelName) {
                    type = NavTypeImpl(isNullableAllowed = false)
                },
            ),
        ) { navBackStackEntry ->
            val testModel =
                navBackStackEntry.parcelableData<CatUiModel>(catScreenDestination.modelName)
            CatScreen(testModel = testModel)
        }
        // TODO: Add more destinations
    }
}
