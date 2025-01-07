package uz.com.oson.screens.login

import kotlinx.coroutines.flow.StateFlow

interface LoginContract {
    data class UIState (
        val isLoading : Boolean = false
    )
    interface Intent {
        object OnClickSignUp : Intent
        data class OnClickNext(val phone : String, val password : String) : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Directions {
        suspend fun moveToSignUp ()
        suspend fun moveToCode ()
    }
}