package android.template.datasources

import android.template.api.apimodels.Test1ApiModel
import kotlinx.coroutines.flow.Flow

interface Test1DataSource {
    fun getTest1Data(): Flow<Test1ApiModel>
}
