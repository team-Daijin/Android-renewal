package site.algosipeosseong.data.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import site.algosipeosseong.data.repository.BannerRepository
import site.algosipeosseong.data.repository.BannerRepositoryImpl
import site.algosipeosseong.data.repository.CardnewsRepository
import site.algosipeosseong.data.repository.CardnewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    internal fun bindsCardnewsRepository(
        cardnewsRepository: CardnewsRepositoryImpl,
    ): CardnewsRepository {
        return cardnewsRepository
    }

    @Provides
    internal fun providessBannerRepository(
        bannerRepository: BannerRepositoryImpl,
    ): BannerRepository {
        return bannerRepository
    }
}
