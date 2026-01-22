package ma7moud3ly.podcast.search.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ma7moud3ly.podcast.core.domain.model.fold
import ma7moud3ly.podcast.search.domain.use_case.SearchUseCase
import ma7moud3ly.podcast.search.presentation.model.SearchUiState

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
) : ViewModel() {


    private val _searchUiState = MutableStateFlow<SearchUiState>(SearchUiState.Idle)
    val searchUiState: StateFlow<SearchUiState> = _searchUiState.asStateFlow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SearchUiState.Idle
    )

    fun clear() {
        _searchUiState.value = SearchUiState.Idle
    }

    fun search(query: String) {
        Log.v(TAG, "search: $query")
        viewModelScope.launch {
            _searchUiState.value = SearchUiState.Loading
            val result = searchUseCase(query)
            result.fold(
                onSuccess = {
                    _searchUiState.value = SearchUiState.Success(it)
                },
                onFailure = {
                    _searchUiState.value = SearchUiState.Error(it)
                }
            )
        }
    }

    companion object {
        private const val TAG = "SearchViewModel"

    }
}