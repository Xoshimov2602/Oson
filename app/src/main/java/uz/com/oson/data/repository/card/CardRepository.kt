package uz.com.oson.data.repository.card

import uz.com.oson.domain.remote.request.auth.LoginRequest
import uz.com.oson.domain.remote.request.card.AddCardRequest
import uz.com.oson.domain.remote.request.card.UpdateCardRequest
import uz.com.oson.domain.remote.response.card.GetCardsResponse

interface CardRepository {

    suspend fun addCard (data : AddCardRequest) : Result<Unit>

    suspend fun getCards () : Result<List<GetCardsResponse>>

    suspend fun updateCards (data : UpdateCardRequest) :Result<Unit>

    suspend fun deleteCards ()  :Result<Unit>
}