package android.template.domain.repositories

import android.template.domain.models.CatModel
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCat(): Flow<CatModel>
}
