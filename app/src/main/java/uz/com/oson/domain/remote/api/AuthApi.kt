package uz.com.oson.domain.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.remote.request.auth.RegisterRequest
import uz.com.oson.domain.remote.request.auth.VerifyRequest
import uz.com.oson.domain.remote.response.auth.RegisterResponse
import uz.com.oson.domain.remote.response.auth.VerifyResponse
import uz.com.oson.utils.UpdateTokenRequest
import uz.com.oson.utils.UpdateTokenResponse

interface AuthApi {
    @POST("auth/sign-up")
    suspend fun registerUser (@Body user  : RegisterRequest) : Response<RegisterResponse>

    @POST("auth/sign-in/verify")
    suspend fun verifyLogin (@Body request: VerifyRequest) : Response<VerifyResponse>

    @POST("auth/sign-up/verify")
    suspend fun verifyRegister (@Body request: VerifyRequest) : Response<VerifyResponse>

    @POST("auth/sign-in")
    suspend fun loginUser (@Body request: LoginRequest) : Response<RegisterResponse>

    @POST("auth/update-token")
    suspend fun updateRefreshToken (@Body request : UpdateTokenRequest) : Response<UpdateTokenResponse>

}