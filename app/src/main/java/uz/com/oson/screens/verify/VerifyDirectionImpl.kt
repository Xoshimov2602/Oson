package uz.com.oson.screens.verify

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.pincode.PinCodeScreen
import javax.inject.Inject

class VerifyDirectionImpl @Inject constructor(
    private val navigator : AppNavigator
) : VerifyContract.Direction {
    override suspend fun moveToPinCode() {
        navigator.navigateTo(PinCodeScreen())
    }

    override suspend fun moveBack() {
        navigator.back()
    }
}