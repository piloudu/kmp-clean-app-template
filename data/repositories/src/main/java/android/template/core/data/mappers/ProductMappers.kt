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

fun ProductModel.toApiModel(): ProductApiModel {
    return ProductApiModel(
        name = this.name,
        price = this.price.value,
    )
}
