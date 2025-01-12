package uz.com.oson.presentation.screens.pincode

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.data.preference.MyPreference
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModelImpl @Inject constructor(
    private val direction: PinCodeContract.Direction,
    private val preference: MyPreference
) : ViewModel(), PinCodeContract.ViewModel {
    override val uiState = MutableStateFlow(PinCodeContract.UIState())

    override fun onEventDispatcher(intent: PinCodeContract.Intent) {
        when (intent) {
                    is PinCodeContract.Intent.OnClickNext -> {
                if (preference.code.isEmpty()) {
                    Log.d("opopopopopop", "onEventDispatcher: code is ${intent.code} in code is empty")
                    viewModelScope.launch {
                        direction.moveToFingerprint()
                    }
                    preference.code = intent.code
                } else if (preference.code == intent.code) {
                    Log.d("opopopopopop", "onEventDispatcher: code is ${intent.code} in code is equal")
                    viewModelScope.launch {
                        direction.moveToFingerprint()
                    }
                }
            }
        }
    }
}