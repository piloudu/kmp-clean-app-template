package android.template.domain.usecases

import android.template.domain.models.ProductModel
import android.template.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val productsRepository: ProductsRepository,
) : () -> Flow<List<ProductModel>> {
    override fun invoke(): Flow<List<ProductModel>> {
        return productsRepository.getProductModels()
    }
}
