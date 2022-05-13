package com.mightyhedgehog.doplanner.presentation.screen.daily

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.ui.compoments.bars.progress.OrangeDotProgressBar
import com.mightyhedgehog.doplanner.ui.compoments.screen.daily.*
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun DailyScreen(vm: DailyScreenViewModel, navController: NavHostController) {
    val viewState = vm.currentState.observeAsState()
    var rowsVisibility by remember { mutableStateOf(false) }

    when (val state = viewState.value) {
        is DailyScreenViewModel.State.Display -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DoPlannerTheme.colors.backgroundWhite)
                    .verticalScroll(rememberScrollState())
            ) {
                WelcomeBar(
                    user = state.user,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
                )
                TodayTasksTitle(
                    count = state.dailyTasks.size,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 16.dp)
                )
                AnimatedVisibility(visible = rowsVisibility) {
                    TodayTasksLazyRow(
                        tasksList = state.dailyTasks,
                        completeTask = { vm.onEvent(DailyScreenViewModel.Event.CompleteTask(it)) },
                        deleteTask = { vm.onEvent(DailyScreenViewModel.Event.DeleteTask(it)) },
                    )
                }
                AllTasksTitle(
                    count = state.tasks.size,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                )
                AnimatedVisibility(visible = rowsVisibility) {
                    ToDoLazyRow(
                        tasksList = state.tasks,
                        completeTask = { vm.onEvent(DailyScreenViewModel.Event.CompleteTask(it)) },
                        deleteTask = { vm.onEvent(DailyScreenViewModel.Event.DeleteTask(it)) },
                    )
                }
                CompletedTasksTitle(
                    count = state.completedTasks.size,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                )
                AnimatedVisibility(visible = rowsVisibility) {
                    CompletedLazyRow(
                        tasksList = state.completedTasks,
                        deleteCompletedTask = {
                            vm.onEvent(DailyScreenViewModel.Event.DeleteCompletedTask(it))
                        },
                    )
                }
                rowsVisibility = true
            }
        }
        DailyScreenViewModel.State.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 72.dp), contentAlignment = Alignment.Center
            ) {
                OrangeDotProgressBar()
            }
        }
        null -> throw NotImplementedError("Unexpected daily state")
    }
}
