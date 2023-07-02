package android.template.apimodels

import kotlinx.serialization.Serializable

@Serializable
data class ProductApiModel(
    val id: Int? = null,
    val name: String?,
    val price: Double?,
)
