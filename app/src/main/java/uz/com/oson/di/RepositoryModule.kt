package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.com.oson.data.repository.auth.AuthRepository
import uz.com.oson.data.repository.auth.AuthRepositoryImpl
import uz.com.oson.data.repository.card.CardRepository
import uz.com.oson.data.repository.card.CardRepositoryImpl
import uz.com.oson.data.repository.transfer.TransferRepository
import uz.com.oson.data.repository.transfer.TransferRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsAuthRepository (impl : AuthRepositoryImpl) : AuthRepository

    @Binds
    @Singleton
    fun bindsCardsRepository (impl: CardRepositoryImpl) : CardRepository

    @Binds
    @Singleton
    fun bindsTransferRepository  (impl : TransferRepositoryImpl) : TransferRepository
}