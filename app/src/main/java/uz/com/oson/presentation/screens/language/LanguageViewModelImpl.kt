package uz.com.oson.presentation.screens.language

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.com.oson.data.preference.MyPreference
import javax.inject.Inject

@HiltViewModel
class LanguageViewModelImpl @Inject constructor(
    private val direction: LanguageContract.Direction,
    private val preference: MyPreference
) : ViewModel(), LanguageContract.ViewModel {
    override val state: MutableState<LanguageContract.UIState> =
        mutableStateOf(LanguageContract.UIState())

    override fun onEventDispatcher(intent: LanguageContract.Intent) {
        when (intent) {
            is LanguageContract.Intent.OnClickNext -> {
                preference.chosenLanguage = intent.language
                viewModelScope.launch { direction.moveToLogin() }
            }
            is LanguageContract.Intent.ClickCheckBox -> {
                state.value = state.value.copy(isChecked = intent.checked)
            }
        }
    }
}