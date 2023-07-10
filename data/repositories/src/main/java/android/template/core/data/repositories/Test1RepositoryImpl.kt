package android.template.core.data.repositories

import android.template.api.apimodels.Test1ApiModel
import android.template.core.data.mappers.toDomainModel
import android.template.datasources.Test1DataSource
import android.template.domain.models.Test1Model
import android.template.domain.repositories.Test1Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class Test1RepositoryImpl(
    private val test1DataSource: Test1DataSource
) : Test1Repository {
    override fun getTest1Data(): Flow<Test1Model> {
        return test1DataSource.getTest1Data().map(Test1ApiModel::toDomainModel)
    }
}
