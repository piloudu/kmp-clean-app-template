package android.template.core.data.mappers

import android.template.api.apimodels.CatApiModel
import android.template.api.httpClient.BASE_CAT_URL
import android.template.domain.models.CatModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

fun CatApiModel.toDomainModel(): CatModel {
    return CatModel(
        owner = Owner(""),
        mimeType = MimeType(this.mimeType),
        url = Url(BASE_CAT_URL),
    )
}
