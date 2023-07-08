package android.template.core.data.repositories

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.core.data.mappers.toDomainModel
import android.template.datasources.RickAndMortyDataSource
import android.template.domain.models.RickAndMortyModel
import android.template.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class RickAndMortyRepositoryImpl(
    private val rickAndMortyDataSource: RickAndMortyDataSource,
) : RickAndMortyRepository {
    override fun getRickAndMortyData(): Flow<RickAndMortyModel> {
        return rickAndMortyDataSource.getRickAndMortyCharacter()
            .map(RickAndMortyApiModel::toDomainModel)
    }
}
