package site.algosipeosseong.domain.usecase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import site.algosipeosseong.data.repository.BannerRepository
import site.algosipeosseong.model.Banner
import javax.inject.Inject

class GetBannerUseCase @Inject constructor(
    private val bannerRepository: BannerRepository
) {
    suspend operator fun invoke(): Flow<List<Banner>> = bannerRepository.getBanner()
}