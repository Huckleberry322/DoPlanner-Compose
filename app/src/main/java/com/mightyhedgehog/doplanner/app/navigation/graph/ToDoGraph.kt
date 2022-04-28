package com.mightyhedgehog.doplanner.app.navigation.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.presentation.calendar.CalendarScreen
import com.mightyhedgehog.doplanner.presentation.calendar.CalendarScreenViewModel

const val CALENDAR_SCREEN_NESTED_GRAPH = "calendar_screen_nested_graph"

fun NavGraphBuilder.toDoGraph(navController: NavHostController) {
    navigation(
        startDestination = Screens.CalendarScreen.route,
        route = CALENDAR_SCREEN_NESTED_GRAPH
    ) {
        composable(route = Screens.CalendarScreen.route) {
            val vm = hiltViewModel<CalendarScreenViewModel>()
            CalendarScreen(vm = vm, navController = navController)
        }
    }
}
