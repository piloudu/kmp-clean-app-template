package android.template.api.retrofit

import okhttp3.Interceptor
import retrofit2.Retrofit

class RickAndMortyNetworkClient(
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
