package uz.com.oson.presentation.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.usecase.auth.AuthUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val directions: LoginContract.Directions,
    private val useCase: AuthUseCase,
    private val preference: MyPreference
) : ViewModel(), LoginContract.ViewModel {
    override val uiState = MutableStateFlow(LoginContract.UIState())
    override val state: MutableState<LoginContract.UIState> =
        mutableStateOf(LoginContract.UIState())

    override fun onEventDispatcher(intent: LoginContract.Intent) {
        when (intent) {
            is LoginContract.Intent.OnClickSignUp -> {
                viewModelScope.launch { directions.moveToSignUp() }
            }

            is LoginContract.Intent.OnClickNext -> {
                viewModelScope.launch {
                    useCase.loginUser(LoginRequest(phone = intent.phone, password = intent.password)).collect{
                        preference.isRegistered = true
                        viewModelScope.launch { directions.moveToCode() }
                    }
                }
            }

            is LoginContract.Intent.ClickCheckbox -> {
                state.value = state.value.copy(isChecked = intent.checked)
            }
        }
    }
}