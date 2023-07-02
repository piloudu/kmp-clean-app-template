package android.template.ui

import android.template.feature.main.ui.MainScreen
import android.template.navigation.Destinations
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.MainScreen.route) {
        composable(Destinations.MainScreen.route) { MainScreen(modifier = Modifier.padding(16.dp)) }
        // TODO: Add more destinations
    }
}
