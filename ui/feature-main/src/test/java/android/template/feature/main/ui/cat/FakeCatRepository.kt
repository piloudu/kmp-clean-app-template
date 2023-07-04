package android.template.feature.main.ui.cat

import android.template.domain.models.CatModel
import android.template.domain.repositories.CatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class FakeCatRepository : CatRepository {
    override fun getCat(): Flow<CatModel> {
        return flow {
            catsList.forEach { cat ->
                emit(cat)
                delay(1)
            }
        }
    }

    override fun getCatsList(): Flow<List<CatModel>> {
        return flowOf(catsList)
    }
}
