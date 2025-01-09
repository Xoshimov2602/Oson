package uz.com.oson.screens.pincode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.com.oson.preference.MyPreference
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModelImpl @Inject constructor(
    private val direction : PinCodeContract.Direction,
//    private val preference : MyPreference
) : ViewModel(), PinCodeContract.ViewModel {
    override val uiState = MutableStateFlow(PinCodeContract.UIState())

    override fun onEventDispatcher(intent: PinCodeContract.Intent) {
        when (intent) {
            is PinCodeContract.Intent.OnClickNext -> {
//                preference.code = intent.code
                viewModelScope.launch { direction.moveToFingerprint() }
            }
        }
    }
}