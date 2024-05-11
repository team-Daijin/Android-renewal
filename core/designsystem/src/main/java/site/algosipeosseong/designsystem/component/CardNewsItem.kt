package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import site.algosipeosseong.common.CARDNEWSDETAIL
import site.algosipeosseong.common.dpToSp
import site.algosipeosseong.designsystem.theme.BasePurple
import site.algosipeosseong.designsystem.theme.DarkPurple
import site.algosipeosseong.designsystem.theme.DarkestBlack
import site.algosipeosseong.designsystem.theme.pretendard
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.Cards

@Composable
fun CardNewsItemView(
    modifier: Modifier = Modifier,
    category: String,
    item: Cards,
    onNavigationRequested: (String) -> Unit
) {
    Column(
        modifier = modifier
            .width(165.dp)
        //.clickable { onNavigationRequested(CARDNEWSDETAIL + "/" + item.) }
    ) {
        Box(modifier = Modifier.clip(RoundedCornerShape(topStart = 10.dp))) {
            AsyncImage(
                model = item.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 4.dp)
                    .size(width = 30.dp, height = 14.dp)
                    .background(
                        Color.LightGray.copy(alpha = 0.2f)
                    )
                    .align(Alignment.BottomStart)

                    .border(width = 0.6.dp, color = BasePurple),
                contentAlignment = Alignment.Center
            ) {
                BaseText(
                    text = category, color = DarkPurple, style = TextStyle(
                        fontFamily = pretendard, fontSize = dpToSp(
                            dp = 8.dp
                        ), fontWeight = FontWeight.Medium
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.title,
            color = DarkestBlack,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = dpToSp(dp = 14.dp),
            textAlign = TextAlign.Left
        )
    }
}
