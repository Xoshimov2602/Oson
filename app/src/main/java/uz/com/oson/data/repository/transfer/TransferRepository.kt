package uz.com.oson.data.repository.transfer

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Strings
import uz.com.oson.domain.remote.request.transfer.GetCardOwnerRequest
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.request.transfer.TransferVerifyRequest
import uz.com.oson.domain.remote.response.transfer.HistoryResponse

interface TransferRepository {

    suspend fun getCardOwnerByPan(data: GetCardOwnerRequest): Result<String>

    suspend fun transfer(request: TransferRequest): Result<Unit>

    suspend fun transferVerify(code : String): Result<Unit>

    suspend fun getHistory () : Result<HistoryResponse>

}