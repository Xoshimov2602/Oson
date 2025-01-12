package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.com.oson.navigation.AppNavigator
import uz.com.oson.navigation.AppNavigatorDispatcher
import uz.com.oson.navigation.AppNavigatorHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun appNavigator(impl: AppNavigatorDispatcher): AppNavigator

    @Binds
    fun appNavigatorHandler(impl: AppNavigatorDispatcher): AppNavigatorHandler
}