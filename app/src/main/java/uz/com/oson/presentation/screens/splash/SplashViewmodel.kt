package uz.com.oson.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.com.oson.data.preference.MyPreference
import javax.inject.Inject

@HiltViewModel
class SplashViewmodel @Inject constructor(
    private val direction: SplashContract.Direction,
    private val preference: MyPreference
) : SplashContract.Viewmodel, ViewModel() {

    override fun onEventDispatcher() {
        if (preference.isRegistered && preference.chosenLanguage.isNotEmpty()) {
            viewModelScope.launch {
                delay(2000)
                direction.moveToPinCode()
            }
        } else if (!preference.isRegistered && preference.chosenLanguage.isNotEmpty()) {
            viewModelScope.launch {
                delay(2000)
                direction.moveToLogin()
            }
        } else {
            viewModelScope.launch {
                delay(2000)
                direction.moveToLanguage()
            }
        }
    }
}