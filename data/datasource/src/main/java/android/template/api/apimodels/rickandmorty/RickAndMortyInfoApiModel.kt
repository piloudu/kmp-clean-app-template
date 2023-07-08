package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyInfoApiModel(
    @SerialName("count")
    val count: Int?,
    @SerialName("pages")
    val pages: Int?,
    @SerialName("next")
    val next: String?,
    @SerialName("prev")
    val prev: String?,
)
