package ma7moud3ly.podcast.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import ma7moud3ly.podcast.home.domain.use_case.SectionsFlowUseCase

@HiltViewModel
class HomeViewModel @Inject constructor(
    sectionsFlowUseCase: SectionsFlowUseCase,
) : ViewModel() {

    val sectionsFlow = sectionsFlowUseCase().cachedIn(viewModelScope)
}