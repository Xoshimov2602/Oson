package uz.com.oson.presentation.screens.language

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.login.LoginScreen
import javax.inject.Inject

class LanguageDirectionImpl @Inject constructor(
    private val navigator : AppNavigator
) : LanguageContract.Direction {
    override suspend fun moveToLogin() {
        navigator.navigateTo(LoginScreen())
    }
}