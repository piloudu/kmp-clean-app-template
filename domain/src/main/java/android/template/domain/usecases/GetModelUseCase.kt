package android.template.domain.usecases

import android.template.core.data.MyModelRepository
import kotlinx.coroutines.flow.Flow

class GetModelUseCase(
    private val myModelRepository: MyModelRepository,
) : () -> Flow<List<String>> {
    override fun invoke(): Flow<List<String>> {
        return myModelRepository.myModels
    }
}
