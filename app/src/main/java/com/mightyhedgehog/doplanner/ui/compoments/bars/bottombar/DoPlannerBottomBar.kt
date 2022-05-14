package com.mightyhedgehog.doplanner.ui.compoments.bars.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun DoPlannerBottomBar(
    navController: NavHostController,
    navBackStackEntry: NavBackStackEntry?,
    bottomBarState: MutableState<Boolean>
) {
    val destinationsList = listOf(
        BottomBarGraph.DailyGraph,
        BottomBarGraph.CalendarGraph,
        BottomBarGraph.SettingsGraph,
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        val currentDestination = navBackStackEntry?.destination

        BottomNavigation(
            backgroundColor = DoPlannerTheme.colors.white,
            elevation = 20.dp
        ) {
            destinationsList.forEach { nestedGraph ->
                AddItemToBottomBar(
                    graph = nestedGraph,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItemToBottomBar(
    graph: BottomBarGraph,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    BottomNavigationItem(
        label = {
            if (currentDestination?.hierarchy?.any { it.route == graph.route } == true) {
                Text(text = stringResource(id = R.string.big_dot_symbol))
            } else Text(text = graph.title)
        },
        icon = { Icon(painter = painterResource(id = graph.icon), contentDescription = null) },
        selected = currentDestination?.hierarchy?.any {
            it.route == graph.route
        } == true,
        onClick = {
            navController.navigate(graph.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        selectedContentColor = DoPlannerTheme.colors.mainColor,
        unselectedContentColor = DoPlannerTheme.colors.mainColor.copy(alpha = 0.30F)
    )
}