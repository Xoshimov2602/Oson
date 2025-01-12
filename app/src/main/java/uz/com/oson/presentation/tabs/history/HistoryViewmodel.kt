package uz.com.oson.presentation.tabs.history

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.com.oson.domain.remote.response.transfer.HistoryResponse
import uz.com.oson.domain.usecase.transfer.TransferUseCase
import javax.inject.Inject

@HiltViewModel
class HistoryViewmodel @Inject constructor(
    private val useCase : TransferUseCase,
    private val direction: HistoryDirection
) : HistoryContract.Viewmodel, ViewModel() {
    override val uiState = mutableStateOf(HistoryContract.UIState(
        historyList = HistoryResponse(10, 1, 1, emptyList())
    ))

    override fun clickEvents(action: HistoryContract.Action) {

        when (action) {
            is HistoryContract.Action.GetAllHistory -> {
                viewModelScope.launch {
                    useCase.getHistory().collect{ result ->
                        result.onSuccess {
                            uiState.value = uiState.value.copy(historyList = it)
                        }
                        result.onFailure {
                            uiState.value = uiState.value.copy(toastMessage = it.message!!)
                        }
                    }
                }
            }
        }
    }
}