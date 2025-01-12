package uz.com.oson.presentation.tabs.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val direction : MainContract.Direction
) : ViewModel(), MainContract.ViewModel {
    override val uiState = MutableStateFlow(MainContract.UIState())

    override fun onEventDispatcher(intent: MainContract.Intent) {
        when (intent) {
            MainContract.Intent.OpenTransfer ->
                viewModelScope.launch { direction.moveTransfer() }
        }
    }
}