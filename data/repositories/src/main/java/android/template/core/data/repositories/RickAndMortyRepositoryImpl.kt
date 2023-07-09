package android.template.core.data.repositories

import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import android.template.core.data.cache.RickAndMortyCache
import android.template.core.data.mappers.toDomainModel
import android.template.datasources.RickAndMortyDataSource
import android.template.domain.models.RickAndMortyModel
import android.template.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

internal class RickAndMortyRepositoryImpl(
    private val rickAndMortyDataSource: RickAndMortyDataSource,
) : RickAndMortyRepository {
    override fun getRickAndMortyData(): Flow<RickAndMortyModel> {
        return RickAndMortyCache.characterCount
            ?.let(::getRandomCharacterInRange)
            ?: rickAndMortyDataSource.getRickAndMortyCharacter()
                .map { rickAndMortyApiModel ->
                    RickAndMortyCache.characterCount = rickAndMortyApiModel.info?.count
                    rickAndMortyApiModel.toDomainModel()
                }
    }

    private fun getRandomCharacterInRange(characterCount: Int) =
        rickAndMortyDataSource.getRickAndMortyCharacterFor(
            characterId = Random.nextInt(until = characterCount),
        ).map(RickAndMortyCharacterApiModel::toDomainModel)
}
