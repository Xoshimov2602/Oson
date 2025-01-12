package uz.com.oson.presentation.tabs.main

import kotlinx.coroutines.flow.StateFlow

interface MainContract {
    data class UIState (
        var isLoading : Boolean = false
    )
    interface Intent {
        object OpenTransfer : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent: Intent)
    }
    interface Direction {
        suspend fun moveTransfer()
    }
}