package uz.com.oson.domain.usecase.card
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.com.oson.data.repository.card.CardRepository
import uz.com.oson.domain.remote.request.card.AddCardRequest
import uz.com.oson.domain.remote.request.card.UpdateCardRequest
import uz.com.oson.domain.remote.response.card.AddCardResponse
import uz.com.oson.domain.remote.response.card.GetCardsResponse
import javax.inject.Inject

class CardUseCaseImpl @Inject constructor(
    private val repository : CardRepository
): CardUseCase {
    override suspend fun addCard(data: AddCardRequest): Flow<Result<Unit>> = flow{
        emit(repository.addCard(data))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override suspend fun getCards(): Flow<Result<List<GetCardsResponse>>> = flow{
        emit(repository.getCards())
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override suspend fun updateCards(data: UpdateCardRequest): Flow<Result<Unit>> = flow{
        emit(repository.updateCards(data))
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }

    override suspend fun deleteCards(): Flow<Result<Unit>> = flow {
        emit(repository.deleteCards())
    }.flowOn(Dispatchers.IO).catch { emit(Result.failure(it)) }
}