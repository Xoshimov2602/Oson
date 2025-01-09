package uz.com.oson.screens.register

import kotlinx.coroutines.flow.StateFlow

interface RegisterContract {
    data class UIState (
        var isLoading : Boolean = false
    )
    interface Intent {
        object OpenVerify : Intent
        object OpenLogin : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveToVerify ()
        suspend fun moveToLogin ()
    }
}