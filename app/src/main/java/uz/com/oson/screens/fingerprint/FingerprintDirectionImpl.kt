package uz.com.oson.screens.fingerprint

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.main.MainScreen
import javax.inject.Inject

class FingerprintDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : FingerprintContract.Direction {
    override suspend fun moveToMain() {
        navigator.navigateTo(MainScreen())
    }
}