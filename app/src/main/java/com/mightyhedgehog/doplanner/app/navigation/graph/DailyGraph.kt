package com.mightyhedgehog.doplanner.app.navigation.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyScreen
import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyScreenViewModel
import com.mightyhedgehog.doplanner.presentation.screen.daily.add.AddTaskScreen
import com.mightyhedgehog.doplanner.presentation.screen.daily.add.AddTaskScreenViewModel

const val DAILY_SCREEN_NESTED_GRAPH = "daily_screen_nested_graph"

fun NavGraphBuilder.dailyGraph(navController: NavHostController) {
    navigation(
        startDestination = Screens.DailyScreen.route,
        route = DAILY_SCREEN_NESTED_GRAPH
    ) {
        composable(route = Screens.DailyScreen.route) {
            val viewModel = hiltViewModel<DailyScreenViewModel>()
            DailyScreen(vm = viewModel)
        }
        composable(route = Screens.AddTaskScreen.route) {
            val viewModel = hiltViewModel<AddTaskScreenViewModel>()
            AddTaskScreen(vm = viewModel, navController = navController)
        }
    }
}
