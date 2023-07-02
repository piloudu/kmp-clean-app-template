package android.template.navigation

sealed class Destinations(val route: String) {
    object MyModelScreen : Destinations("my_model_screen")
    // TODO: Fill destinations here using objects and data classes
}
