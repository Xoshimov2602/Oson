package uz.com.oson.presentation.screens.pincode

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.fingerprint.FingerprintScreen
import javax.inject.Inject

class PinCodeDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : PinCodeContract.Direction{
    override suspend fun moveToFingerprint() {
        navigator.navigateTo(FingerprintScreen())
    }
}