package site.algosipeosseong.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import site.algosipeosseong.common.HOME

fun NavGraphBuilder.homeScreen(
    onNavigationRequested: (String) -> Unit,
    positionChecked: MutableState<Boolean>
) {

    composable(route = HOME) {
        Log.d("euya", "homeroute before")
        HomeRoute(positionChecked = positionChecked, onNavigationRequested = onNavigationRequested)


    }
}

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(HOME, navOptions = navOptions)