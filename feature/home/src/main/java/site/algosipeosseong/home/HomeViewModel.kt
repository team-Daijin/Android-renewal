package site.algosipeosseong.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import site.algosipeosseong.domain.usecase.GetBannerUseCase
import site.algosipeosseong.domain.usecase.GetCardnewsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCardnewsUseCase: GetCardnewsUseCase,
    private val getBannerUseCase: GetBannerUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val homeUiState get() = _homeUiState.asStateFlow()


    init {
        Log.d("dksl", _homeUiState.value.toString())
        fetchCardnews()
        Log.d("dksl", _homeUiState.value.toString())
    }

    private fun fetchCardnews() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                getCardnewsUseCase().collect {
                    Log.d("dksl", it.toString())
                }
                combine(getCardnewsUseCase(), getBannerUseCase()) { cardnews, banners ->
                    Log.d("euya", "카드뉴스 불러오기 성공")
                    _homeUiState.value = HomeUiState.Success(cards = cardnews, banner = banners)
                }
            }.onFailure {
                Log.d("euya", "카드뉴스 불러오기 실패")
                Log.d("error", it.message.toString())
                when(it.message) {
                    "dkssud" -> _homeUiState.value = HomeUiState.Error("dkssud")
                    else -> _homeUiState.value = HomeUiState.Error("서버 연결 에러 ㅠ")
                }
            }
        }
    }
}