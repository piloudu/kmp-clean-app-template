package android.template.navigation

sealed class Destinations(val route: String) {
    object MainScreen : Destinations("main_screen")
    object CatScreen : Destinations("cat")
    object AssessmentScreen : Destinations("cat")
    // TODO: Fill destinations here using objects and data classes
}
