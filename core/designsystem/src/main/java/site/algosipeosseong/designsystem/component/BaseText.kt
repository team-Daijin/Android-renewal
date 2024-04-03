package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import site.algosipeosseong.designsystem.theme.DarkestBlack
import site.algosipeosseong.designsystem.theme.LighterBlack
import site.algosipeosseong.designsystem.theme.pretendard

@Composable
fun BaseText(modifier: Modifier = Modifier, text: String, color: Color, style: TextStyle) {
    Text(
        text = text,
        modifier = modifier.wrapContentSize(),
        color = color,
        style = style
    )
}

@Composable
fun HomeTitleText(modifier: Modifier = Modifier, text: String,subText: String) {
    Column(Modifier.padding(start = 24.dp)) {
        Text(
            text = text, color = DarkestBlack, style = TextStyle(
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = subText, color = LighterBlack, style = TextStyle(
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        )
    }
}