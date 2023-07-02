package android.template.core.data.repositories

import android.template.apimodels.CatApiModel
import android.template.datasources.CatDataSource
import kotlinx.coroutines.flow.Flow

class DogRepositoryImpl(
    private val catDataSource: CatDataSource,
) {
    fun getDog(): Flow<CatApiModel> {
        return catDataSource.getDog()
    }
}
