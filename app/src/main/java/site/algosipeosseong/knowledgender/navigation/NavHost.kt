package site.algosipeosseong.knowledgender.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import site.algosipeosseong.common.HOME
import site.algosipeosseong.home.homeScreen
import site.algosipeosseong.knowledgender.KnowledgenderAppState

@Composable
fun KnowledgenderNavHost(
    appState: KnowledgenderAppState,
    modifier: Modifier = Modifier,
    startDestination: String = HOME,
) {
    val navHostController = appState.navController
    val positionChecked = appState.positionChecked

    Log.d("euya","navhost")
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        homeScreen(
            onNavigationRequested = { navHostController.navigate(it) },
            positionChecked = positionChecked
        )
    }
}
