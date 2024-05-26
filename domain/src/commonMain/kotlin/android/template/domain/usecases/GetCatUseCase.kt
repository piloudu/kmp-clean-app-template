package android.template.domain.usecases

import android.template.domain.models.CatModel
import android.template.domain.repositories.CatRepository
import kotlinx.coroutines.flow.Flow

class GetCatUseCase(
    private val catRepository: CatRepository,
) : () -> Flow<CatModel> {
    override fun invoke(): Flow<CatModel> = catRepository.getCat()
}
