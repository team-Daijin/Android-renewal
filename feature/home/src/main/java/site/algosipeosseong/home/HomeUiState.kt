package site.algosipeosseong.home

import site.algosipeosseong.model.Banner
import site.algosipeosseong.model.Cardnews

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val cards: List<Cardnews>, val banner: List<Banner>) : HomeUiState
    data class Error(val message:String) : HomeUiState
}
