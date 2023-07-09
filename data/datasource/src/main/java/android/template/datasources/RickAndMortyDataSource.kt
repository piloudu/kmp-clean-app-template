package android.template.datasources

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyDataSource {
    fun getRickAndMortyCharacter(): Flow<RickAndMortyApiModel>
    fun getRickAndMortyCharacterFor(characterId: Int): Flow<RickAndMortyCharacterApiModel>
}
