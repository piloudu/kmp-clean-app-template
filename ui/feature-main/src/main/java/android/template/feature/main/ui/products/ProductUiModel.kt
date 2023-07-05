package android.template.feature.main.ui.products

import android.os.Parcelable
import android.template.domain.models.Price
import android.template.domain.models.ProductModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductUiModel(
    val name: String,
    val price: Double?,
) : Parcelable

fun ProductModel.toUiModel(): ProductUiModel {
    return ProductUiModel(
        name = this.name,
        price = this.price.value,
    )
}

fun ProductUiModel.toDomainModel(): ProductModel {
    return ProductModel(
        name = this.name,
        price = Price(this.price),
    )
}
