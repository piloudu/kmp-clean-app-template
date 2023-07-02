package android.template.api.service

import android.template.apimodels.CatApiModel
import retrofit2.http.GET

interface CatService {
    @GET("cat")
    suspend fun getCat(): CatApiModel
}
