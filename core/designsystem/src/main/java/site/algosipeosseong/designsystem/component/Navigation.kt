package site.algosipeosseong.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import site.algosipeosseong.designsystem.theme.LightBlack
import site.algosipeosseong.designsystem.theme.LightPurple

@Composable
fun RowScope.KnowledgenderNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = LightPurple,
            unselectedIconColor = LightBlack,
            selectedTextColor = LightPurple,
            unselectedTextColor = LightBlack
        ),
    )
}

@Composable
fun KnowledgenderNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier.border(1.dp, Color(0xFFECECEC)),
        contentColor = Color.White,
        tonalElevation = 0.dp,
        content = content,
    )
}