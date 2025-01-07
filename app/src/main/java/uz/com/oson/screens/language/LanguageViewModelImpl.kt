package uz.com.oson.screens.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LanguageViewModelImpl @Inject constructor(
    private val direction: LanguageContract.Direction
) : ViewModel(), LanguageContract.ViewModel {
    override val uiState = MutableStateFlow(LanguageContract.UIState())

    override fun onEventDispatcher(intent: LanguageContract.Intent) {
        viewModelScope.launch { direction.moveToLogin() }
    }
}