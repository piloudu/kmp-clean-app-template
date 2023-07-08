package android.template.api.apimodels.rickandmorty

import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyOriginApiModel(
    val name: String?,
    val url: String?,
)
