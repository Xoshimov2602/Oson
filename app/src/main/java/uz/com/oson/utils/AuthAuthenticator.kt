package uz.com.oson.utils

import android.util.Log
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import uz.com.oson.data.preference.MyPreference
import uz.com.oson.data.repository.auth.AuthRepository
import uz.com.oson.domain.remote.api.AuthApi
import javax.inject.Inject


class AuthAuthenticator @Inject constructor(
    private val localStorage: MyPreference,
    private val oAuthApi: AuthApi,
    private val appRepository: AuthRepository,
) : Authenticator {

    companion object {
        const val HEADER_AUTHORIZATION = "Authorization"
        const val TOKEN_TYPE = "Bearer"
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val currentToken = runBlocking { localStorage.accessToken }
        synchronized(this) {
            val updatedToken = runBlocking { localStorage.accessToken }
            val token = if (currentToken != updatedToken) updatedToken else {
                val newSessionResponse = runBlocking { oAuthApi.updateRefreshToken(UpdateTokenRequest(localStorage.refreshToken)) }
                if (newSessionResponse.isSuccessful && newSessionResponse.body() != null) {
                    newSessionResponse.body()?.let { body ->
                        try{
                            runBlocking {
                                localStorage.accessToken = body.accessToken
                                localStorage.refreshToken = body.refreshToken
                            }
                        }catch (e:Exception){
                            Log.d("III", "authenticate: ${e.message}")
                        }
                        body.accessToken
                    }
                } else null
            }
            if (token == null) {
                runBlocking {
//                    appRepository.clearUserData()
                }
            }
            return if (token != null) response.request.newBuilder()
                .header(HEADER_AUTHORIZATION, "$TOKEN_TYPE $token")
                .build() else null
        }
    }
}