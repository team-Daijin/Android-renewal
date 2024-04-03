package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import site.algosipeosseong.designsystem.theme.DarkPurple
import site.algosipeosseong.designsystem.theme.LightBlack
import site.algosipeosseong.designsystem.theme.pretendard

//@Composable
//fun TextFieldSet(
//    textContent: String,
//    textFieldPlaceHolder: String,
//    errorMsg: String,
//    value: String,
//    isError: Boolean = false,
//    isPw: Boolean = false,
//    onValueChange: (String) -> Unit
//) {
//    BaseText(
//        text = textContent,
//        color = DarkPurple,
//        style = TextStyle(
//            fontSize = 16.sp,
//            fontFamily = pretendard,
//            fontWeight = FontWeight.Medium
//        )
//    )
//    BaseTextField(
//        modifier = Modifier
//            .padding(top = 4.dp)
//            .fillMaxWidth(),
//        value = value,
//        placeHolder = textFieldPlaceHolder,
//        onValueChange = onValueChange,
//        textFieldError = isError,
//        isPw = isPw
//    )
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.Top
//    ) {
//        ErrorText(
//            modifier = Modifier.padding(top = 4.dp),
//            text = errorMsg,
//            isError = isError
//        )
//        Text(
//            text = "${value.length}/30",
//            color = LightBlack,
//            style = TextStyle(
//                fontFamily = pretendard,
//                fontWeight = FontWeight.Normal,
//                fontSize = 12.sp
//            )
//        )
//    }
//}