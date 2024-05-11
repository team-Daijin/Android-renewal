package site.algosipeosseong.domain.usecase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import site.algosipeosseong.data.repository.CardnewsRepository
import site.algosipeosseong.model.Cardnews
import javax.inject.Inject

class GetCardnewsUseCase @Inject constructor(
    private val cardnewsRepository: CardnewsRepository
) {
    suspend operator fun invoke(): Flow<List<Cardnews>> = cardnewsRepository.getCardnews()
}