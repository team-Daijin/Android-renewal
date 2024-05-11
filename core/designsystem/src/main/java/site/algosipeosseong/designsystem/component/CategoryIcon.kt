package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import site.algosipeosseong.common.CARDNEWS
import site.algosipeosseong.designsystem.R
import site.algosipeosseong.designsystem.theme.BaseBlack
import site.algosipeosseong.designsystem.theme.pretendard
import site.algosipeosseong.model.Category

@Composable
fun CategoryIcon(painter: Int,text: String,onNavigateTo: (String) -> Unit, string: String) {
    Column(modifier = Modifier.height(45.dp),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Image(
            modifier = Modifier
                .size(30.dp)
                .clickable { onNavigateTo(string) },
            painter = painterResource(id = painter),
            contentDescription = ""
        )
        Text(
            text = text,
            color = BaseBlack,
            style = TextStyle(
                fontFamily = pretendard,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        )
    }
}