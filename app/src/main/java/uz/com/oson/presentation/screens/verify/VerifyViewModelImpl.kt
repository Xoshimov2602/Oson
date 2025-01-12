package uz.com.oson.presentation.screens.verify

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.com.oson.domain.usecase.auth.AuthUseCase
import javax.inject.Inject

@HiltViewModel
class VerifyViewModelImpl @Inject constructor(
    private val direction : VerifyContract.Direction,
    private val useCase: AuthUseCase
) : VerifyContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(VerifyContract.UIState(false))

    override fun onEventDispatcher(intent: VerifyContract.Intent) {
        when (intent) {
            is VerifyContract.Intent.OpenPinCode -> {
                if (intent.isLogin){
                    viewModelScope.launch { useCase.verifyLogin(intent.code).collect() }
                } else {
                    viewModelScope.launch { useCase.verifyRegister(intent.code).collect{} }
                }
                viewModelScope.launch { direction.moveToPinCode() }
            }
            is VerifyContract.Intent.MoveBack -> {
                viewModelScope.launch { direction.moveBack() }
            }
        }
    }
}