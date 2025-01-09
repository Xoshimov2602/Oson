package uz.com.oson.screens.main

import uz.com.oson.navigation.AppNavigator
import javax.inject.Inject

class MainDirectionImpl @Inject constructor(
    private val navigator: AppNavigator
) : MainContract.Direction{
}