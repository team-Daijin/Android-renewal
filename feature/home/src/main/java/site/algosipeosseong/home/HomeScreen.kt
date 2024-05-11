@file:OptIn(ExperimentalFoundationApi::class)

package site.algosipeosseong.home

import android.content.Context
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import site.algosipeosseong.common.CARDNEWS
import site.algosipeosseong.designsystem.component.BannerView
import site.algosipeosseong.designsystem.component.CardNewsItemView
import site.algosipeosseong.designsystem.component.CategoryIcon
import site.algosipeosseong.designsystem.component.HomeTitleText
import site.algosipeosseong.model.Banner
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.Category

@Composable
internal fun HomeRoute(
    positionChecked: MutableState<Boolean>,
    onNavigationRequested: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Log.d("euya","uistatebefore")
    val uiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    Log.d("euya","uistateafter")
    when (uiState) {
        is HomeUiState.Error -> LinearProgressIndicator()
        HomeUiState.Loading -> CircularProgressIndicator()
        is HomeUiState.Success -> HomeScreen(
            card = (uiState as HomeUiState.Success).cards,
            banner = (uiState as HomeUiState.Success).banner,
            positionChecked = positionChecked,
            onNavigationRequested = onNavigationRequested
        )
    }
}

@Composable
fun HomeScreen(
    card: List<Cardnews>,
    banner: List<Banner>,
    positionChecked: MutableState<Boolean>,
    onNavigationRequested: (String) -> Unit
) {


    val scrollState = rememberScrollState()
    val context = LocalContext.current


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Header(banner, context)
        Spacer(modifier = Modifier.height(28.dp))
        Body(card, onNavigationRequested) {
            positionChecked.value = scrollState.value >= it.value
        }
    }

}


@Composable
private fun Header(banner: List<Banner>, context: Context) {
    BannerView(
        item = banner,
        context = context
    )
}

@Composable
private fun Body(
    card: List<Cardnews>,
    onNavigationRequested: (String) -> Unit,
    position: (Dp) -> Unit
) {
    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }
    val painters = listOf(
        mapOf(
            Pair("painter", R.drawable.heart),
            Pair("text", "마음"),
            Pair("string", "$CARDNEWS/${Category.HEART.str}")
        ),
        mapOf(
            Pair("painter", R.drawable.body),
            Pair("text", "신체"),
            Pair("string", "$CARDNEWS/${Category.BODY.str}")
        ),
        mapOf(
            Pair("painter", R.drawable.relationship),
            Pair("text", "관계"),
            Pair("string", "$CARDNEWS/${Category.RELATION.str}")
        ),
        mapOf(
            Pair("painter", R.drawable.crime),
            Pair("text", "폭력"),
            Pair("string", "$CARDNEWS/${Category.VIOLENCE.str}")
        ),
        mapOf(
            Pair("painter", R.drawable.equality),
            Pair("text", "평등"),
            Pair("string", "$CARDNEWS/${Category.EQUALITY.str}")
        ),
    )
    val homeCardSet = mapOf(
        Pair("마음",Pair("마음 상담소로 오세요","내 안에 숨어있는 마음상담소로 초대합니다!")),
        Pair("신체",Pair("나만 몰랐던 나의 몸","나조차도 모르고 있었던 나의 몸 속 비밀")),
        Pair("관계",Pair("너와 나의 연결고리","즐겁고 행복한 우리의 관계를 건강하게 유지하는 법")),
        Pair("폭력",Pair("나를 확실하게 지키는 법","폭력으로부터 나를 올바른 방법으로 보호해봅시다")),
        Pair("평등",Pair("세상에 같은 사람은 없다","차이는 틀린 것이 아닌 다른 것!"))
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                columnHeightDp = it.positionInParent().y.dp - 200.dp
                position(columnHeightDp)
            }, horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        painters.forEach {
            CategoryIcon(
                painter = it["painter"] as Int,
                text = it["text"] as String,
                onNavigateTo = onNavigationRequested,
                string = it["string"] as String
            )
        }

    }
    Spacer(modifier = Modifier.height(28.dp))
    card.forEach { cardnews ->
        HomeTitleText(text = homeCardSet[cardnews.category]!!.first, subText = homeCardSet[cardnews.category]!!.second)
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(start = 16.dp)
        ) {
            items(cardnews.cards) {
                CardNewsItemView(
                    category = cardnews.category,
                    item = it,
                    onNavigationRequested = onNavigationRequested
                )

            }
        }
    }
}