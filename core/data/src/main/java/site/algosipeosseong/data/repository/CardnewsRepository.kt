package site.algosipeosseong.data.repository

import kotlinx.coroutines.flow.Flow
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.CardnewsDetail
import site.algosipeosseong.model.Category

interface CardnewsRepository {
    suspend fun getCardnews(): Flow<List<Cardnews>>

    suspend fun getCardnewsDetail(cardId: Long): Flow<CardnewsDetail>

    suspend fun getCardnewsByCategory(category: Category): Flow<List<CardnewsDetail>>
}