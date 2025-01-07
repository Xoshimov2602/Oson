package uz.com.oson.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.com.oson.screens.fingerprint.FingerprintScreen
import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.pincode.PinCodeViewmodel
import uz.com.oson.utils.MainContract
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModelImpl @Inject constructor(
    private val navigator : AppNavigator,
    private val direction : MainContract.Directions
) :ViewModel(), PinCodeViewmodel {

    fun openFingerprint(){
        viewModelScope.launch { navigator.navigateTo(FingerprintScreen()) }
    }

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