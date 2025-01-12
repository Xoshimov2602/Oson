package uz.com.oson.domain.usecase.transfer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.com.oson.data.repository.transfer.TransferRepository
import uz.com.oson.domain.remote.request.transfer.GetCardOwnerRequest
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.response.transfer.HistoryResponse
import javax.inject.Inject

class TransferUseCaseImpl @Inject constructor(
    private val repository  :TransferRepository
) : TransferUseCase {
    override suspend fun getCardOwnerByPan(request: GetCardOwnerRequest): Flow<Result<String>> = flow {
        emit(repository.getCardOwnerByPan(request))
    }.flowOn(Dispatchers.IO).catch{ emit(Result.failure(it)) }

    override suspend fun transfer(request: TransferRequest): Flow<Result<Unit>> = flow {
        emit(repository.transfer(request))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override suspend fun transferVerify(token : String): Flow<Result<Unit>> = flow {
        emit(repository.transferVerify(token))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override suspend fun getHistory(): Flow<Result<HistoryResponse>> = flow {
        emit(repository.getHistory())
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }
}