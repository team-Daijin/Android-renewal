package site.algosipeosseong.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.CardnewsDetail
import site.algosipeosseong.model.Category
import site.algosipeosseong.network.KnowledgenderNetworkDataSource
import javax.inject.Inject

internal class CardnewsRepositoryImpl @Inject constructor(
    private val network: KnowledgenderNetworkDataSource
) : CardnewsRepository {
    override suspend fun getCardnews(): Flow<List<Cardnews>> =  network.getCardnews()


    override suspend fun getCardnewsDetail(cardId: Long): Flow<CardnewsDetail> = network.getCardnewsDetail(cardId = cardId)

    override suspend fun getCardnewsByCategory(category: Category): Flow<List<CardnewsDetail>> = network.getCardnewsByCategory(category = category)

}