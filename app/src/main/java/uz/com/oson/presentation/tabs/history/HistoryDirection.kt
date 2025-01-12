package uz.com.oson.presentation.tabs.history

import uz.com.oson.navigation.AppNavigator
import javax.inject.Inject

class HistoryDirection @Inject constructor(
    private val navigator: AppNavigator
)  :HistoryContract.Direction {

}