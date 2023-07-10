package android.template.datasources

import android.template.api.apimodels.Test1ApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class Test1DataSourceImpl : Test1DataSource {
    override fun getTest1Data(): Flow<Test1ApiModel> {
        return flow {
            emit(Test1ApiModel(url = "https://optionait9jbl.avl"))
        }
    }
}
