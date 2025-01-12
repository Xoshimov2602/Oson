package uz.com.oson.utils

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.api.AuthApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TokenAuthenticator @Inject constructor(
    private val localStorage: MyPreference,
    private val authApi: AuthApi,
) : Authenticator {
    private val header = "Authorization"

    override fun authenticate(route: Route?, response: Response): Request {
        synchronized(this) {
            val sessionData = if (isRefreshNeeded(response)) {
                runBlocking { getUpdatedSessionData() }
            } else {
                getExistingToken()
            }

            return response.request.newBuilder()
                .header(header, "Bearer ${sessionData.accessToken}")
                .build()
        }
    }

    private fun isRefreshNeeded(response: Response): Boolean {
        return (response.code == 401)
    }

    private fun getExistingToken(): UpdateTokenResponse = UpdateTokenResponse(
        accessToken = localStorage.accessToken,
        refreshToken = localStorage.refreshToken
    )

    private suspend fun getUpdatedSessionData(): UpdateTokenResponse {
        val updateTokenRequest =
            authApi.updateRefreshToken(UpdateTokenRequest(refreshToken = localStorage.refreshToken))
        return if (updateTokenRequest.isSuccessful && updateTokenRequest.body() != null) {
            localStorage.accessToken = updateTokenRequest.body()!!.accessToken
            localStorage.refreshToken = updateTokenRequest.body()!!.refreshToken
            updateTokenRequest.body()!!
        } else
            UpdateTokenResponse(
                accessToken = localStorage.accessToken,
                refreshToken = localStorage.refreshToken
            )
    }
}

data class UpdateTokenResponse(
    @SerializedName("refresh-token") val refreshToken: String,
    @SerializedName("access-token") val accessToken: String
)

data class UpdateTokenRequest(@SerializedName("refresh-token") val refreshToken: String)
