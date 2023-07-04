package android.template.feature.main.ui.products

import android.template.domain.models.Price
import android.template.domain.models.ProductModel

internal val productsList = listOf(
    ProductModel(
        name = "Product 1",
        price = Price(112.45),
    ),
    ProductModel(
        name = "Product 2",
        price = Price(2934.11),
    ),
)

internal val productsException = Exception()
