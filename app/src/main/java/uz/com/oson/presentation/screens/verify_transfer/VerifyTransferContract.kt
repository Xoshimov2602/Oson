package uz.com.oson.presentation.screens.verify_transfer
import androidx.compose.runtime.MutableState

interface VerifyTransferContract {
    data class UIState(
        val isLoading: Boolean = false
    )
    interface Action {
        data class VerifyPayment(val code : String) : Action
        object MoveBack  :Action
    }
    interface Viewmodel{
        val uiState  : MutableState<UIState>
        fun onEventDispatcher (action : Action)
    }
    interface Direction {
        suspend fun moveBack ()
    }
}