package uz.com.oson.presentation.screens.fingerprint

import kotlinx.coroutines.flow.StateFlow

interface FingerprintContract {
    data class UIState (
        val isLoading : Boolean = false
    )
    interface Intent {
        object OnClickNext : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent: Intent)
    }
    interface Direction {
        suspend fun moveToMain ()
    }
}