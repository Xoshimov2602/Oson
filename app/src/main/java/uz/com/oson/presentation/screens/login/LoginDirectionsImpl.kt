package uz.com.oson.presentation.screens.login

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.register.RegisterScreen
import uz.com.oson.presentation.screens.verify.VerifyScreen
import javax.inject.Inject

class LoginDirectionsImpl @Inject constructor(
    private val navigator : AppNavigator
) : LoginContract.Directions {
    override suspend fun moveToSignUp() {
        navigator.navigateTo(RegisterScreen())
    }

    override suspend fun moveToCode() {
        navigator.navigateTo(VerifyScreen(true))
    }
}