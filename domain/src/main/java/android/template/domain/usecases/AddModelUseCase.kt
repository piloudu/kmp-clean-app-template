package android.template.domain.usecases

import android.template.domain.repositories.ProductsRepository

class AddModelUseCase(
    private val productsRepository: ProductsRepository,
) : suspend (String) -> Unit {
    override suspend fun invoke(model: String) {
        return productsRepository.add(model)
    }
}
