package com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.daily

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.presentation.model.task.Task
import com.mightyhedgehog.doplanner.presentation.dialog.SimpleDoPlannerChoseDialog
import com.mightyhedgehog.doplanner.presentation.dialog.SimpleDoPlannerChoseDialogWithOption
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme

@Composable
fun TodayTasksLazyRow(
    tasksList: List<Task>,
    completeTask: (Task) -> Unit,
    deleteTask: (Task) -> Unit,
) {
    var selectedTask: Task? by remember { mutableStateOf(null) }
    val completeDialog = remember { mutableStateOf(false) }

    LazyRow(
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (tasksList.isNotEmpty()) {
            items(items = tasksList) { task ->
                TodayTaskCard(
                    task = task,
                    onClick = {
                        selectedTask = task
                        completeDialog.value = true
                    },
                )
            }
        } else {
            item {
                Text(
                    text = stringResource(id = R.string.daily_no_today_task),
                    style = DoPlannerTheme.typography.dailyEmptyLists,
                )
            }
        }
    }

    if (completeDialog.value) {
        selectedTask?.let {
            SimpleDoPlannerChoseDialogWithOption(
                action = { completeTask(it) },
                onDismiss = { completeDialog.value = false },
                option = { deleteTask(it) },
                titleRes = R.string.dialog_complete_task,
                positiveAnswerRes = R.string.dialog_yes,
                negativeAnswerRes = R.string.dialog_no,
                optionAnswerRes = R.string.dialog_option_delete,
            )
        }
    }
}

@Composable
fun ToDoLazyRow(
    tasksList: List<Task>,
    completeTask: (Task) -> Unit,
    deleteTask: (Task) -> Unit,
) {
    var selectedTask: Task? by remember { mutableStateOf(null) }
    val completeDialog = remember { mutableStateOf(false) }

    LazyRow(
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (tasksList.isNotEmpty()) {
            items(items = tasksList) { task ->
                AllTaskCard(
                    task = task,
                    onClick = {
                        selectedTask = task
                        completeDialog.value = true
                    },
                )
            }
        } else {
            item {
                Text(
                    text = stringResource(id = R.string.daily_no_todo_task),
                    style = DoPlannerTheme.typography.dailyEmptyLists,
                )
            }
        }
    }

    if (completeDialog.value) {
        selectedTask?.let {
            SimpleDoPlannerChoseDialogWithOption(
                action = { completeTask(it) },
                onDismiss = { completeDialog.value = false },
                option = { deleteTask(it) },
                titleRes = R.string.dialog_complete_task,
                positiveAnswerRes = R.string.dialog_yes,
                negativeAnswerRes = R.string.dialog_no,
                optionAnswerRes = R.string.dialog_option_delete,
            )
        }
    }
}

@Composable
fun CompletedLazyRow(
    tasksList: List<Task>,
    deleteCompletedTask: (Task) -> Unit,
) {
    var selectedTask: Task? by remember { mutableStateOf(null) }
    val deleteDialog = remember { mutableStateOf(false) }

    LazyRow(
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (tasksList.isNotEmpty()) {
            items(items = tasksList) { task ->
                CompletedTaskCard(
                    task = task,
                    onClick = {
                        selectedTask = task
                        deleteDialog.value = true
                    },
                )
            }
        } else {
            item {
                Text(
                    text = stringResource(id = R.string.daily_no_completed_task),
                    style = DoPlannerTheme.typography.dailyEmptyLists,
                )
            }
        }
    }

    if (deleteDialog.value) {
        selectedTask?.let {
            SimpleDoPlannerChoseDialog(
                action = { deleteCompletedTask(it) },
                onDismiss = { deleteDialog.value = false },
                titleRes = R.string.dialog_delete_task,
                positiveAnswerRes = R.string.dialog_yes,
                negativeAnswerRes = R.string.dialog_no,
            )
        }
    }
}
