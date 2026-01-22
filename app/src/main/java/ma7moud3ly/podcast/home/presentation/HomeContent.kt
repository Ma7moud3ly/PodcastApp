package ma7moud3ly.podcast.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import kotlinx.coroutines.flow.Flow
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.domain.model.AudioArticlesSection
import ma7moud3ly.podcast.core.domain.model.AudioBooksSection
import ma7moud3ly.podcast.core.domain.model.EpisodesSection
import ma7moud3ly.podcast.core.domain.model.PodcastsSection
import ma7moud3ly.podcast.core.domain.model.Section
import ma7moud3ly.podcast.core.ui.components.ErrorState
import ma7moud3ly.podcast.core.ui.containers.RefreshBox
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.home.presentation.components.HomeBottomAppBar
import ma7moud3ly.podcast.home.presentation.components.HomeCategories
import ma7moud3ly.podcast.home.presentation.components.HomeTopAppBar
import ma7moud3ly.podcast.home.presentation.components.SectionAudioArticles
import ma7moud3ly.podcast.home.presentation.components.SectionAudioBooks
import ma7moud3ly.podcast.home.presentation.components.SectionEpisodes
import ma7moud3ly.podcast.home.presentation.components.SectionPodcasts
import ma7moud3ly.podcast.home.presentation.model.HomeEvent
import ma7moud3ly.podcast.home.presentation.model.testPagingFlow

@Preview
@Composable
private fun HomeScreenPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        HomeScreenContent(
            sectionsFlow = testPagingFlow()
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        HomeScreenContent(
            sectionsFlow = testPagingFlow()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreenContent(
    sectionsFlow: Flow<PagingData<Section>>,
    uiEvents: (HomeEvent) -> Unit = {}
) {
    val lazyPagingItems = sectionsFlow.collectAsLazyPagingItems()
    val loadState = lazyPagingItems.loadState
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            HomeTopAppBar()
        },
        bottomBar = {
            HomeBottomAppBar(
                openSearch = { uiEvents(HomeEvent.OpenSearch) }
            )
        }
    ) { padding ->
        RefreshBox(
            onRefresh = { lazyPagingItems.refresh() },
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (loadState.hasError) {
                when (loadState.refresh) {
                    is LoadState.Error -> {
                        ErrorState(
                            title = stringResource(R.string.error_title),
                            message = "",
                            retry = stringResource(R.string.error_retry),
                            onRetry = { lazyPagingItems.refresh() }
                        )
                    }

                    else -> {}
                }
            } else {
                // show progressbar at the center of screen
                // before items loaded and on refresh
                if (loadState.refresh is LoadState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .zIndex(2f)
                            .align(Alignment.Center)
                    )
                }
                // nested sections
                HomeSections(
                    sections = lazyPagingItems,
                    uiEvents = uiEvents
                )
            }
        }
    }
}

@Composable
private fun HomeSections(
    sections: LazyPagingItems<Section>,
    uiEvents: (HomeEvent) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Static header item
        item {
            HomeCategories(
                modifier = Modifier.fillMaxWidth(),
                onSelected = {}
            )
        }
        // Paging items
        items(
            count = sections.itemCount,
            contentType = sections.itemContentType { it::class.java }
        ) { index ->
            val section = sections[index] ?: return@items
            when (section) {
                is PodcastsSection -> SectionPodcasts(
                    section = section,
                    onShowMore = { uiEvents(HomeEvent.OpenPodcasts) },
                    onItemClicked = { uiEvents(HomeEvent.OpenPodcast(it)) }
                )

                is EpisodesSection -> SectionEpisodes(
                    section = section,
                    onShowMore = { uiEvents(HomeEvent.OpenEpisodes) },
                    onItemClicked = { uiEvents(HomeEvent.OpenEpisode(it)) }
                )

                is AudioBooksSection -> SectionAudioBooks(
                    section = section,
                    onShowMore = { uiEvents(HomeEvent.OpenAudioBooks) },
                    onItemClicked = { uiEvents(HomeEvent.OpenAudioBook(it)) }
                )

                is AudioArticlesSection -> SectionAudioArticles(
                    section = section,
                    onShowMore = { uiEvents(HomeEvent.OpenAudioArticles) },
                    onItemClicked = { uiEvents(HomeEvent.OpenAudioArticle(it)) }
                )
            }
        }

        // show progress bar at the end of the list on appending new items
        if (sections.loadState.append is LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
