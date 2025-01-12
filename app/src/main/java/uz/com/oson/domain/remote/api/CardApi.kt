package uz.com.oson.domain.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import uz.com.oson.domain.remote.request.card.AddCardRequest
import uz.com.oson.domain.remote.request.card.UpdateCardRequest
import uz.com.oson.domain.remote.response.card.AddCardResponse
import uz.com.oson.domain.remote.response.card.DeleteCardResponse
import uz.com.oson.domain.remote.response.card.GetCardsResponse
import uz.com.oson.domain.remote.response.card.UpdateCardResponse

interface CardApi {

    @GET("card")
    suspend fun getAllCards() : Response<List<GetCardsResponse>>

    @POST("card")
    suspend fun addCard (@Body request : AddCardRequest) : Response<AddCardResponse>

    @PUT("card")
    suspend fun updateCard (@Body request : UpdateCardRequest) : Response<UpdateCardResponse>

    @DELETE("card/3")
    suspend fun deleteCard () : Response<DeleteCardResponse>

}