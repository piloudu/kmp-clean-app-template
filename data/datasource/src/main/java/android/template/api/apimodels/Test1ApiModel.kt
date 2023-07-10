package android.template.api.apimodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Test1ApiModel(
    @SerialName("url")
    val url: String?
)
