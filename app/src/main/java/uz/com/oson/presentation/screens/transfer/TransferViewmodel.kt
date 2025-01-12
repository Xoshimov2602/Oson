package uz.com.oson.presentation.screens.transfer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.domain.remote.request.transfer.GetCardOwnerRequest
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.usecase.transfer.TransferUseCase
import javax.inject.Inject

@HiltViewModel
class TransferViewmodel @Inject constructor(
    private val direction: TransferContract.Direction,
    private val useCase: TransferUseCase
) : ViewModel(), TransferContract.Viewmodel {
    override val uiState = MutableStateFlow(TransferContract.UIState())

    override fun onEventDispatcher(intent: TransferContract.Intentt) {
        when (intent) {
            is TransferContract.Intentt.OpenConfirmPayment -> viewModelScope.launch {
                useCase.getCardOwnerByPan(
                    GetCardOwnerRequest(
                        pan = intent.items.recipientCardNumber
                    )
                ).collect{
                    it.onSuccess {
                        intent.items.recipientName = it
                    }
                }
                direction.moveToConfirmPayment(
                    items = intent.items,
                )
            }
        }
    }
}