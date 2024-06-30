package android.template.datasources

import android.template.api.apimodels.rickAndMorty.RickAndMortyCharacterApiModel
import kotlinx.coroutines.flow.Flow

interface RickAndMortyDataSource {
    suspend fun getCharacter(): RickAndMortyCharacterApiModel
}