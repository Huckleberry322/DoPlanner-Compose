package com.mightyhedgehog.doplanner.ui.compoments.screen.daily

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun TodayTasksLazyRow(tasksList: List<Task>) {
    LazyRow(
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (tasksList.isNotEmpty()) {
            items(items = tasksList) { task ->
                TodayTaskCard(task = task, modifier = Modifier)
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
}

@Composable
fun ToDoLazyRow(tasksList: List<Task>) {
    LazyRow(
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (tasksList.isNotEmpty()) {
            items(items = tasksList) { task ->
                AllTaskCard(task = task, modifier = Modifier)
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
}

@Composable
fun CompletedLazyRow(tasksList: List<Task>) {
    LazyRow(
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (tasksList.isNotEmpty()) {
            items(items = tasksList) { task ->
                CompletedTaskCard(task = task, modifier = Modifier)
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
}
