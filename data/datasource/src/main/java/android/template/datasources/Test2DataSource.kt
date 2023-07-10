package android.template.datasources

import android.template.api.apimodels.Test1ApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Test2DataSource : ITest2DataSource {
    override fun getTest2Data(): Flow<Test1ApiModel> {
        return flowOf(Test1ApiModel(url = "https://chefjhjofzp.rb"))
    }
}
