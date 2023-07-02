package android.template.datasources

import android.template.apimodels.CatApiModel
import kotlinx.coroutines.flow.Flow

interface CatDataSource {
    fun getDog(): Flow<CatApiModel>
}