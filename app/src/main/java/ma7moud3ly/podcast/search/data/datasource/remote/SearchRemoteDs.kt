package ma7moud3ly.podcast.search.data.datasource.remote

import coil3.network.HttpException
import jakarta.inject.Inject
import ma7moud3ly.podcast.core.data.mapper.toDataException
import ma7moud3ly.podcast.search.data.api.SearchApiService
import ma7moud3ly.podcast.search.data.model.SearchResponse

class SearchRemoteDs @Inject constructor(
    private val service: SearchApiService
) {
    suspend fun getSearchResult(query: String): List<SearchResponse> {
        return try {
            service.getSearchResults(query).results
        } catch (e: Exception) {
            e.printStackTrace()
            throw e.toDataException()
        }
    }
}