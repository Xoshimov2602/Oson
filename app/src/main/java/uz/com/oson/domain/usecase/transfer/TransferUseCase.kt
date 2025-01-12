package uz.com.oson.domain.usecase.transfer

import kotlinx.coroutines.flow.Flow
import uz.com.oson.domain.remote.request.transfer.GetCardOwnerRequest
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.request.transfer.TransferVerifyRequest
import uz.com.oson.domain.remote.response.transfer.HistoryResponse

interface TransferUseCase {

    suspend fun getCardOwnerByPan (request : GetCardOwnerRequest) : Flow<Result<String>>

    suspend fun transfer (request : TransferRequest) : Flow<Result<Unit>>

    suspend fun transferVerify (token : String) : Flow<Result<Unit>>

    suspend fun getHistory () : Flow<Result<HistoryResponse>>

}