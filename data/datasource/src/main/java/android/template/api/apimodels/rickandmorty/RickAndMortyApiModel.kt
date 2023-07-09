package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

const val RICK_AND_MORTY_BASE_URL: String = "https://rickandmortyapi.com/"

@Serializable
data class RickAndMortyApiModel(
    @SerialName("info")
    val info: RickAndMortyInfoApiModel?,
    @SerialName("results")
    val results: List<RickAndMortyCharacterApiModel>?,
)
