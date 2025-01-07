package uz.com.oson.directions

import uz.com.oson.screens.pincode.PinCodeScreen
import uz.com.oson.utils.MainContract
import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.code.CodeScreen
import uz.com.oson.screens.language.LanguageScreen
import uz.com.oson.screens.login.LoginScreen
import uz.com.oson.screens.register.RegisterScreen
import javax.inject.Inject

class MainDirections @Inject constructor(
    private val navigator : AppNavigator
) : MainContract.Directions {
    override suspend fun navigateToCode() {
        navigator.navigateTo(CodeScreen())
    }

    override suspend fun navigateToPinCode() {
        navigator.navigateTo(PinCodeScreen())
    }

    override suspend fun navigateToFingerprint() {

    }

    override suspend fun navigateToMain() {

    }

    override suspend fun navigateToLanguage() {
        navigator.navigateTo(LanguageScreen())
    }

    override suspend fun navigateToRegister() {
        navigator.navigateTo(RegisterScreen())
    }

    override suspend fun navigateToLogin() {
        navigator.navigateTo(LoginScreen())
    }
}