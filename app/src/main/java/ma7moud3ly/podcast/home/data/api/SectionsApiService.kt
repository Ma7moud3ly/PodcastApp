package ma7moud3ly.podcast.home.data.api

import ma7moud3ly.podcast.home.data.model.SectionsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SectionsApiService {
    @GET("home_sections")
    suspend fun getSections(@Query("page") page: Int): SectionsResponse
}