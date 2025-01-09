package uz.com.oson.screens.main

import kotlinx.coroutines.flow.StateFlow

interface MainContract {
    data class UIState (
        var isLoading : Boolean = false
    )
    interface Intent {

    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent: Intent)
    }
    interface Direction {

    }
}