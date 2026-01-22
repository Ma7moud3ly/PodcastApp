package ma7moud3ly.podcast.search.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.domain.model.DataException
import ma7moud3ly.podcast.core.domain.model.PodcastsSection
import ma7moud3ly.podcast.core.domain.model.Section
import ma7moud3ly.podcast.core.ui.components.ErrorState
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.search.presentation.components.ItemSearchResult
import ma7moud3ly.podcast.search.presentation.components.SearchCategories
import ma7moud3ly.podcast.search.presentation.components.SearchTopAppBar
import ma7moud3ly.podcast.search.presentation.model.SearchEvent
import ma7moud3ly.podcast.search.presentation.model.SearchUiState
import ma7moud3ly.podcast.search.presentation.model.testSearchResults

@Preview
@Composable
private fun SearchScreenPreview_Dark() {
    val searchUiState = SearchUiState.Success(testSearchResults)
    PodcastAppTheme(darkTheme = true) {
        SearchScreenContent(
            uiState = { searchUiState }
        )
    }
}

@Preview
@Composable
private fun SearchScreenPreview_Light() {
    val searchUiState = SearchUiState.Success(testSearchResults)
    PodcastAppTheme(darkTheme = false) {
        SearchScreenContent(
            uiState = { searchUiState }
        )
    }
}

@Composable
internal fun SearchScreenContent(
    uiState: () -> SearchUiState,
    uiEvents: (SearchEvent) -> Unit = {}
) {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = {
            SearchTopAppBar(
                onSearch = { uiEvents(SearchEvent.OnSearch(it)) },
                onCancel = { uiEvents(SearchEvent.OnBack) },
                onClear = { uiEvents(SearchEvent.OnClear) }
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (val uiState = uiState()) {
                is SearchUiState.Idle -> {
                    Box(modifier = Modifier.fillMaxSize(0.85f)) {
                        Text(
                            text = stringResource(R.string.search_message),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                is SearchUiState.Error -> {
                    val errorMessage = stringResource(
                        when (uiState.dataException) {
                            is DataException.NoInternet -> R.string.error_no_internet
                            else -> R.string.error_unknown
                        }
                    )
                    LaunchedEffect(Unit) {
                        snackbarHostState.showSnackbar(errorMessage)
                    }
                    ErrorState(
                        title = stringResource(R.string.error_title),
                        message = errorMessage,
                        retry = stringResource(R.string.error_retry),
                        onRetry = { uiEvents(SearchEvent.OnClear) }
                    )
                }

                is SearchUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

                is SearchUiState.Success -> {
                    SearchResults(
                        results = uiState.results,
                        uiEvents = uiEvents
                    )
                }
            }
        }
    }
}

@Composable
private fun SearchResults(
    results: List<Section>,
    uiEvents: (SearchEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            SearchCategories()
        }
        results.forEach { section ->
            when (section) {
                is PodcastsSection -> {
                    items(section.items) { podcast ->
                        ItemSearchResult(
                            podcast = podcast,
                            onItemClick = { uiEvents(SearchEvent.OpenPodcast(podcast)) }
                        )
                        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
                    }
                }

                else -> {}
            }
        }
    }
}