package uz.com.oson.data.repository.card

import uz.com.oson.data.preference.MyPreference
import uz.com.oson.di.CardOkhttp
import uz.com.oson.domain.remote.api.CardApi
import uz.com.oson.domain.remote.request.card.AddCardRequest
import uz.com.oson.domain.remote.request.card.UpdateCardRequest
import uz.com.oson.domain.remote.response.card.GetCardsResponse
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val api: CardApi
) : CardRepository {
    override suspend fun addCard(data: AddCardRequest): Result<Unit> {
        val result = api.addCard(data)
        if (result.isSuccessful && result.body() != null) {
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in adding card"))
    }

    override suspend fun getCards(): Result<List<GetCardsResponse>> {
        val result = api.getAllCards()
        if (result.isSuccessful && result.body() != null) {
            return Result.success(result.body()!!)
        }
        return Result.failure(Exception("Error in getting cards"))
    }

    override suspend fun updateCards(data: UpdateCardRequest): Result<Unit> {
        val result = api.updateCard(data)
        if (result.isSuccessful && result.body() != null){
            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in updating card"))
    }

    override suspend fun deleteCards(): Result<Unit> {
        val result = api.deleteCard()
        if (result.isSuccessful && result.body() != null){

            return Result.success(Unit)
        }
        return Result.failure(Exception("Error in deleting card"))
    }
}