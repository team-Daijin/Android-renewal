package site.algosipeosseong.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import site.algosipeosseong.data.repository.CardnewsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsCardnewsRepository(
        cardnewsRepository: CardnewsRepository,
    ): CardnewsRepository
}
