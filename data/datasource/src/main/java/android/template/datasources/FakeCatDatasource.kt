package android.template.datasources

import android.template.api.apimodels.CatApiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCatDatasource(private val isSuccess: Boolean) : CatDataSource {
    override fun getCatSequentially(): Flow<CatApiModel> {
        return flow {
            if (isSuccess) {
                catsList.forEach { cat ->
                    emit(cat)
                    delay(1)
                }
            } else {
                throw catException
            }
        }
    }

    override fun getCatsList(): Flow<List<CatApiModel>> {
        return flow {
            if (isSuccess) {
                emit(catsList)
            } else {
                throw catException
            }
        }
    }
}

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
