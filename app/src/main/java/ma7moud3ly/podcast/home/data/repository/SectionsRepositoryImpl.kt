package ma7moud3ly.podcast.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ma7moud3ly.podcast.core.domain.model.Section
import ma7moud3ly.podcast.home.data.api.SectionsApiService
import ma7moud3ly.podcast.home.data.datasource.remote.SectionsPagingSource
import ma7moud3ly.podcast.home.data.mapper.toAudioArticleSection
import ma7moud3ly.podcast.home.data.mapper.toAudioBookSection
import ma7moud3ly.podcast.home.data.mapper.toEpisodeSection
import ma7moud3ly.podcast.home.data.mapper.toPodcastSection
import ma7moud3ly.podcast.home.data.model.ContentType
import ma7moud3ly.podcast.home.domain.repository.SectionsRepository
import javax.inject.Inject

class SectionsRepositoryImpl @Inject constructor(
    private val sectionsApiServices: SectionsApiService
) : SectionsRepository {

    override fun getSectionsPaged(
        pageSize: Int,
        enablePlaceHolders: Boolean,
        prefetchDistance: Int,
        initialLoadSize: Int,
        maxCacheSize: Int
    ): Flow<PagingData<Section>> {
        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = enablePlaceHolders,
                prefetchDistance = prefetchDistance,
                initialLoadSize = initialLoadSize,
                maxSize = maxCacheSize
            ),
            pagingSourceFactory = {
                SectionsPagingSource(sectionsApiServices)
            }
        ).flow.map { pagingData ->
            pagingData.map {
                when (it.getContentType()) {
                    ContentType.PODCAST -> it.toPodcastSection()
                    ContentType.EPISODE -> it.toEpisodeSection()
                    ContentType.AUDIO_BOOK -> it.toAudioBookSection()
                    ContentType.AUDIO_ARTICLE -> it.toAudioArticleSection()
                    else -> it.toPodcastSection()
                }
            }
        }
    }
}