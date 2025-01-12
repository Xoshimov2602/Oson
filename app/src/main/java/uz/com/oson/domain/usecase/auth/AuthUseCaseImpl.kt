package uz.com.oson.domain.usecase.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.com.oson.data.repository.auth.AuthRepository
import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.remote.request.auth.RegisterRequest
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(
    private val repository : AuthRepository
) : AuthUseCase {

    override fun registerUser(data: RegisterRequest): Flow<Result<Unit>> = flow {
        emit(repository.registerUser(data))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override fun loginUser(data: LoginRequest): Flow<Result<Unit>> = flow {
        emit(repository.loginUser(data))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override fun verifyRegister(code : String): Flow<Result<Unit>> = flow{
        emit(repository.verifyRegister(code))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override fun verifyLogin(code: String): Flow<Result<Unit>> = flow{
        emit(repository.verifyLogin(code))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }
}