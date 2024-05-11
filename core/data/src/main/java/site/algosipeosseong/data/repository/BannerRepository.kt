package site.algosipeosseong.data.repository

import kotlinx.coroutines.flow.Flow
import site.algosipeosseong.model.Banner

interface BannerRepository {
    suspend fun getBanner(): Flow<List<Banner>>
}