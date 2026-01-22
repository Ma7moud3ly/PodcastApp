package ma7moud3ly.podcast.search.domain.repository

import ma7moud3ly.podcast.core.domain.model.DataResult
import ma7moud3ly.podcast.core.domain.model.Section

interface SearchRepository {
    suspend fun getSearchResults(query: String): DataResult<List<Section>>
}
