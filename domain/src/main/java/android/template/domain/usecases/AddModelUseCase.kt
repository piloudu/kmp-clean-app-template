package android.template.domain.usecases

import android.template.domain.repositories.MyModelRepository

internal class AddModelUseCase(
    private val myModelRepository: MyModelRepository,
) : suspend (String) -> Unit {
    override suspend fun invoke(model: String) {
        return myModelRepository.add(model)
    }
}
