package uz.com.oson.screens.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.com.oson.preference.MyPreference
import javax.inject.Inject

@HiltViewModel
class LanguageViewModelImpl @Inject constructor(
    private val direction: LanguageContract.Direction,
//    private val preference: MyPreference
) : ViewModel(), LanguageContract.ViewModel {
    override val uiState = MutableStateFlow(LanguageContract.UIState())

    override fun onEventDispatcher(intent: LanguageContract.Intent) {
        when (intent) {
            is LanguageContract.Intent.OnClickNext -> {
//                preference.chosenLanguage = intent.language
                viewModelScope.launch { direction.moveToLogin() }
            }
        }
    }
}