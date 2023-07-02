package android.template.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import android.template.core.data.DefaultMyModelRepository
import android.template.core.database.MyModel
import android.template.core.database.MyModelDao

/**
 * Unit tests for [DefaultMyModelRepository].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultMyModelRepositoryTest {

    @Test
    fun myModels_newItemSaved_itemIsReturned() = runTest {
        // TODO: Fix test
        val repository = DefaultMyModelRepository(FakeMyModelDao())

        repository.add("Repository")

        assertEquals(repository.myModels.first().size, 1)
    }

}

private class FakeMyModelDao : MyModelDao {

    private val data = mutableListOf<MyModel>()

    override fun getMyModels(): Flow<List<MyModel>> = flow {
        emit(data)
    }

    override suspend fun insertMyModel(item: MyModel) {
        data.add(0, item)
    }
}
