package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.repositories.CatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class FakeCatRepository(val isSuccess: Boolean = true) : CatRepository {
    override fun getCat(): Flow<CatModel> {
        return flow {
            catsList.forEach { cat ->
                if (isSuccess) {
                    emit(cat)
                } else {
                    throw catException
                }
                delay(1)
            }
        }
    }

    override fun getCatsList(): Flow<List<CatModel>> {
        return if (isSuccess) {
            flowOf(catsList)
        } else {
            throw catException
        }
    }
}
