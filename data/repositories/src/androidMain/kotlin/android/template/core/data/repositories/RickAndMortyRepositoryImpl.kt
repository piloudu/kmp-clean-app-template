package android.template.core.data.repositories

import android.template.core.data.mappers.toDomainModel
import android.template.datasources.RickAndMortyDataSource
import android.template.domain.models.RickAndMortyModel
import android.template.domain.repositories.RickAndMortyRepository

internal class RickAndMortyRepositoryImpl(
    private val rickAndMortyDataSource: RickAndMortyDataSource,
) : RickAndMortyRepository {
    override suspend fun getCharacter(): RickAndMortyModel {
        return rickAndMortyDataSource.getCharacter().toDomainModel()
    }
}
