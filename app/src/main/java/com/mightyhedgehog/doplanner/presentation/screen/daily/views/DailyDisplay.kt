package com.mightyhedgehog.doplanner.presentation.screen.daily.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyScreenViewModel
import com.mightyhedgehog.doplanner.ui.compoments.screen.daily.*
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun DailyDisplay(
    state: DailyScreenViewModel.State.Display,
    onTodayTaskComplete: (Task) -> Unit,
    onTodayTaskDelete: (Task) -> Unit,
    onToDoTaskComplete: (Task) -> Unit,
    onToDoTaskDelete: (Task) -> Unit,
    onCompleteTaskDelete: (Task) -> Unit,
) {
    var rowsVisibility by remember { mutableStateOf(false) }

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
                completeTask = { onTodayTaskComplete(it) },
                deleteTask = { onTodayTaskDelete(it) },
            )
        }
        AllTasksTitle(
            count = state.tasks.size,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        )
        AnimatedVisibility(visible = rowsVisibility) {
            ToDoLazyRow(
                tasksList = state.tasks,
                completeTask = { onToDoTaskComplete(it) },
                deleteTask = { onToDoTaskDelete(it) },
            )
        }
        CompletedTasksTitle(
            count = state.completedTasks.size,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        )
        AnimatedVisibility(visible = rowsVisibility) {
            CompletedLazyRow(
                tasksList = state.completedTasks,
                deleteCompletedTask = { onCompleteTaskDelete(it) },
            )
        }
        SideEffect {
            rowsVisibility = true
        }
    }
}
