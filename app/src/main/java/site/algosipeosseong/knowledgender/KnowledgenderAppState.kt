package site.algosipeosseong.knowledgender

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import site.algosipeosseong.home.navigateToHome
import site.algosipeosseong.knowledgender.navigation.TopLevelDestination
import site.algosipeosseong.knowledgender.navigation.TopLevelDestination.CENTER
import site.algosipeosseong.knowledgender.navigation.TopLevelDestination.HOME
import site.algosipeosseong.knowledgender.navigation.TopLevelDestination.MY

@Composable
fun rememberKnowledgenderAppState(
    coroutineScope: CoroutineScope,
    navController: NavHostController,
    positionChecked: MutableState<Boolean>
): KnowledgenderAppState {
    return remember(
        navController,
        coroutineScope,
        positionChecked

    ) {
        KnowledgenderAppState(
            navController,
            coroutineScope,
            positionChecked
        )
    }
}

@Stable
class KnowledgenderAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val positionChecked: MutableState<Boolean>
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    val isBannerPassed: Boolean
        get() = positionChecked.value

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topLevelDestination) {
                HOME -> navController.navigateToHome(topLevelNavOptions)
                CENTER -> {}//navController.navigateToBookmarks(topLevelNavOptions)
                MY -> {} //navController.navigateToInterests(null, topLevelNavOptions)
            }
        }
    }
}
