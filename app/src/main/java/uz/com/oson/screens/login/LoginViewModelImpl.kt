package uz.com.oson.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val directions: LoginContract.Directions
): ViewModel(), LoginContract.ViewModel {
    override val uiState = MutableStateFlow(LoginContract.UIState())

    override fun onEventDispatcher(intent: LoginContract.Intent) {
        when (intent) {
            is LoginContract.Intent.OnClickSignUp -> {
                viewModelScope.launch { directions.moveToSignUp() }
            }
            is LoginContract.Intent.OnClickNext -> {
                viewModelScope.launch { directions.moveToCode() }
            }
        }
    }
}