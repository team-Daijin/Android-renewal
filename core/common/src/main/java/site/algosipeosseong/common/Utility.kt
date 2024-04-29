package site.algosipeosseong.common

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

//@Composable
//fun BackOnPressed() {
//    val context = LocalContext.current
//    var backPressedState by remember { mutableStateOf(true) }
//    var backPressedTime = 0L
//
//    BackHandler(enabled = backPressedState) {
//        if (System.currentTimeMillis() - backPressedTime <= 1000L) {
//            // 앱 종료
//            (context as Activity).finish()
//        } else {
//            backPressedState = true
//            Toast.makeText(context, "한 번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()
//        }
//        backPressedTime = System.currentTimeMillis()
//    }
//}


@Composable
fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }
