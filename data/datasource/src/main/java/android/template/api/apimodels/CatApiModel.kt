package android.template.api.apimodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatApiModel(
    @SerialName("owner")
    val owner: String?,
    @SerialName("mimetype")
    val mimeType: String?,
    @SerialName("url")
    val url: String?,
)
