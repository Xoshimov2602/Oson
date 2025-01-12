package uz.com.oson.presentation.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.request.auth.RegisterRequest
import uz.com.oson.domain.usecase.auth.AuthUseCase
import javax.inject.Inject

@HiltViewModel
class RegisterViewModelImpl @Inject constructor(
    private val direction: RegisterContract.Direction,
    private val useCase: AuthUseCase,
    private val preference: MyPreference
) : ViewModel(), RegisterContract.ViewModel {
    override val uiState = MutableStateFlow(RegisterContract.UIState())

    override fun onEventDispatcher(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.OpenLogin -> {
                viewModelScope.launch { direction.moveToLogin() }
            }

            is RegisterContract.Intent.OpenVerify -> {
                val bundle = intent.registerBundle
                viewModelScope.launch {
                    useCase.registerUser(
                        RegisterRequest(
                            phone = bundle.phone,
                            password = bundle.password,
                            firstName = bundle.name,
                            lastName = bundle.lastName,
                            bornDate = bundle.birthDate
                        )
                    ).collect {
                        it.onSuccess {
                            preference.isRegistered = true
                            direction.moveToVerify()
                        }
                        it.onFailure {

                        }
                    }
                }
            }
        }
    }
}