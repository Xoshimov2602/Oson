package uz.com.oson.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val direction : MainContract.Direction
) : ViewModel(), MainContract.ViewModel{
    override val uiState = MutableStateFlow(MainContract.UIState())

    override fun onEventDispatcher(intent: MainContract.Intent) {

    }
}