package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.nio.file.Files.size

@Composable
@ExperimentalFoundationApi
fun BannerView(item: List<BannerResponse>) {
    val pagerState = rememberPagerState(initialPage = 0)

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        Alignment.BottomCenter
    ) {
        HorizontalPager(
           // modifier = Modifier.fillMaxHeight(),
            count = item.size,
            state = pagerState,
            userScrollEnabled = true,
            content = {page ->
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = item[page].fileUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                size(Size.ORIGINAL)
                            }).build()
                    ),
                    contentDescription = "Banner",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        )
        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = item.size,
            activeColor = Color.White,
            inactiveColor = LightSky,
            spacing = 10.dp,
            indicatorWidth = 5.dp,
            indicatorHeight = 5.dp,
            modifier = Modifier.padding(15.dp)
        )
    }
}