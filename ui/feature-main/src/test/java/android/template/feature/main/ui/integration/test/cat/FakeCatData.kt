package android.template.feature.main.ui.integration.test.cat

import android.template.api.apimodels.BASE_CAT_URL
import android.template.api.apimodels.CatApiModel
import android.template.feature.main.ui.cat.CatUiModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

val catsUiList: PersistentList<CatUiModel> = persistentListOf(
    CatUiModel(
        owner = "Owner 1",
        mimeType = "image",
        url = BASE_CAT_URL + "c4df7890",
    ),

    CatUiModel(
        owner = "Owner 2",
        mimeType = "image",
        url = BASE_CAT_URL + "bc74349c",
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
