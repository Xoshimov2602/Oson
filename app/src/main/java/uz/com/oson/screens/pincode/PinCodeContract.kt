package uz.com.oson.screens.pincode

import kotlinx.coroutines.flow.StateFlow

interface PinCodeContract {
    data class UIState(
        val isLoading: Boolean = false
    )

    interface Intent {
        data class OnClickNext (val code : String) : Intent
    }

    interface ViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }
    interface Direction {
        suspend fun moveToFingerprint ()
    }
}