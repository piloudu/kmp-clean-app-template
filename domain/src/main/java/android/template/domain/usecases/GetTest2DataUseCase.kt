package android.template.domain.usecases

import android.template.domain.models.Test1Model
import android.template.domain.models.Url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetTest2DataUseCase() : () -> Flow<Test1Model> {
    override fun invoke(): Flow<Test1Model> {
        return flowOf(Test1Model(Url("https://community0.mv")))
    }
}
