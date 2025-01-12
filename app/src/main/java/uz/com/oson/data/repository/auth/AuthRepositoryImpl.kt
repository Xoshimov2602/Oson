package uz.com.oson.data.repository.auth

import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.api.AuthApi
import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.remote.request.auth.RegisterRequest
import uz.com.oson.domain.remote.request.auth.VerifyRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val preference: MyPreference,
    private val api: AuthApi
) : AuthRepository {

    override suspend fun loginUser(data: LoginRequest): Result<Unit> {
        val result = api.loginUser(data)
        if (result.isSuccessful && result.body() != null) {
            preference.tempToken = result.body()!!.token
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in login"))
    }

    override suspend fun registerUser(data: RegisterRequest): Result<Unit> {
        val result = api.registerUser(data)
        if (result.isSuccessful && result.body() != null) {
            preference.tempToken = result.body()!!.token
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in register"))
    }

    override suspend fun verifyLogin(code: String): Result<Unit> {
        val result = api.verifyLogin(VerifyRequest(preference.tempToken, code))
        if (result.isSuccessful && result.body() != null) {
            preference.accessToken = result.body()!!.accessToken
            preference.refreshToken = result.body()!!.refreshToken
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in verify login"))
    }

    override suspend fun verifyRegister(code: String): Result<Unit> {
        val result = api.verifyRegister(VerifyRequest(preference.tempToken, code))
        if (result.isSuccessful && result.body() != null) {
            preference.accessToken = result.body()!!.accessToken
            preference.refreshToken = result.body()!!.refreshToken
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in verify register"))
    }
}