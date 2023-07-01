package android.template.domain.usecases

import android.template.domain.repositories.MyModelRepository
import kotlinx.coroutines.flow.Flow

internal class GetModelUseCase(
    private val myModelRepository: MyModelRepository,
) : () -> Flow<List<String>> {
    override fun invoke(): Flow<List<String>> {
        return myModelRepository.myModels
    }
}
