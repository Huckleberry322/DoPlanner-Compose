package com.mightyhedgehog.doplanner.presentation.screen.calendar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.ui.compoments.bars.progress.OrangeDotProgressBar
import com.mightyhedgehog.doplanner.ui.compoments.calendar.CalendarLazyColumn
import com.mightyhedgehog.doplanner.ui.compoments.calendar.DoPlannerCalendar
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun CalendarScreen(
    vm: CalendarScreenViewModel,
    navController: NavHostController
) {
    val viewState = vm.currentState.observeAsState()

    when (val state = viewState.value) {
        is CalendarScreenViewModel.State.Display ->
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
                        vm.onEvent(CalendarScreenViewModel.Event.DateChanged(date))
                    },
                    taskList = state.taskList
                )
                CalendarLazyColumn(
                    modifier = Modifier.padding(top = 12.dp),
                    taskList = state.dayTaskList,
                    date = state.currentDate
                )
            }
        CalendarScreenViewModel.State.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 72.dp), contentAlignment = Alignment.Center
            ) {
                OrangeDotProgressBar()
            }
        }
        null -> throw NotImplementedError("Unexpected calendar state")
    }
}
