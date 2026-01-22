package ma7moud3ly.podcast.search.domain.use_case

import ma7moud3ly.podcast.core.domain.model.DataResult
import ma7moud3ly.podcast.core.domain.model.Section
import ma7moud3ly.podcast.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repository: SearchRepository) {
    suspend operator fun invoke(query: String): DataResult<List<Section>> {
        return repository.getSearchResults(query)
    }
}