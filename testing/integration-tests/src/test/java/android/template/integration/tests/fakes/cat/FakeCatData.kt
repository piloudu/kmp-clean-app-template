package android.template.integration.tests.fakes.cat

import android.template.api.apimodels.CatApiModel

val catsList: List<CatApiModel> = listOf(
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
