package uz.com.oson.utils

import kotlinx.coroutines.flow.StateFlow

interface MainContract {

    sealed interface Intent {
        data object OpenCode :Intent
        data object OpenPinCode : Intent
        data object OpenFingerprint : Intent
        data object OpenMain : Intent
        data object OpenRegister : Intent
        data object OpenLogin : Intent
    }

    data class UiState(
        var checkBoxState : Boolean = false
    )

    interface Directions {
        suspend fun navigateToCode()
        suspend fun navigateToPinCode()
        suspend fun navigateToFingerprint()
        suspend fun navigateToMain ()
        suspend fun navigateToLanguage ()
        suspend fun navigateToRegister ()
        suspend fun navigateToLogin ()
    }
}