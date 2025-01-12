package uz.com.oson.presentation.tabs.main

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.transfer.TransferScreen
import javax.inject.Inject

class MainDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : MainContract.Direction {
    override suspend fun moveTransfer() {
        navigator.navigateTo(TransferScreen())
    }
}