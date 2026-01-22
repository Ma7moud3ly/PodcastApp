package ma7moud3ly.podcast.search.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ma7moud3ly.podcast.core.domain.model.DataException
import ma7moud3ly.podcast.core.domain.model.DataResult
import ma7moud3ly.podcast.search.data.datasource.remote.SearchRemoteDs
import ma7moud3ly.podcast.search.data.mapper.toPodcastSection
import ma7moud3ly.podcast.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDs: SearchRemoteDs,
    private val ioDispatcher: CoroutineDispatcher
) : SearchRepository {
    override suspend fun getSearchResults(query: String) = withContext(ioDispatcher) {
        try {
            val results = searchRemoteDs.getSearchResult(query).map { it.toPodcastSection() }
            DataResult.Success(results)
        } catch (e: DataException) {
            e.printStackTrace()
            DataResult.Error(e)
        }
    }
}