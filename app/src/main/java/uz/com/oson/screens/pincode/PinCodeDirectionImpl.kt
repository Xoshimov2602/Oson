package uz.com.oson.screens.pincode

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.fingerprint.FingerprintScreen
import javax.inject.Inject

class PinCodeDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : PinCodeContract.Direction{
    override suspend fun moveToFingerprint() {
        navigator.navigateTo(FingerprintScreen())
    }
}