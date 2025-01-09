package uz.com.oson.screens.cards

import kotlinx.coroutines.flow.StateFlow

interface CardsContract {
    data class UIState (
        val isLoading : Boolean = false,
        val openDialog : Boolean = false
    )
    interface Intent {
        object OpenCardDialog

    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {

    }
}