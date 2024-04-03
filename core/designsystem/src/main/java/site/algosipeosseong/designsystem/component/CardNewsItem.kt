package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import site.algosipeosseong.common.CARDNEWSDETAIL
import site.algosipeosseong.designsystem.theme.BasePurple
import site.algosipeosseong.designsystem.theme.DarkestBlack

//@Composable
//fun CardNewsItemView(
//    modifier: Modifier = Modifier,
//    item: CardResponse,
//    onNavigationRequested: (String) -> Unit
//) {
//    Column(modifier = modifier
//        .width(165.dp)
//        .padding(horizontal = 8.dp)
//        .clickable { onNavigationRequested(CARDNEWSDETAIL + "/" + item.id) }
//    ) {
//        Surface(shape = RoundedCornerShape(8.dp)) {
//            AsyncImage(
//                model = item.thumbnail,
//                contentDescription = null,
//                modifier = Modifier
//                    .height(100.dp)
//                    .fillMaxWidth(),
//                contentScale = ContentScale.Crop
//            )
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = item.title,
//            color = DarkestBlack,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            fontSize = 16.sp,
//            textAlign = TextAlign.Left
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Box(
//            modifier = Modifier.border(
//                width = 1.dp,
//                color = BasePurple,
//                shape = CircleShape
//            )
//        ) {
//            Text(
//                modifier = Modifier.padding(25.dp, 5.dp, 25.dp, 5.dp),
//                text = item.category,
//                style = TextStyle(
//                    fontSize = 15.sp,
//                    color = BasePurple,
//                    textAlign = TextAlign.Left
//                )
//            )
//        }
//    }
//}