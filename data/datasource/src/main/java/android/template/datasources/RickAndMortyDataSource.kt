package android.template.datasources

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyDataSource {
    fun getRickAndMortyCharacter(): Flow<RickAndMortyApiModel>
}
