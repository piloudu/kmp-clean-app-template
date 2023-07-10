package android.template.feature.main.ui.integration.test.test2

import android.template.api.apimodels.Test1ApiModel
import android.template.datasources.Test2DataSource
import android.template.feature.main.ui.integration.test.di.TestCase
import android.template.feature.main.ui.integration.test.test1.test1Exception
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeTest2DataSource(private val testCase: TestCase) : Test2DataSource {
    override fun getTest2Data(): Flow<Test1ApiModel> {
        return flow {
            when (testCase) {
                TestCase.SUCCESS -> emit(Test1ApiModel(url = "https://community0.mv"))
                TestCase.FAILURE -> throw test1Exception
                else -> error("Behaviour not defined")
            }
        }
    }
}
