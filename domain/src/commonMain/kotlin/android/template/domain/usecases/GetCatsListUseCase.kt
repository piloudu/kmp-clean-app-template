package android.template.domain.usecases

import android.template.domain.models.RickAndMortyModel
import android.template.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class GetCatsListUseCase(
    private val rickAndMortyRepository: RickAndMortyRepository,
) : () -> Flow<List<RickAndMortyModel>> {
    override fun invoke(): Flow<List<RickAndMortyModel>> = rickAndMortyRepository.getCatsList()
}
