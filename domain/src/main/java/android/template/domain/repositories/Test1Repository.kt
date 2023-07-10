package android.template.domain.repositories

import android.template.domain.models.Test1Model
import kotlinx.coroutines.flow.Flow

interface Test1Repository {
    fun getTest1Data(): Flow<Test1Model>
}
