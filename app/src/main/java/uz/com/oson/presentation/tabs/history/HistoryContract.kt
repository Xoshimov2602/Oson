package uz.com.oson.presentation.tabs.history

import androidx.compose.runtime.MutableState
import uz.com.oson.domain.remote.response.transfer.HistoryResponse

interface HistoryContract {
    data class UIState(
        var historyList: HistoryResponse,
        var toastMessage : String = ""
    )
    interface Action {
        object GetAllHistory : Action
    }
    interface Viewmodel {
        val uiState : MutableState<UIState>
        fun clickEvents (action : Action)
    }
    interface Direction {

    }

}