package uz.com.oson.presentation.screens.confirmpayment

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.domain.usecase.card.CardUseCase
import uz.com.oson.domain.usecase.transfer.TransferUseCase
import javax.inject.Inject

@HiltViewModel
class ConfirmPaymentViewmodel @Inject constructor(
    private val direction: ConfirmPaymentContract.Direction,
    private val useCase: TransferUseCase,
    private val cardUseCase: CardUseCase
) : ViewModel(), ConfirmPaymentContract.Viewmodel {
    override val uiState = mutableStateOf(ConfirmPaymentContract.UIState(allCards = emptyList()))

    override fun onEventDispatcher(intent: ConfirmPaymentContract.Intent) {
        when (intent) {
            is ConfirmPaymentContract.Intent.MoveBack -> viewModelScope.launch { direction.moveBack() }
            is ConfirmPaymentContract.Intent.OnClickNext -> {
                viewModelScope.launch {
                    useCase.transfer(intent.items).collect{}
                    direction.moveNext()
                }
            }

            is ConfirmPaymentContract.Intent.GetCards -> {
                viewModelScope.launch {
                    cardUseCase.getCards().collect { result ->
                        result.onSuccess { list ->
                            uiState.value = uiState.value.copy(allCards = list)
                        }
                        result.onFailure {  }
                    }
                }
            }
        }
    }
}