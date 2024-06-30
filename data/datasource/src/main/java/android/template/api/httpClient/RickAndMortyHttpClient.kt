package android.template.api.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel.ALL
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.Interceptor

const val BASE_RICK_AND_MORTY_URL = "https://rickandmortyapi.com"

internal fun createKtorHttpClient() = HttpClient(OkHttp) {
    engine {
        addInterceptor(createLocalInterceptor())
    }
    defaultRequest {
        url(BASE_RICK_AND_MORTY_URL)
    }
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
    install(Logging) { level = ALL }
}

internal fun createLocalInterceptor() = Interceptor { interceptorChain ->
    val httpUrl = interceptorChain.request().url.newBuilder().apply {
        addPathSegment("api")
    }.build()
    val newRequest = interceptorChain.request().newBuilder().url(httpUrl).build()
    interceptorChain.proceed(newRequest)
}
