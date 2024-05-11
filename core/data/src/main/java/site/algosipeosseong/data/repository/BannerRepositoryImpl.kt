package site.algosipeosseong.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import site.algosipeosseong.model.Banner
import site.algosipeosseong.network.KnowledgenderNetworkDataSource
import javax.inject.Inject

internal class BannerRepositoryImpl @Inject constructor(
    private val network: KnowledgenderNetworkDataSource
) : BannerRepository {
    override suspend fun getBanner(): Flow<List<Banner>> = flow {
        network.getBanner()
    }

}