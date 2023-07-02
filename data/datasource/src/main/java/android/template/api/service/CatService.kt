package android.template.api.service

import android.template.apimodels.CatApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("cat")
    suspend fun getSubscribedNewsletterSections(): CatApiModel
}
