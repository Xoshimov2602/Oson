package uz.com.oson.presentation.screens.splash

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.language.LanguageScreen
import uz.com.oson.presentation.screens.login.LoginScreen
import uz.com.oson.presentation.screens.pincode.PinCodeScreen
import javax.inject.Inject

class SplashDirection @Inject constructor(
    private val navigator: AppNavigator
) : SplashContract.Direction{
    override suspend fun moveToPinCode() {
        navigator.navigateTo(PinCodeScreen())
        navigator.replaceAll(PinCodeScreen())
    }

    override suspend fun moveToLanguage() {
        navigator.navigateTo(LanguageScreen())
        navigator.replaceAll(LanguageScreen())
    }

    override suspend fun moveToLogin() {
        navigator.navigateTo(LoginScreen())
        navigator.replaceAll(LoginScreen())
    }
}