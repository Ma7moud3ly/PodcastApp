package ma7moud3ly.podcast.home.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ma7moud3ly.podcast.core.domain.model.Section

interface SectionsRepository {
    fun getSectionsPaged(
        pageSize: Int,
        enablePlaceHolders: Boolean,
        prefetchDistance: Int,
        initialLoadSize: Int,
        maxCacheSize: Int
    ): Flow<PagingData<Section>>
}