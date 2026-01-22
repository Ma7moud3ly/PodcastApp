package ma7moud3ly.podcast.search.presentation.model

import ma7moud3ly.podcast.core.domain.model.DataException
import ma7moud3ly.podcast.core.domain.model.Section

sealed interface SearchUiState {
    data object Loading : SearchUiState
    data object Idle : SearchUiState
    data class Success(val results: List<Section>) : SearchUiState
    data class Error(val dataException: DataException) : SearchUiState
}