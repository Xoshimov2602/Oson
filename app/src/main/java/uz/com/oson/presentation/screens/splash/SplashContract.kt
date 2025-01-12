package uz.com.oson.presentation.screens.splash

interface SplashContract {
    interface Action {
        object OpenNext : Action
    }

    interface Viewmodel {
        fun onEventDispatcher()
    }
    interface Direction {
        suspend fun moveToPinCode()
        suspend fun moveToLanguage()
        suspend fun moveToLogin()
    }
}