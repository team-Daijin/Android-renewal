package site.algosipeosseong.knowledgender

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import site.algosipeosseong.common.HOME

@Composable
fun KnowledgenderNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = HOME,
) {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {

    }
}