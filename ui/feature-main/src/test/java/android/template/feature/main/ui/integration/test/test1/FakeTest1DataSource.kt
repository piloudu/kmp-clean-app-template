package android.template.feature.main.ui.integration.test.test1

import android.template.api.apimodels.Test1ApiModel
import android.template.datasources.Test1DataSource
import android.template.feature.main.ui.integration.test.di.TestCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeTest1DataSource(private val testCase: TestCase) : Test1DataSource {
    override fun getTest1Data(): Flow<Test1ApiModel> {
        return flow {
            when (testCase) {
                TestCase.SUCCESS -> emit(Test1ApiModel(url = "https://optionait9jbl.avl"))
                TestCase.FAILURE -> throw test1Exception
                else -> error("Behaviour not defined")
            }
        }
    }
}
