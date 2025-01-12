package uz.com.oson.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.com.oson.presentation.screens.addcard.AddCardContract
import uz.com.oson.presentation.screens.addcard.AddCardDirectionImpl
import uz.com.oson.presentation.screens.confirmpayment.ConfirmPaymentContract
import uz.com.oson.presentation.screens.confirmpayment.ConfirmPaymentDirection
import uz.com.oson.presentation.screens.fingerprint.FingerprintContract
import uz.com.oson.presentation.screens.fingerprint.FingerprintDirectionImpl
import uz.com.oson.presentation.screens.language.LanguageContract
import uz.com.oson.presentation.screens.language.LanguageDirectionImpl
import uz.com.oson.presentation.screens.login.LoginContract
import uz.com.oson.presentation.screens.login.LoginDirectionsImpl
import uz.com.oson.presentation.screens.pincode.PinCodeContract
import uz.com.oson.presentation.screens.pincode.PinCodeDirectionImpl
import uz.com.oson.presentation.screens.register.RegisterContract
import uz.com.oson.presentation.screens.register.RegisterDirectionImpl
import uz.com.oson.presentation.screens.splash.SplashContract
import uz.com.oson.presentation.screens.splash.SplashDirection
import uz.com.oson.presentation.screens.transfer.TransferContract
import uz.com.oson.presentation.screens.transfer.TransferDirection
import uz.com.oson.presentation.screens.verify.VerifyContract
import uz.com.oson.presentation.screens.verify.VerifyDirectionImpl
import uz.com.oson.presentation.screens.verify_transfer.VerifyTransferContract
import uz.com.oson.presentation.screens.verify_transfer.VerifyTransferDirection
import uz.com.oson.presentation.tabs.cards.CardsContract
import uz.com.oson.presentation.tabs.cards.CardsDirectionImpl
import uz.com.oson.presentation.tabs.history.HistoryContract
import uz.com.oson.presentation.tabs.history.HistoryDirection
import uz.com.oson.presentation.tabs.main.MainContract
import uz.com.oson.presentation.tabs.main.MainDirectionImpl

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

    @Binds
    fun bindsCardsDirection (impl : CardsDirectionImpl) : CardsContract.Direction

    @Binds
    fun bindsAddCardDirection (impl: AddCardDirectionImpl) : AddCardContract.Direction

    @Binds
    fun bindsConfirmPaymentDirection (impl : ConfirmPaymentDirection) : ConfirmPaymentContract.Direction

    @Binds
    fun bondsTransferDirection (impl : TransferDirection) : TransferContract.Direction

    @Binds
    fun bindsSplashDirection (impl : SplashDirection) : SplashContract.Direction

    @Binds
    fun bindsHistoryDirection (impl : HistoryDirection) : HistoryContract.Direction

    @Binds
    fun bindsVerifyTransferDirection (impl : VerifyTransferDirection) : VerifyTransferContract.Direction
}