package ma7moud3ly.podcast.home.domain.use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ma7moud3ly.podcast.core.domain.model.Section
import ma7moud3ly.podcast.home.domain.repository.SectionsRepository
import javax.inject.Inject

class SectionsFlowUseCase @Inject constructor(private val repository: SectionsRepository) {
    operator fun invoke(): Flow<PagingData<Section>> {
        return repository.getSectionsPaged(
            pageSize = 7,
            enablePlaceHolders = false,
            prefetchDistance = 1,
            initialLoadSize = 0,
            maxCacheSize = 100
        )
    }
}