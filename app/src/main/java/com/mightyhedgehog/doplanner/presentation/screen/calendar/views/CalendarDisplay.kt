package com.mightyhedgehog.doplanner.presentation.screen.calendar.views

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.presentation.screen.calendar.CalendarScreenViewModel
import com.mightyhedgehog.doplanner.ui.compoments.screen.calendar.CalendarLazyColumn
import com.mightyhedgehog.doplanner.ui.compoments.screen.calendar.DoPlannerCalendar
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme
import java.time.LocalDate

@Composable
fun CalendarDisplay(
    state: CalendarScreenViewModel.State.Display,
    onDateSelectionChanged: (LocalDate) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(DoPlannerTheme.colors.backgroundWhite)
            .fillMaxSize()
    ) {
        DoPlannerCalendar(
            modifier = Modifier
                .animateContentSize()
                .padding(start = 25.dp, end = 25.dp),
            onSelectionChanged = { date ->
                onDateSelectionChanged(date)
            },
            taskList = state.taskList
        )
        CalendarLazyColumn(
            modifier = Modifier.padding(top = 12.dp),
            taskList = state.dayTaskList,
            date = state.currentDate
        )
    }
}
