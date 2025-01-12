package uz.com.oson.presentation.screens.verify

import kotlinx.coroutines.flow.StateFlow

interface VerifyContract {
    data class UIState (
        var isLoading : Boolean
    )
    interface Intent {
        data class OpenPinCode(val code : String, val isLogin : Boolean) :Intent
        object MoveBack : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveToPinCode ()
        suspend fun moveBack ()
    }
}