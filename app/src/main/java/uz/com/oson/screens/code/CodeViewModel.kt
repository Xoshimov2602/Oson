package uz.com.oson.screens.code

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.utils.MainContract.Intent
import uz.com.oson.utils.MainContract.UiState

interface CodeViewModel {

    val uiState : StateFlow<UiState>
    fun onEventDispatcher (intent: Intent)
}