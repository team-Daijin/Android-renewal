@file:OptIn(ExperimentalFoundationApi::class)

package site.algosipeosseong.designsystem.component

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType
import site.algosipeosseong.model.Banner

@Composable
@ExperimentalFoundationApi
fun BannerView(item: List<Banner>, context: Context) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { item.size })

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,
            pageContent = { page ->
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = item[page].image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

        )
        DotsIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            dotCount = item.size,
            type = ShiftIndicatorType(
                dotsGraphic = DotGraphic(
                    size = 5.dp,
                    color = Color.White
                )
            ),
            pagerState = pagerState
        )
    }
}
