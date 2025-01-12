package uz.com.oson.presentation.screens.confirmpayment

import android.os.Parcelable
import androidx.compose.runtime.MutableState
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.flow.StateFlow
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.response.card.GetCardsResponse
import uz.com.oson.utils.CardsEnum

interface ConfirmPaymentContract {
    data class UIState(
        val isLoading: Boolean = false,
        val allCards : List<GetCardsResponse>
    )
    interface Intent {
        object MoveBack : Intent
        data class OnClickNext(
            val items : TransferRequest
        ): Intent
        object GetCards : Intent
    }
    interface Viewmodel {
        val uiState : MutableState<UIState>
        fun onEventDispatcher (intent : Intent)
    }
    interface Direction  {
        suspend fun moveBack()
        suspend fun moveNext()
    }

    @Parcelize
    data class ConfirmPaymentItems(
        val cardType : CardsEnum,
        var recipientName : String,
        var recipientCardNumber : String,
        val amountPayment : String,
    ) : Parcelable
}