package ma7moud3ly.podcast.home.presentation.model

import ma7moud3ly.podcast.core.domain.model.DataException
import ma7moud3ly.podcast.core.domain.model.Section

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val sections: List<Section>) : HomeUiState
    data class Error(val dataException: DataException) : HomeUiState
}