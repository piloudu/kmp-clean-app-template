package android.template.datasources

import android.template.api.apimodels.Test1ApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class Test2DataSourceImpl() : Test2DataSource {
    override fun getTest2Data(): Flow<Test1ApiModel> {
        return flowOf(Test1ApiModel(url = "https://community0.mv"))
    }
}
