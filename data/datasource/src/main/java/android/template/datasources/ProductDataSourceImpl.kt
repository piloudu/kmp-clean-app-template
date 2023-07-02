package android.template.datasources

import android.template.datasources.apimodels.ProductApiModel
import android.template.datasources.service.mock.MockService
import android.template.datasources.service.retrofit.NetworkClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

internal class ProductDataSourceImpl(
    networkClient: NetworkClient,
) : ProductDataSource {

    private val service: DogService = networkClient.retrofit.create(DogService::class.java)

    override fun getData(): Flow<ProductApiModel> {
        val data = runBlocking {
            service.getSubscribedNewsletterSections()
        }
        println("The dog data is $data")

        return MockService.getData()
    }
}

interface DogService {
    @GET("random")
    suspend fun getSubscribedNewsletterSections(): DogApiModel
}

@Serializable
data class DogApiModel(
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: String,
)
