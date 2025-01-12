package uz.com.oson.presentation.screens.transfer

import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.presentation.screens.confirmpayment.ConfirmPaymentContract

interface TransferContract {
    data class UIState(
        val isLoading: Boolean = false
    )

    interface Intentt {
        data class OpenConfirmPayment(val items: ConfirmPaymentContract.ConfirmPaymentItems) :
            Intentt
    }

    interface Viewmodel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intentt)
    }

    interface Direction {
        suspend fun moveToConfirmPayment(items: ConfirmPaymentContract.ConfirmPaymentItems)
    }
}