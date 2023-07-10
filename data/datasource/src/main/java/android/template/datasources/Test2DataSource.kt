package android.template.datasources

import android.template.api.apimodels.Test1ApiModel
import kotlinx.coroutines.flow.Flow

interface Test2DataSource {
    fun getTest2Data(): Flow<Test1ApiModel>
}
