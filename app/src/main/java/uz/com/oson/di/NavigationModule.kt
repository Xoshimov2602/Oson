package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.com.oson.navigation.AppNavigator
import uz.gita.lesson56.navigation.AppNavigatorDispatcher
import uz.gita.lesson56.navigation.AppNavigatorHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun appNavigator(impl: AppNavigatorDispatcher): AppNavigator

    @Binds
    fun appNavigatorHandler(impl: AppNavigatorDispatcher): AppNavigatorHandler
}