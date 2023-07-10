package android.template.feature.main.ui.integration.test.test2

import android.template.api.apimodels.Test1ApiModel
import android.template.datasources.ITest2DataSource
import android.template.feature.main.ui.integration.test.di.TestCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeTest2DataSource(private val testCase: TestCase) : ITest2DataSource {
    override fun getTest2Data(): Flow<Test1ApiModel> {
        return flowOf(Test1ApiModel(url = "https://chefjhjofzp.rb"))
    }
}
