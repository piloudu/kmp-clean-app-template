package android.template.domain.usecases

import android.template.core.data.MyModelRepository

class AddModelUseCase(
    private val myModelRepository: MyModelRepository,
) : suspend (String) -> Unit {
    override suspend fun invoke(model: String) {
        return myModelRepository.add(model)
    }
}
