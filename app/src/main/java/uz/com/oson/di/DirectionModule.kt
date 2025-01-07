package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.com.oson.directions.MainDirections
import uz.com.oson.screens.fingerprint.FingerprintContract
import uz.com.oson.screens.fingerprint.FingerprintDirectionImpl
import uz.com.oson.screens.language.LanguageContract
import uz.com.oson.screens.language.LanguageDirectionImpl
import uz.com.oson.screens.login.LoginContract
import uz.com.oson.screens.login.LoginDirectionsImpl
import uz.com.oson.utils.MainContract

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindsMainDirection (impl: MainDirections): MainContract.Directions

    @Binds
    fun bindsLoginDirection (impl: LoginDirectionsImpl) : LoginContract.Directions

    @Binds
    fun bindsLanguageDirection (impl: LanguageDirectionImpl) : LanguageContract.Direction

    @Binds
    fun bindsFingerprintDirection (impl: FingerprintDirectionImpl) : FingerprintContract.Direction
}