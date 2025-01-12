package uz.com.oson.presentation.screens.fingerprint

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.tabs.home.MainScreen
import uz.com.oson.presentation.tabs.main.MainTab
import javax.inject.Inject

class FingerprintDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : FingerprintContract.Direction {
    override suspend fun moveToMain() {
        navigator.navigateTo(MainScreen())
    }
}