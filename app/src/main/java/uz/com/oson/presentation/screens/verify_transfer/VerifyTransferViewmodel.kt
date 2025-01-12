package uz.com.oson.presentation.screens.verify_transfer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.request.transfer.TransferVerifyRequest
import uz.com.oson.domain.usecase.transfer.TransferUseCase
import javax.inject.Inject

@HiltViewModel
class VerifyTransferViewmodel @Inject constructor(
    private val direction: VerifyTransferDirection,
    private val useCase : TransferUseCase
) : VerifyTransferContract.Viewmodel, ViewModel() {
    override val uiState = mutableStateOf(VerifyTransferContract.UIState())

    override fun onEventDispatcher(action: VerifyTransferContract.Action) {
        when (action) {
            is VerifyTransferContract.Action.VerifyPayment -> {
                viewModelScope.launch {
                    useCase.transferVerify(action.code).collect{}
                    direction.moveBack()
                }
            }
            is VerifyTransferContract.Action.MoveBack -> {
                viewModelScope.launch {
                    direction.moveBack()
                }
            }
        }
    }
}