package android.template.api.service

import android.template.api.apimodels.CatApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

suspend fun HttpClient.getCat(): CatApiModel {
    return get("cat").body()
}