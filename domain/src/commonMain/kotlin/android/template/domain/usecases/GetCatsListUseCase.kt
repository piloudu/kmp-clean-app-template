package android.template.domain.usecases

import android.template.domain.models.CatModel
import android.template.domain.repositories.CatRepository
import kotlinx.coroutines.flow.Flow

class GetCatsListUseCase(
    private val catRepository: CatRepository,
) : () -> Flow<List<CatModel>> {
    override fun invoke(): Flow<List<CatModel>> = catRepository.getCatsList()
}
