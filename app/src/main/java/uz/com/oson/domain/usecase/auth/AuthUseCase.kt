package uz.com.oson.domain.usecase.auth

import kotlinx.coroutines.flow.Flow
import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.remote.request.auth.RegisterRequest

interface AuthUseCase {
    fun registerUser (data : RegisterRequest) : Flow<Result<Unit>>
    fun loginUser (data : LoginRequest) : Flow<Result<Unit>>
    fun verifyLogin (code : String) : Flow<Result<Unit>>
    fun verifyRegister (code : String) : Flow<Result<Unit>>
}