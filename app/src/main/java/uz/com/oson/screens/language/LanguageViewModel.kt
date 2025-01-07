package uz.com.oson.screens.language

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.utils.MainContract.Intent
import uz.com.oson.utils.MainContract.UiState

interface LanguageViewModel {
    val uiState : StateFlow<UiState>
    fun onEventDispatcher (intent : Intent)
    fun saveLanguage (language : String)
}