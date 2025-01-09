package uz.com.oson.screens.language

import kotlinx.coroutines.flow.StateFlow

interface LanguageContract {
    data class UIState (
        val isLoading : Boolean = false
    )
    interface Intent {
        data class OnClickNext (val language :String) : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveToLogin()
    }
}