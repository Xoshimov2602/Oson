package uz.com.oson.screens.register

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.utils.MainContract.Intent
import uz.com.oson.utils.MainContract.UiState

interface RegisterViewModel {
    val uiState : StateFlow<UiState>
    fun onEventDispatcher (intent: Intent)
}