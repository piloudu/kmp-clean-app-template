package android.template.domain.models

import java.io.Serializable

data class ProductModel(
    val name: String,
    val price: Price
) : Serializable

@JvmInline
value class Price(val value: Double?) : Serializable
