package ma7moud3ly.podcast.search.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ma7moud3ly.podcast.search.presentation.model.SearchEvent

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState by viewModel.searchUiState.collectAsStateWithLifecycle()

    SearchScreenContent(
        uiState = { uiState },
        uiEvents = {
            when (it) {
                SearchEvent.OnBack -> {
                    viewModel.clear()
                    onBack()
                }

                SearchEvent.OnClear -> viewModel.clear()
                is SearchEvent.OnSearch -> viewModel.search(it.query)
                else -> {}
            }
        }
    )
}