package android.template.domain.models

data class ProductModel(
    val name: String,
    val price: Price
)

@JvmInline
value class Price(val value: Double?)
