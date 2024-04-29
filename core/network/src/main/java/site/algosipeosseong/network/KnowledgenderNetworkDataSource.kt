package site.algosipeosseong.network

import site.algosipeosseong.model.Banners
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.CardnewsDetail
import site.algosipeosseong.model.Category
import site.algosipeosseong.model.Clinic
import site.algosipeosseong.model.ClinicRequest


interface KnowledgenderNetworkDataSource {
    suspend fun getCardnews(): List<Cardnews>

    suspend fun getCardnewsDetail(cardId: Long): CardnewsDetail

    suspend fun getCardnewsByCategory(category: Category): List<CardnewsDetail>

    suspend fun getBanner(): Banners

    suspend fun getClinic(clinicRequest: ClinicRequest, radius: Int): List<Clinic>
}