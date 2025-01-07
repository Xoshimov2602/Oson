package uz.com.oson.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.com.oson.screens.main.MainScreen
import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.fingerprint.FingerprintViewmodel
import javax.inject.Inject

@HiltViewModel
class FingerprintViewModelImpl @Inject constructor(
    private val navigator : AppNavigator
): ViewModel(), FingerprintViewmodel {

    override fun openMain() {
        viewModelScope.launch { navigator.navigateTo(MainScreen()) }
    }
}