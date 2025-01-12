package uz.com.oson.presentation.screens.verify_transfer

import uz.com.oson.navigation.AppNavigator
import javax.inject.Inject

class VerifyTransferDirection @Inject constructor(
    private val navigator: AppNavigator
) : VerifyTransferContract.Direction{
    override suspend fun moveBack() {
        navigator.back()
    }
}