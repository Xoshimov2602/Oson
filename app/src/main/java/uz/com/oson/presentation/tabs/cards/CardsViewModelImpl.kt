package uz.com.oson.presentation.tabs.cards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.domain.usecase.card.CardUseCase
import javax.inject.Inject

@HiltViewModel
class CardsViewModelImpl @Inject constructor(
    private val direction : CardsContract.Direction,
    private val useCase: CardUseCase
) : ViewModel(), CardsContract.ViewModel {
    override val uiState = MutableStateFlow (CardsContract.UIState(allCards = emptyList()))

    override fun onEventDispatcher(intent: CardsContract.Intent) {
        when (intent) {
            is CardsContract.Intent.OnCardChosen -> {
                viewModelScope.launch { direction.moveAddCard() }
            }
            is CardsContract.Intent.GetHistory -> {
                viewModelScope.launch {
                    useCase.getCards().collect{ result ->
                        result.onSuccess { list ->
                            uiState.value = uiState.value.copy(allCards = list)
                        }
                        result.onFailure { uiState.value = uiState.value.copy(toastMessage = it.message!!) }
                    }
                }
            }
        }
    }
}