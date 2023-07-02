package android.template.api.interceptors

import okhttp3.Interceptor

internal fun getCatNetworkInterceptor() = Interceptor { interceptorChain ->
    val httpUrl = interceptorChain.request().url.newBuilder().apply {
        addQueryParameter("json", "true")
    }.build()
    val newRequest = interceptorChain.request().newBuilder().url(httpUrl).build()
    interceptorChain.proceed(newRequest)
}
