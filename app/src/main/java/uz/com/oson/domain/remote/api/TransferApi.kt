package uz.com.oson.domain.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uz.com.oson.domain.remote.request.transfer.GetCardOwnerRequest
import uz.com.oson.domain.remote.request.transfer.TransferRequest
import uz.com.oson.domain.remote.request.transfer.TransferVerifyRequest
import uz.com.oson.domain.remote.response.transfer.HistoryResponse
import uz.com.oson.domain.remote.response.transfer.TransferResponse
import uz.com.oson.domain.remote.response.transfer.TransferVerifyResponse

interface TransferApi {

    @POST("transfer/card-owner")
    suspend fun getCardOwnerByPan(@Body request: GetCardOwnerRequest) : Response<GetCardOwnerRequest>

    @POST("transfer/transfer")
    suspend fun transfer (@Body request : TransferRequest) : Response<TransferResponse>

    @POST("transfer/transfer/verify")
    suspend fun transferVerify (@Body request: TransferVerifyRequest) : Response<TransferVerifyResponse>

    @GET("transfer/history?size=6&current-page=1")
    suspend fun getHistory () : Response<HistoryResponse>

}