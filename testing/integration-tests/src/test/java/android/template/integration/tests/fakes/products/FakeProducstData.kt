package android.template.integration.tests.fakes.products

import android.template.api.apimodels.ProductApiModel

internal val productsList = listOf(
    ProductApiModel(
        name = "Product 1",
        price = 112.45,
    ),
    ProductApiModel(
        name = "Product 2",
        price = 2934.11,
    ),
)

internal val productsException = Exception()
