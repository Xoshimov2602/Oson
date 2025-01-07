package uz.com.oson.screens.fingerprint

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FingerprintViewModelImpl @Inject constructor(
    private val direction : FingerprintContract.Direction
) :ViewModel(), FingerprintContract.ViewModel {
    override val uiState = MutableStateFlow(FingerprintContract.UIState())

    override fun onEventDispatcher(intent: FingerprintContract.Intent) {
        viewModelScope.launch { direction.moveToMain() }
    }
}