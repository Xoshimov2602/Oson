package uz.com.oson.presentation.screens.language

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.StateFlow

interface LanguageContract {
    data class UIState (
        val isLoading : Boolean = false,
        val isChecked  :Boolean = false
    )
    interface Intent {
        data class OnClickNext (val language :String) : Intent
        data class ClickCheckBox (val checked : Boolean) : Intent
    }
    interface ViewModel {
//        val uiState : StateFlow<UIState>
        val state  :MutableState<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveToLogin()
    }
}