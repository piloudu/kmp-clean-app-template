package android.template.api.service

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("api/character")
    suspend fun getRickAndMortyCharacter(): Flow<RickAndMortyApiModel>
}
