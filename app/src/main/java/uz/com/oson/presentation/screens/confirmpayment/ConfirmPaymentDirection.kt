package uz.com.oson.presentation.screens.confirmpayment

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.verify_transfer.VerifyTransferScreen
import javax.inject.Inject

class ConfirmPaymentDirection @Inject constructor(
    private val navigator : AppNavigator
): ConfirmPaymentContract.Direction {

    override suspend fun moveBack() {
        navigator.back()
    }

    override suspend fun moveNext() {
        navigator.navigateTo(VerifyTransferScreen())
    }

}