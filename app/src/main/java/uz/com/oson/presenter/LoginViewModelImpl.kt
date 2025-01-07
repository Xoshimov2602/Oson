package uz.com.oson.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.screens.login.LoginViewModel
import uz.com.oson.utils.MainContract
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val direction: MainContract.Directions
) : ViewModel(), LoginViewModel {

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