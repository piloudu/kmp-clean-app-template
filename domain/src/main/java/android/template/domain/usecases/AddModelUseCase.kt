package android.template.domain.usecases

import android.template.domain.models.ProductModel
import android.template.domain.repositories.ProductsRepository

class AddModelUseCase(
    private val productsRepository: ProductsRepository,
) : suspend (List<ProductModel>) -> Unit {
    override suspend fun invoke(productsList: List<ProductModel>) {
        return productsRepository.setProductModel(productsList)
    }
}
