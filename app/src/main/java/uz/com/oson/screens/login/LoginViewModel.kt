package uz.com.oson.screens.login

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.utils.MainContract.Intent
import uz.com.oson.utils.MainContract.UiState

interface LoginViewModel {
    val uiState : StateFlow<UiState>
    fun onEventDispatcher (intent: Intent)
}