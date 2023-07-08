package android.template.feature.main.ui.integration.test.cat

import android.template.api.apimodels.CatApiModel
import android.template.datasources.CatDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCatDatasource(private val isSuccess: Boolean) : CatDataSource {
    override fun getCatSequentially(): Flow<CatApiModel> {
        return flow {
            if (isSuccess) {
                catsApiList.forEach { cat ->
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
                emit(catsApiList)
            } else {
                throw catException
            }
        }
    }
}
