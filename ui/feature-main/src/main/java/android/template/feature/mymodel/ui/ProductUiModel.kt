package android.template.feature.mymodel.ui

import android.template.domain.models.ProductModel

data class ProductUiModel(
    val name: String,
    val price: Double?,
)

fun ProductModel.toUiModel(): ProductUiModel {
    return ProductUiModel(
        name = this.name,
        price = this.price.value,
    )
}
