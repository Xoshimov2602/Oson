package uz.com.oson.domain.usecase.card

import kotlinx.coroutines.flow.Flow
import uz.com.oson.domain.remote.request.card.AddCardRequest
import uz.com.oson.domain.remote.request.card.UpdateCardRequest
import uz.com.oson.domain.remote.response.card.AddCardResponse
import uz.com.oson.domain.remote.response.card.GetCardsResponse

interface CardUseCase {
    suspend fun addCard (data : AddCardRequest) : Flow<Result<Unit>>
    suspend fun getCards () :  Flow<Result<List<GetCardsResponse>>>
    suspend fun updateCards (data : UpdateCardRequest) : Flow<Result<Unit>>
    suspend fun deleteCards ()  : Flow<Result<Unit>>
}