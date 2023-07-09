package android.template.feature.main.ui.rickandmorty

interface RickAndMortyEventHandler {
    fun onEvent(event: Event)

    enum class Event {
        NextCharacter,
    }
}
