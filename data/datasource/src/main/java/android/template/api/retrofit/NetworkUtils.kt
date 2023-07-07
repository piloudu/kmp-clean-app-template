package android.template.api.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter

internal val contentType: MediaType = "application/json".toMediaType()
internal val json: Json = Json {
    ignoreUnknownKeys = true
}
internal val jsonConverterFactory: Converter.Factory = json.asConverterFactory(contentType)
