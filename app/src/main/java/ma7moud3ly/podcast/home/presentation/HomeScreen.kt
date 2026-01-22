package ma7moud3ly.podcast.home.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ma7moud3ly.podcast.home.presentation.model.HomeEvent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToSearch: () -> Unit
) {
    HomeScreenContent(
        sectionsFlow = viewModel.sectionsFlow,
        uiEvents = {
            when (it) {
                HomeEvent.OpenSearch -> navigateToSearch()
                is HomeEvent.OpenAudioArticle -> {}
                HomeEvent.OpenAudioArticles -> {}
                is HomeEvent.OpenAudioBook -> {}
                HomeEvent.OpenAudioBooks -> {}
                is HomeEvent.OpenEpisode -> {}
                HomeEvent.OpenEpisodes -> {}
                is HomeEvent.OpenPodcast -> {}
                HomeEvent.OpenPodcasts -> {}
            }
        }
    )
}