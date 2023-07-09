package android.template.api.service

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import retrofit2.http.GET
import retrofit2.http.Path

private const val CHARACTER_ID = "CHARACTER_PATH"

interface RickAndMortyService {
    @GET("api/character")
    suspend fun getRickAndMortyCharacter(): RickAndMortyApiModel

    @GET("api/character/{$CHARACTER_ID}")
    suspend fun getRickAndMortyCharacterFor(
        @Path(CHARACTER_ID) characterId: Int,
    ): RickAndMortyCharacterApiModel
}
