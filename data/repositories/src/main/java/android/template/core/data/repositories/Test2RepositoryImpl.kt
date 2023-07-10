package android.template.core.data.repositories

import android.template.api.apimodels.Test1ApiModel
import android.template.core.data.mappers.toDomainModel
import android.template.datasources.Test2DataSource
import android.template.domain.models.Test1Model
import android.template.domain.repositories.Test2Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Test2RepositoryImpl(
    private val test2DataSource: Test2DataSource,
) : Test2Repository {
    override fun getTest2Data(): Flow<Test1Model> {
        return test2DataSource.getTest2Data().map(Test1ApiModel::toDomainModel)
    }
}
