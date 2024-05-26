package android.template.domain.models

import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(
    val name: String,
    val price: Price
)

@Serializable
@JvmInline
value class Price(val value: Double?)
