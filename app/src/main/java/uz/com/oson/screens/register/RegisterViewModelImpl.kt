package uz.com.oson.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModelImpl @Inject constructor(
    private val direction: RegisterContract.Direction
) : ViewModel(), RegisterContract.ViewModel {
    override val uiState = MutableStateFlow(RegisterContract.UIState())

    override fun onEventDispatcher(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.OpenLogin -> {
                viewModelScope.launch { direction.moveToLogin() }
            }
            is RegisterContract.Intent.OpenVerify -> {
                viewModelScope.launch { direction.moveToVerify() }
            }
        }
    }
}