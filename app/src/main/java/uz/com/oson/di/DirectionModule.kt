package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.com.oson.screens.fingerprint.FingerprintContract
import uz.com.oson.screens.fingerprint.FingerprintDirectionImpl
import uz.com.oson.screens.language.LanguageContract
import uz.com.oson.screens.language.LanguageDirectionImpl
import uz.com.oson.screens.login.LoginContract
import uz.com.oson.screens.login.LoginDirectionsImpl
import uz.com.oson.screens.main.MainContract
import uz.com.oson.screens.main.MainDirectionImpl
import uz.com.oson.screens.pincode.PinCodeContract
import uz.com.oson.screens.pincode.PinCodeDirectionImpl
import uz.com.oson.screens.register.RegisterContract
import uz.com.oson.screens.register.RegisterDirectionImpl
import uz.com.oson.screens.verify.VerifyContract
import uz.com.oson.screens.verify.VerifyDirectionImpl

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindsLoginDirection (impl: LoginDirectionsImpl) : LoginContract.Directions

    @Binds
    fun bindsLanguageDirection (impl: LanguageDirectionImpl) : LanguageContract.Direction

    @Binds
    fun bindsFingerprintDirection (impl: FingerprintDirectionImpl) : FingerprintContract.Direction

    @Binds
    fun bindsRegisterDirection (impl: RegisterDirectionImpl) : RegisterContract.Direction

    @Binds
    fun bindsMainDirection (impl: MainDirectionImpl) : MainContract.Direction

    @Binds
    fun bindsPinCodeDirection (impl: PinCodeDirectionImpl) : PinCodeContract.Direction

    @Binds
    fun bindsVerifyDirection (impl : VerifyDirectionImpl) : VerifyContract.Direction
}