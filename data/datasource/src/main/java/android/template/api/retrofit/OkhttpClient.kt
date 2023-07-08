package android.template.api.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient

fun buildOkHttpClient(
    networkInterceptor: Interceptor? = null,
    localInterceptor: Interceptor? = null,
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        networkInterceptor?.let(::addNetworkInterceptor)
        localInterceptor?.let(::addInterceptor)
    }.build()
}
