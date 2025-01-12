package uz.com.oson.presentation.tabs.cards

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.domain.remote.response.card.GetCardsResponse
import uz.com.oson.utils.CardsEnum

interface CardsContract {
    data class UIState (
        var toastMessage : String = "",
        val openDialog : Boolean = false,
        var allCards : List<GetCardsResponse>
    )
    interface Intent {
        data class OnCardChosen (val card : CardsEnum) : Intent
        object GetHistory : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveAddCard ()
    }
}