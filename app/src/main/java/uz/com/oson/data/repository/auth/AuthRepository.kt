package uz.com.oson.data.repository.auth

import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.remote.request.auth.RegisterRequest

interface AuthRepository {

    suspend fun loginUser (data : LoginRequest) : Result<Unit>

    suspend fun registerUser (data  : RegisterRequest) : Result<Unit>

    suspend fun verifyLogin (code : String) :Result<Unit>

    suspend fun verifyRegister (code : String) :Result<Unit>

}