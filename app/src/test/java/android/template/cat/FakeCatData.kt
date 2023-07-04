package android.template.cat

import android.template.api.apimodels.BASE_CAT_URL
import android.template.domain.models.CatModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

val catsList: List<CatModel> = listOf(
    CatModel(
        owner = Owner(value = "Owner 1"),
        mimeType = MimeType(value = "image"),
        url = Url(value = BASE_CAT_URL + "c4df7890"),
    ),
    CatModel(
        owner = Owner(value = "Owner 2"),
        mimeType = MimeType(value = "image"),
        url = Url(value = BASE_CAT_URL + "bc74349c"),
    ),
)
