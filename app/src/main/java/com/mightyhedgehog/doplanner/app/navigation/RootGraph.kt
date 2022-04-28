package com.mightyhedgehog.doplanner.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mightyhedgehog.doplanner.app.navigation.graph.DAILY_SCREEN_NESTED_GRAPH
import com.mightyhedgehog.doplanner.app.navigation.graph.dailyGraph
import com.mightyhedgehog.doplanner.app.navigation.graph.settingsGraph
import com.mightyhedgehog.doplanner.app.navigation.graph.toDoGraph

private const val ROOT_ROUTE = "root_route"

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = DAILY_SCREEN_NESTED_GRAPH,
        route = ROOT_ROUTE
    ) {

        dailyGraph(navController = navController)
        toDoGraph(navController = navController)
        settingsGraph(navController = navController)
    }
}
