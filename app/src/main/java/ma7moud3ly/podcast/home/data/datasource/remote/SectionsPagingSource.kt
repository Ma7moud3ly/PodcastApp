package ma7moud3ly.podcast.home.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ma7moud3ly.podcast.home.data.api.SectionsApiService
import ma7moud3ly.podcast.home.data.model.SectionResponse
import javax.inject.Inject

/**
 * https://medium.com/@me.zahidul/mastering-android-pagination-with-paging-3-jetpack-compose-9c8bad8ee98f
 */
class SectionsPagingSource @Inject constructor(
    private val apiService: SectionsApiService
) : PagingSource<Int, SectionResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SectionResponse> {
        val pageIndex = params.key ?: 1
        return try {
            val responseData = apiService.getSections(pageIndex)
            LoadResult.Page(
                data = responseData.sections,
                prevKey = if (pageIndex == 1) null else pageIndex - 1,
                nextKey = if (pageIndex > 10) null else pageIndex + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SectionResponse>): Int? {
        // Returning null forces the Pager to start over from your
        // initial load key (usually 1 or 0)
        return null
    }
}