package site.algosipeosseong.network

import kotlinx.coroutines.flow.Flow
import site.algosipeosseong.model.Banner
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.CardnewsDetail
import site.algosipeosseong.model.Category
import site.algosipeosseong.model.Clinic
import site.algosipeosseong.model.ClinicRequest


interface KnowledgenderNetworkDataSource {
    suspend fun getCardnews(): Flow<List<Cardnews>>

    suspend fun getCardnewsDetail(cardId: Long): Flow<CardnewsDetail>

    suspend fun getCardnewsByCategory(category: Category): Flow<List<CardnewsDetail>>

    suspend fun getBanner(): Flow<List<Banner>>

    suspend fun getClinic(clinicRequest: ClinicRequest, radius: Int): Flow<List<Clinic>>
}

