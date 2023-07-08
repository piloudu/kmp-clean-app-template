package android.template.domain.usecases

import android.template.domain.models.RickAndMortyModel
import android.template.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class GetRickAndMortyDataUseCase(
    private val rickAndMortyRepository: RickAndMortyRepository,
) : () -> Flow<RickAndMortyModel> {
    override fun invoke(): Flow<RickAndMortyModel> {
        return rickAndMortyRepository.getRickAndMortyData()
    }
}
