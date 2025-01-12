package uz.com.oson.presentation.screens.addcard

import uz.com.oson.navigation.AppNavigator
import javax.inject.Inject

class AddCardDirectionImpl
@Inject constructor(
    private val navigator: AppNavigator
) : AddCardContract.Direction {
    override suspend fun moveUp() {
        navigator.back()
    }
}