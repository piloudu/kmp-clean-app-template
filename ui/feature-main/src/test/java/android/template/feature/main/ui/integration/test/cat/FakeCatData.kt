package android.template.feature.main.ui.integration.test.cat

import android.template.api.apimodels.BASE_CAT_URL
import android.template.api.apimodels.CatApiModel
import android.template.domain.models.CatModel
import android.template.domain.models.MimeType
import android.template.domain.models.Owner
import android.template.domain.models.Url

val catsDomainList: List<CatModel> = listOf(
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

val catsApiList: List<CatApiModel> = listOf(
    CatApiModel(
        owner = "Owner 1",
        mimeType = "image",
        url = "c4df7890",
    ),
    CatApiModel(
        owner = "Owner 2",
        mimeType = "image",
        url = "bc74349c",
    ),
)

val catException: Exception = Exception()
