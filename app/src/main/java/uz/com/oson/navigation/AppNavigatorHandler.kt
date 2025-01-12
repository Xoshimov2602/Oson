package uz.com.oson.navigation

import kotlinx.coroutines.flow.Flow

interface AppNavigatorHandler {
    val navigation: Flow<NavigatorArgs>
}