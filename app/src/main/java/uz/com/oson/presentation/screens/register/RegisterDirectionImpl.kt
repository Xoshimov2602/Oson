package uz.com.oson.presentation.screens.register

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.login.LoginScreen
import uz.com.oson.presentation.screens.verify.VerifyScreen
import javax.inject.Inject

class RegisterDirectionImpl @Inject constructor(
    private val navigator : AppNavigator
) :RegisterContract.Direction{
    override suspend fun moveToVerify() {
        navigator.navigateTo(VerifyScreen(false))
    }

    override suspend fun moveToLogin() {
        navigator.navigateTo(LoginScreen())
    }
}