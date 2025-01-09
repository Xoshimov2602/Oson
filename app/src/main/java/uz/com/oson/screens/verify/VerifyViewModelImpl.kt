package uz.com.oson.screens.verify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerifyViewModelImpl @Inject constructor(
    private val direction : VerifyContract.Direction
) : VerifyContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(VerifyContract.UIState())

    override fun onEventDispatcher(intent: VerifyContract.Intent) {
        when (intent) {
            is VerifyContract.Intent.OpenPinCode -> {
                viewModelScope.launch { direction.moveToPinCode() }
            }
            is VerifyContract.Intent.MoveBack -> {
                viewModelScope.launch { direction.moveBack() }
            }
        }
    }
}