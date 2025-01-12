package uz.com.oson.presentation.screens.transfer

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.confirmpayment.ConfirmPaymentContract
import uz.com.oson.presentation.screens.confirmpayment.ConfirmPaymentScreen
import javax.inject.Inject

class TransferDirection @Inject constructor(
    private val navigator: AppNavigator
) : TransferContract.Direction {
    override suspend fun moveToConfirmPayment( items: ConfirmPaymentContract.ConfirmPaymentItems) {
        navigator.navigateTo(ConfirmPaymentScreen(items))
    }
}