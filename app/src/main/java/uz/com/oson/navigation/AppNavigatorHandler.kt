package uz.gita.lesson56.navigation

import kotlinx.coroutines.flow.Flow

interface AppNavigatorHandler {
    val navigation: Flow<NavigatorArgs>
}