package android.template.api.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NetworkClientImpl(
    baseUrl: String,
    networkInterceptor: Interceptor? = null,
    localInterceptor: Interceptor? = null,
) : NetworkClient {
    override val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            buildOkHttpClient(
                networkInterceptor = networkInterceptor,
                localInterceptor = localInterceptor,
            ),
        )
        .addConverterFactory(jsonConverterFactory)
        .build()
}

private fun buildOkHttpClient(
    networkInterceptor: Interceptor? = null,
    localInterceptor: Interceptor? = null,
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        networkInterceptor?.let(::addNetworkInterceptor)
        localInterceptor?.let(::addInterceptor)
    }.build()
}
