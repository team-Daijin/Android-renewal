package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import site.algosipeosseong.designsystem.R
import site.algosipeosseong.designsystem.theme.LighterBlack
import site.algosipeosseong.designsystem.theme.pretendard

@Composable
fun NoData(modifier: Modifier = Modifier) {
    val i = 1
    i.inc()
    Column(modifier = modifier.height(150.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.dataslash), contentDescription = "noData")
        BaseText(
            text = "근처에 연계된 상담소가 없어요",
            color = LighterBlack,
            style = TextStyle(
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        )
    }
}