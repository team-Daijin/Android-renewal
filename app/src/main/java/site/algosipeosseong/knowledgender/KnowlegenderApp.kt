package site.algosipeosseong.knowledgender

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import site.algosipeosseong.common.CENTER
import site.algosipeosseong.common.HOME
import site.algosipeosseong.common.MY
import site.algosipeosseong.designsystem.component.KnowledgenderNavigationBar
import site.algosipeosseong.designsystem.component.KnowledgenderNavigationBarItem
import site.algosipeosseong.knowledgender.navigation.KnowledgenderNavHost
import site.algosipeosseong.knowledgender.navigation.TopLevelDestination

@Composable
fun KnowledgenderApp(appState: KnowledgenderAppState, modifier: Modifier = Modifier) {
    val currentDestination = appState.currentDestination
    Log.d("euya","App")
    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        bottomBar = {
            when (currentDestination?.route) {
                HOME, CENTER, MY -> KnowledgenderBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination
                )
                else -> {}
            }
        }
    ) {
        KnowledgenderNavHost(
            appState = appState,
            modifier = Modifier.padding(paddingValues = it)
        )

    }
}


@Composable
private fun KnowledgenderBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    KnowledgenderNavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            KnowledgenderNavigationBarItem(
                selected = currentDestination?.route == destination.route,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = ImageVector.vectorResource(id = destination.icon),
                        contentDescription = null,
                    )
                },
                label = { Text(destination.text) }
            )
        }
    }
}
