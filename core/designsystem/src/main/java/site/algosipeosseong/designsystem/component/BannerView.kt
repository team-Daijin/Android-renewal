@file:OptIn(ExperimentalFoundationApi::class)

package site.algosipeosseong.designsystem.component

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType
import site.algosipeosseong.designsystem.R
import site.algosipeosseong.model.BannerResponses

@Composable
@ExperimentalFoundationApi
fun BannerView(item: List<BannerResponses>, context: Context) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { item.size })

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        Alignment.BottomCenter
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true,
            pageContent = { page ->
                AsyncImage(
                    model = item[page].banner,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                    )
            }

        )
        DotsIndicator(
            dotCount = item.size,
            type = ShiftIndicatorType(dotsGraphic = DotGraphic(color = Color.White)),
            pagerState = pagerState
        )
    }
}

@Composable
@Preview(showBackground = false)
private fun Asdf() {
    BannerView(
        item = listOf(
            BannerResponses(
                "https://developer.android.com/static/develop/ui/compose/images/layouts/pager/contentpadding-horizontal.png",
                ""
            ),
            BannerResponses(
                "",
                ""
            ),
            BannerResponses(
                "",
                ""
            )
        ),
        context = LocalContext.current
    )
}