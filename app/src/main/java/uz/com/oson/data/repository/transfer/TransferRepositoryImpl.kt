package uz.com.oson.data.repository.transfer

import uz.com.oson.data.preference.MyPreference
import uz.com.oson.domain.remote.api.TransferApi
import uz.com.oson.domain.remote.request.transfer.GetCardOwnerRequest
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.request.transfer.TransferVerifyRequest
import uz.com.oson.domain.remote.response.transfer.HistoryResponse
import javax.inject.Inject

class TransferRepositoryImpl @Inject constructor(
    private val api: TransferApi,
    private val preference: MyPreference
) : TransferRepository {
    override suspend fun getCardOwnerByPan(data: GetCardOwnerRequest): Result<String> {
        val result = api.getCardOwnerByPan(data)
        if (result.isSuccessful && result.body() != null) {
            return Result.success(result.body()!!.pan)
        }
        return Result.failure(Exception("Error in getting card owner"))
    }

    override suspend fun transfer(request: TransferRequest): Result<Unit> {
        val result = api.transfer(request)
        if (result.isSuccessful && result.body() != null) {
            preference.tempToken = result.body()!!.token
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in transfer"))
    }

    override suspend fun transferVerify(code: String): Result<Unit> {
        val result = api.transferVerify(TransferVerifyRequest(preference.tempToken, code))
        if (result.isSuccessful && result.body() != null) {
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in verifying transfer"))
    }

    override suspend fun getHistory(): Result<HistoryResponse> {
        val result = api.getHistory()
        if (result.isSuccessful && result.body() != null) {
            return Result.success(result.body()!!)
        }
        return Result.failure(Exception("Error in getting history"))
    }
}