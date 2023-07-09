package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyLocationApiModel(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
)
