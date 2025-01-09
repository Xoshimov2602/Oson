package uz.com.oson.screens.register

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.screens.login.LoginScreen
import uz.com.oson.screens.verify.VerifyScreen
import javax.inject.Inject

class RegisterDirectionImpl @Inject constructor(
    private val navigator : AppNavigator
) :RegisterContract.Direction{
    override suspend fun moveToVerify() {
        navigator.navigateTo(VerifyScreen())
    }

    override suspend fun moveToLogin() {
        navigator.navigateTo(LoginScreen())
    }
}