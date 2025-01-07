package uz.com.oson.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.preference.MyPreference
import uz.com.oson.screens.language.LanguageViewModel
import uz.com.oson.utils.MainContract
import javax.inject.Inject

@HiltViewModel
class LanguageViewmodelImpl @Inject constructor(
    private val direction: MainContract.Directions,
    private val preference : MyPreference
) : ViewModel(), LanguageViewModel {

    override val uiState = MutableStateFlow(MainContract.UiState())

    override fun onEventDispatcher(intent: MainContract.Intent) {
        Log.d("TTT", "onEventDispatcher: ${intent}")
        when (intent) {
            is MainContract.Intent.OpenMain -> {
                viewModelScope.launch { direction.navigateToMain() }
            }

            is MainContract.Intent.OpenCode -> {
                viewModelScope.launch { direction.navigateToCode() }
            }

            is MainContract.Intent.OpenFingerprint -> {
                viewModelScope.launch { direction.navigateToFingerprint() }
            }

            is MainContract.Intent.OpenPinCode -> {
                viewModelScope.launch { direction.navigateToCode() }
            }

            is MainContract.Intent.OpenRegister -> {
                viewModelScope.launch { direction.navigateToRegister() }
            }

            is MainContract.Intent.OpenLogin -> {
                Log.d("TTT", "onEventDispatcher: open login")
                viewModelScope.launch { direction.navigateToLogin() }
            }
        }
    }

    override fun saveLanguage(language: String) {
        preference.chosenLanguage = language
    }
}