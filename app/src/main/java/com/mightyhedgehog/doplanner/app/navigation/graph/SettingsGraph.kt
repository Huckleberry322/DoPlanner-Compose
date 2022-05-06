package com.mightyhedgehog.doplanner.app.navigation.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.presentation.screen.settings.SettingsScreen
import com.mightyhedgehog.doplanner.presentation.screen.settings.SettingsScreenViewModel

const val SETTINGS_SCREEN_NESTED_GRAPH = "settings_screen_nested_graph"

fun NavGraphBuilder.settingsGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = Screens.SettingsScreen.route,
        route = SETTINGS_SCREEN_NESTED_GRAPH
    ) {
        composable(route = Screens.SettingsScreen.route) {
            val vm = hiltViewModel<SettingsScreenViewModel>()
            SettingsScreen(
                vm = vm,
                navController = navController,
            )
        }
    }
}
