package uz.com.oson.presentation.screens.login

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.StateFlow

interface LoginContract {
    data class UIState(
        val isLoading: Boolean = false,
        val isChecked : Boolean = false
    )

    interface Intent {
        object OnClickSignUp : Intent
        data class OnClickNext(val phone: String, val password: String) : Intent
        data class ClickCheckbox(val checked: Boolean):Intent
    }

    interface ViewModel {
        val uiState: StateFlow<UIState>
        val state: MutableState<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    interface Directions {
        suspend fun moveToSignUp()
        suspend fun moveToCode()
    }
}