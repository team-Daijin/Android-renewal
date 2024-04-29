package site.algosipeosseong.home

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import site.algosipeosseong.common.HOME



fun NavGraphBuilder.homeScreen(
    onNavigationRequested: (String) -> Unit,
    positionChecked: MutableState<Boolean>
) {
    composable(route = HOME) {
        HomeRoute(positionChecked = positionChecked,onNavigationRequested = onNavigationRequested)
    }
}

fun NavController.navigateToHome() = navigate(HOME)