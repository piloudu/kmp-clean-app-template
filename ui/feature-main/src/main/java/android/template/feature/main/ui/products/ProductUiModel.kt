package android.template.feature.main.ui.products

import android.template.domain.models.Price
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

fun ProductUiModel.toDomainModel(): ProductModel {
    return ProductModel(
        name = this.name,
        price = Price(this.price),
    )
}

fun List<ProductUiModel>.toDomainModel(): List<ProductModel> {
    return this.map(ProductUiModel::toDomainModel)
}
