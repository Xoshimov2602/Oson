package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.com.oson.domain.usecase.auth.AuthUseCase
import uz.com.oson.domain.usecase.auth.AuthUseCaseImpl
import uz.com.oson.domain.usecase.card.CardUseCase
import uz.com.oson.domain.usecase.card.CardUseCaseImpl
import uz.com.oson.domain.usecase.transfer.TransferUseCase
import uz.com.oson.domain.usecase.transfer.TransferUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsRegisterUseCase (impl : AuthUseCaseImpl) : AuthUseCase

    @Binds
    fun bindsCardsUseCase (impl : CardUseCaseImpl) : CardUseCase

    @Binds
    fun bindsTransferUseCase (impl: TransferUseCaseImpl) : TransferUseCase

}