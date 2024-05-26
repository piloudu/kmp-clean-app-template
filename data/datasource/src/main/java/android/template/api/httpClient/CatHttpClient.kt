package android.template.api.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel.ALL
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import okhttp3.Interceptor

const val BASE_CAT_URL = "https://cataas.com/"

internal fun createKtorHttpClient() = HttpClient(OkHttp) {
    engine {
        addInterceptor(getCatLocalInterceptor())
    }
    defaultRequest {
        url(BASE_CAT_URL)
    }
    install(ContentNegotiation) { json() }
    install(Logging) { level = ALL }
}

internal fun getCatLocalInterceptor() = Interceptor { interceptorChain ->
    val httpUrl = interceptorChain.request().url.newBuilder().apply {
        addQueryParameter("json", "true")
    }.build()
    val newRequest = interceptorChain.request().newBuilder().url(httpUrl).build()
    interceptorChain.proceed(newRequest)
}
