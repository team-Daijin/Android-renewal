package site.algosipeosseong.knowledgender.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import site.algosipeosseong.common.CENTER
import site.algosipeosseong.common.HOME
import site.algosipeosseong.common.MY
import site.algosipeosseong.home.homeScreen
import site.algosipeosseong.knowledgender.KnowledgenderAppState

@Composable
fun KnowledgenderNavHost(
    appState: KnowledgenderAppState,
    modifier: Modifier = Modifier,
    startDestination: String = HOME,
) {
    val navHostController = rememberNavController()
    val positionChecked = remember { mutableStateOf(false) }

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {

        },
        topBar = {
            when(currentDestination?.route) {
                HOME, CENTER, MY -> {}
                else -> {}
            }
        }
    ) {
        NavHost(
            navController = navHostController,
            startDestination = startDestination,
            modifier = Modifier.padding(it.calculateBottomPadding())
        ) {
            homeScreen(onNavigationRequested = { navHostController.navigate(it) }, positionChecked = positionChecked)

        }
    }
}
