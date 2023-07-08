package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyCharacterApiModel(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("species")
    val species: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("origin")
    val origin: RickAndMortyOriginApiModel?,
    @SerialName("location")
    val location: RickAndMortyLocationApiModel?,
    @SerialName("image")
    val image: String?,
    @SerialName("episode")
    val episode: List<String?>?,
    @SerialName("url")
    val url: String?,
    @SerialName("created")
    val created: String?,
)
