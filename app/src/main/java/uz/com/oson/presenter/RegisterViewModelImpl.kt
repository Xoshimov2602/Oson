package uz.com.oson.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.com.oson.screens.register.RegisterViewModel
import uz.com.oson.utils.MainContract
import javax.inject.Inject

class RegisterViewModelImpl @Inject constructor(
    private val direction: MainContract.Directions
) : ViewModel(), RegisterViewModel {
    override val uiState = MutableStateFlow(MainContract.UiState())

    override fun onEventDispatcher(intent: MainContract.Intent) {
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
                viewModelScope.launch { direction.navigateToLogin() }
            }
        }
    }
}