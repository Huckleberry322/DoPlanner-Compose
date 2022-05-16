package com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.presentation.model.task.Task
import com.mightyhedgehog.doplanner.ext.toString
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.daily.CalendarTaskCard
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme
import java.time.LocalDate

@Composable
fun CalendarLazyColumn(modifier: Modifier, taskList: List<Task>, date: LocalDate) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            val datePattern = "dd LLLL yyyy"
            Text(
                text = date.toString(datePattern),
                style = DoPlannerTheme.typography.calendarWeekHeaderStyle
            )
        }
        if (taskList.isNotEmpty()) {
            items(items = taskList) { task ->
                CalendarTaskCard(
                    task = task,
                )
            }
        } else {
            item {
                Text(
                    text = stringResource(id = R.string.no_tasks_calendar),
                    style = DoPlannerTheme.typography.calendarEmptyList
                )
            }
        }
    }
}
