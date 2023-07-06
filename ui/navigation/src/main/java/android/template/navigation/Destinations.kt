package android.template.navigation

sealed class Destinations(val route: String) {
    object MainScreen : Destinations("main_screen")
    data class CatScreen(val modelName: String) : Destinations("cat/$modelName")
    // TODO: Fill destinations here using objects and data classes
}
