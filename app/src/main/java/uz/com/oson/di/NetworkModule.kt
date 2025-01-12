package uz.com.oson.di

import android.content.Context
import android.util.Log
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.api.AuthApi
import uz.com.oson.domain.remote.api.CardApi
import uz.com.oson.domain.remote.api.TransferApi
import uz.com.oson.utils.AuthAuthenticator
import uz.com.oson.utils.TokenAuthenticator
import javax.inject.Qualifier
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkhttp (@ApplicationContext context: Context) : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(context))
        .build()

    @Provides
    @Singleton
    fun providesApiClient (http : OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl("http://195.158.16.140/mobile-bank/")
        .client(http)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    fun providesApi (retrofit: Retrofit) : AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    fun providesTransferApi (retrofit: Retrofit) : TransferApi = retrofit.create(TransferApi::class.java)
}
 */


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val baseUrl = "http://195.158.16.140/mobile-bank/v1/"

    @[Provides Singleton AuthOkhttp]
    fun provideOkHttpForAuth(
        @ApplicationContext context: Context,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(context))
        .build()

    @[Provides Singleton CardOkhttp]
    fun provideOkHttpForCard(
        @ApplicationContext context: Context,
        tokenAuthenticator: AuthAuthenticator,
        preference: MyPreference
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val request =
                it.request().newBuilder().addHeader("Authorization", "Bearer "+preference.accessToken).build()
            it.proceed(request)
        }
        .addInterceptor(ChuckerInterceptor(context))
        .authenticator(tokenAuthenticator)
        .build()

    @[Provides Singleton]
    fun provideAuthApi(
        @AuthOkhttp okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): AuthApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(AuthApi::class.java)

    @[Provides Singleton]
    fun provideCardApi(
        @CardOkhttp okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): CardApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(CardApi::class.java)


    @[Provides Singleton]
    fun provideTransferApi(
        @CardOkhttp okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): TransferApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(TransferApi::class.java)

    @[Provides Singleton]
    fun provideGsonConvertFactory(): GsonConverterFactory = GsonConverterFactory.create()

}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthOkhttp

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CardOkhttp


