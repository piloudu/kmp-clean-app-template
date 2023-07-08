package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyApiModel(
    @SerialName("info")
    val info: RickAndMortyInfoApiModel?,
    @SerialName("results")
    val results: List<RickAndMortyCharacterApiModel?>?,
)
