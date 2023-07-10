package android.template.domain.repositories

import android.template.domain.models.Test1Model
import kotlinx.coroutines.flow.Flow

interface ITest2Repository {
    fun getTest2Data(): Flow<Test1Model>
}
