package android.template.api.service

import android.template.api.apimodels.rickAndMorty.RickAndMortyCharacterApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlin.random.Random

suspend fun HttpClient.getRickAndMortyCharacter(): RickAndMortyCharacterApiModel {
    val characterId = Random.nextInt()
    return get("character/${characterId}").body()
}