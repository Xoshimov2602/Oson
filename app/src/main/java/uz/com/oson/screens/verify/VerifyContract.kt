package uz.com.oson.screens.verify

import kotlinx.coroutines.flow.StateFlow

interface VerifyContract {
    data class UIState (
        var isLoading : Boolean = false
    )
    interface Intent {
        object OpenPinCode :Intent
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