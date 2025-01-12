package uz.com.oson.presentation.tabs.cards

import uz.com.oson.navigation.AppNavigator
import uz.com.oson.presentation.screens.addcard.AddCardScreen
import javax.inject.Inject

class CardsDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : CardsContract.Direction {
    override suspend fun moveAddCard() {
        navigator.navigateTo(AddCardScreen())
    }
}