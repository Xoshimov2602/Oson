package uz.com.oson.presentation.screens.addcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.domain.usecase.card.CardUseCase
import javax.inject.Inject

@HiltViewModel
class AddCardViewmodel
    @Inject constructor(
        private val direction : AddCardContract.Direction,
        private val useCase : CardUseCase
    ): AddCardContract.Viewmodel, ViewModel() {
    override val uiState = MutableStateFlow(AddCardContract.UIState())

    override fun onEventDispatcher(intent: AddCardContract.Intent) {
        when (intent) {
            is AddCardContract.Intent.MoveBack ->{
                viewModelScope.launch {
                    direction.moveUp() }
            }
            is AddCardContract.Intent.AddCard -> {
                viewModelScope.launch {
                useCase.addCard(intent.data.copy(expiredMonth = "6")).collect{}
                    direction.moveUp()
                }
            }
        }
    }
}