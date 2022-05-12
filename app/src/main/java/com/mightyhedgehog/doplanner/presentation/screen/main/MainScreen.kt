package com.mightyhedgehog.doplanner.presentation.screen.main

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mightyhedgehog.doplanner.app.navigation.Screens
import com.mightyhedgehog.doplanner.app.navigation.SetupNavGraph
import com.mightyhedgehog.doplanner.ui.compoments.bars.bottombar.DoPlannerBottomBar
import com.mightyhedgehog.doplanner.ui.compoments.buttons.DoPlannerFloatingButton
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

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
                onClick = { navController.navigate(Screens.AddTaskScreen.route) },
                fabState = fabState
            )
        },
        backgroundColor = DoPlannerTheme.colors.backgroundWhite
    ) { innerPadding ->
        var bottomPaddingState by remember { mutableStateOf(0.dp) }
        bottomPaddingState = innerPadding.calculateBottomPadding()

        val transition = updateTransition(
            targetState = bottomPaddingState,
            label = "Update bottom padding transitions"
        )

        val size by transition.animateDp(
            label = "Animate bottom padding DP"
        ) { it }

        Box(
            modifier = Modifier.padding(bottom = size)
        ) {
            SetupNavGraph(navController = navController)
        }
    }
}
