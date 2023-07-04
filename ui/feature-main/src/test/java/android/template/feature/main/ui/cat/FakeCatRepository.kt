package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.repositories.CatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCatRepository(private val isSuccess: Boolean = true) : CatRepository {
    override fun getCat(): Flow<CatModel> {
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

    override fun getCatsList(): Flow<List<CatModel>> {
        return flow {
            if (isSuccess) {
                emit(catsList)
            } else {
                throw catException
            }
        }
    }
}
