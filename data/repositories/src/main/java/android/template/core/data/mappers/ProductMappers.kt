package android.template.core.data.mappers

import android.template.datasources.apimodels.ProductApiModel
import android.template.domain.models.Price
import android.template.domain.models.ProductModel

fun ProductApiModel.toDomainModel(): ProductModel {
    return ProductModel(
        name = this.name.orEmpty(),
        price = Price(value = this.price),
    )
}

fun List<ProductApiModel>.toDomainModel(): List<ProductModel> {
    return this.map(ProductApiModel::toDomainModel)
}

fun ProductModel.toApiModel(): ProductApiModel {
    return ProductApiModel(
        name = this.name,
        price = this.price.value,
    )
}

fun List<ProductModel>.toApiModel(): List<ProductApiModel> {
    return this.map(ProductModel::toApiModel)
}
