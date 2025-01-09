package uz.com.oson.screens.login

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.verify.VerifyScreen
import uz.com.oson.screens.register.RegisterScreen
import javax.inject.Inject

class LoginDirectionsImpl @Inject constructor(
    private val navigator : AppNavigator
) : LoginContract.Directions {
    override suspend fun moveToSignUp() {
        navigator.navigateTo(RegisterScreen())
    }

    override suspend fun moveToCode() {
        navigator.navigateTo(VerifyScreen())
    }
}