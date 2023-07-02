package android.template.datasources

import android.template.api.mock.MockService
import android.template.api.retrofit.NetworkClient
import android.template.api.service.CatService
import android.template.apimodels.ProductApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking

internal class ProductDataSourceImpl(
    networkClient: NetworkClient,
) : ProductDataSource {

    private val service: CatService = networkClient.retrofit.create(CatService::class.java)

    override fun getData(): Flow<List<ProductApiModel>> {
        val data = runBlocking {
            service.getSubscribedNewsletterSections()
        }
        println("The dog data is $data")

        return MockService.getData()
    }
}
