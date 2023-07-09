package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyOriginApiModel(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
)
