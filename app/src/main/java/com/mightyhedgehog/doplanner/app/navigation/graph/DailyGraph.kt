package com.mightyhedgehog.doplanner.app.navigation.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.presentation.daily.DailyScreen
import com.mightyhedgehog.doplanner.presentation.daily.DailyScreenViewModel
import com.mightyhedgehog.doplanner.presentation.daily.add.AddTaskScreen
import com.mightyhedgehog.doplanner.presentation.daily.add.AddTaskScreenViewModel

const val DAILY_SCREEN_NESTED_GRAPH = "daily_screen_nested_graph"

fun NavGraphBuilder.dailyGraph(navController: NavHostController) {
    navigation(
        startDestination = Screens.DailyScreen.route,
        route = DAILY_SCREEN_NESTED_GRAPH
    ) {
        composable(route = Screens.DailyScreen.route) {
            val vm = hiltViewModel<DailyScreenViewModel>()
            DailyScreen(vm = vm, navController = navController)
        }
        composable(route = Screens.AddTaskScreen.route) {
            val vm = hiltViewModel<AddTaskScreenViewModel>()
            AddTaskScreen(vm = vm, navController = navController)
        }
    }
}
