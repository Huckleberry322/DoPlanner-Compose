package com.mightyhedgehog.doplanner.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.app.navigation.SetupNavGraph
import com.mightyhedgehog.doplanner.ui.compoments.bars.bottombar.DoPlannerBottomBar
import com.mightyhedgehog.doplanner.ui.compoments.buttons.DoPlannerFloatingButton

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val fabState = rememberSaveable { (mutableStateOf(true)) }

    when (navBackStackEntry?.destination?.route) {
        Screens.DailyScreen.route -> {
            bottomBarState.value = true
            fabState.value = true
        }
        Screens.CalendarScreen.route -> {
            bottomBarState.value = true
            fabState.value = true
        }
        Screens.SettingsScreen.route -> {
            bottomBarState.value = true
            fabState.value = false
        }
        Screens.AddTaskScreen.route -> {
            bottomBarState.value = false
            fabState.value = false
        }
    }

    Scaffold(
        bottomBar = {
            DoPlannerBottomBar(
                navController = navController,
                navBackStackEntry = navBackStackEntry,
                bottomBarState = bottomBarState
            )
        },
        floatingActionButton = {
            DoPlannerFloatingButton(
                navController = navController,
                fabState = fabState
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
            SetupNavGraph(navController = navController)
        }
    }
}
