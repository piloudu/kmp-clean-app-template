package android.template.domain.usecases

import android.template.domain.models.ProductModel
import android.template.domain.repositories.MyModelRepository
import kotlinx.coroutines.flow.Flow

internal class GetModelUseCase(
    private val myModelRepository: MyModelRepository,
) : suspend () -> Flow<ProductModel> {
    override suspend fun invoke(): Flow<ProductModel> {
        return myModelRepository.getMyModels()
    }
}
