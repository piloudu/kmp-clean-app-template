package android.template.navigation

sealed class Destinations(val route: String) {
    object MainScreen : Destinations("main_screen")
    object CatScreen : Destinations("cat")
    object RickAndMorty : Destinations("rick_and_morty")
}
