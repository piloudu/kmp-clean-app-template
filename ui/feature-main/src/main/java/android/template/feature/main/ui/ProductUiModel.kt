package android.template.feature.main.ui

import android.template.domain.models.ProductModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

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

fun List<ProductModel>.toUiModel(): PersistentList<ProductUiModel> {
    return this.map(ProductModel::toUiModel).toPersistentList()
}
