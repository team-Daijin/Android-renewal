@file:OptIn(ExperimentalFoundationApi::class)

package site.algosipeosseong.home

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import site.algosipeosseong.common.CARDNEWS
import site.algosipeosseong.designsystem.component.BannerView
import site.algosipeosseong.designsystem.component.CategoryIcon
import site.algosipeosseong.designsystem.theme.KnowledgenderTheme
import site.algosipeosseong.model.BannerResponses
import site.algosipeosseong.model.Category


@Composable
internal fun HomeRoute(
    positionChecked: MutableState<Boolean>,
    onNavigationRequested: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        positionChecked = positionChecked,
        onNavigationRequested = onNavigationRequested
    )
}
@Composable
fun HomeScreen(
    positionChecked: MutableState<Boolean>,
    onNavigationRequested: (String) -> Unit
) {

    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(Modifier.fillMaxSize().verticalScroll(scrollState)) {
        Header(context)
        Spacer(modifier = Modifier.height(28.dp))
        Body(onNavigationRequested) {
            positionChecked.value = scrollState.value >= it.value
        }
    }

}


@Composable
private fun Header(context: Context) {
    BannerView(
        item = listOf(
            BannerResponses(
                "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
                ""
            ),
            BannerResponses(
                "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
                ""
            )
        ),
        context = context
    )
}

@Composable
private fun Body(onNavigationRequested: (String) -> Unit, position: (Dp) -> Unit) {
    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                columnHeightDp = it.positionInParent().y.dp - 200.dp
                position(columnHeightDp)
            }, horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CategoryIcon(
            painter = R.drawable.heart,
            text = "마음",
            onNavigateTo = { onNavigationRequested("$CARDNEWS/${Category.HEART.str}") })
        CategoryIcon(
            painter = R.drawable.body,
            text = "신체",
            onNavigateTo = { onNavigationRequested("$CARDNEWS/${Category.BODY.str}") })
        CategoryIcon(
            painter = R.drawable.relationship,
            text = "관계",
            onNavigateTo = { onNavigationRequested("$CARDNEWS/${Category.RELATION.str}") })
        CategoryIcon(
            painter = R.drawable.crime,
            text = "폭력",
            onNavigateTo = { onNavigationRequested("$CARDNEWS/${Category.VIOLENCE.str}") })
        CategoryIcon(
            painter = R.drawable.equality,
            text = "평등",
            onNavigateTo = { onNavigationRequested("$CARDNEWS/${Category.EQUALITY.str}") })
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KnowledgenderTheme {
        HomeScreen(
            positionChecked = remember { mutableStateOf(false) }
        ) {}
    }
}
