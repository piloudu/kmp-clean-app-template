package android.template.domain.usecases

import android.template.domain.models.Test1Model
import android.template.domain.repositories.Test1Repository
import kotlinx.coroutines.flow.Flow

class GetTest1DataUseCase(
    private val test1Repository: Test1Repository,
) : () -> Flow<Test1Model> {
    override fun invoke(): Flow<Test1Model> {
        return test1Repository.getTest1Data()
    }
}
