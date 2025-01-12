package uz.com.oson.presentation.screens.addcard

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.domain.remote.request.card.AddCardRequest

interface AddCardContract {
    data class UIState (
        val isLoading : Boolean = false
    )
    interface Intent {
        object MoveBack : Intent
        data class AddCard(val data  :AddCardRequest) : Intent
    }
    interface Viewmodel {
        val uiState :StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveUp()
    }
}