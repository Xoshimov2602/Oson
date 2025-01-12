package uz.com.oson.presentation.screens.register

import kotlinx.coroutines.flow.StateFlow

interface RegisterContract {
    data class UIState (
        var isLoading : Boolean = false
    )
    interface Intent {
        data class OpenVerify(val registerBundle: RegisterBundle) : Intent
        object OpenLogin : Intent
    }
    interface ViewModel {
        val uiState : StateFlow<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction {
        suspend fun moveToVerify ()
        suspend fun moveToLogin ()
    }
    data class RegisterBundle (
        val name : String,
        val lastName : String,
        val birthDate : String,
        val phone : String,
        val password : String
    )
}