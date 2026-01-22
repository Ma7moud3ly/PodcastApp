package ma7moud3ly.podcast.search.data.api

import ma7moud3ly.podcast.search.data.model.SearchResultsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {
    @GET("search")
    suspend fun getSearchResults(@Query("query") query: String = ""): SearchResultsResponse
}