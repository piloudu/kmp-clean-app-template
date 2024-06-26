package android.template.api.apimodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatApiModel(
    val tags: List<String>,
    @SerialName("mimetype")
    val mimeType: String,
    val size: Int?,
)
