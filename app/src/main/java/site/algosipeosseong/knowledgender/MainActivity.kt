package site.algosipeosseong.knowledgender

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import site.algosipeosseong.designsystem.theme.KnowledgenderTheme
import site.algosipeosseong.knowledgender.navigation.KnowledgenderNavHost

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val positionChecked = remember { mutableStateOf(false) }
            val appState = rememberKnowledgenderAppState(
                navController = rememberNavController(),
                coroutineScope = rememberCoroutineScope(),
                positionChecked = positionChecked
            )
            KnowledgenderTheme {
                Log.d("euya","activity")
                KnowledgenderApp(appState = appState)
            }
        }
    }
}

