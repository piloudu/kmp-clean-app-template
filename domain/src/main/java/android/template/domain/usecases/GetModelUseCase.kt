package android.template.domain.usecases

import android.template.domain.models.ProductModel
import android.template.domain.repositories.MyModelRepository
import kotlinx.coroutines.flow.Flow

class GetModelUseCase(
    private val myModelRepository: MyModelRepository,
) : () -> Flow<ProductModel> {
    override fun invoke(): Flow<ProductModel> {
        return myModelRepository.getMyModels()
    }
}
