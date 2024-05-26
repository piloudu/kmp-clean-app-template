package android.template.core.data.mappers

import android.template.api.apimodels.ProductApiModel
import android.template.core.database.ProductDatabaseModel
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

fun ProductDatabaseModel.toDomainModel() = ProductModel(
    name = this.name,
    price = Price(value = this.price),
)

fun ProductModel.toDatabaseModel() = ProductDatabaseModel(
    name = this.name,
    price = this.price.value,
)

