package uz.com.oson.screens.pincode

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.utils.MainContract.Intent
import uz.com.oson.utils.MainContract.UiState

interface PinCodeViewmodel {
    val uiState : StateFlow<UiState>
    fun onEventDispatcher (intent: Intent)
}