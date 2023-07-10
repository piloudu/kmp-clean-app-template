package android.template.datasources

import android.template.api.apimodels.Test1ApiModel
import kotlinx.coroutines.flow.Flow

interface ITest2DataSource {
    fun getTest2Data(): Flow<Test1ApiModel>
}
