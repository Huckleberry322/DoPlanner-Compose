package com.mightyhedgehog.doplanner.presentation.screen.calendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.mightyhedgehog.doplanner.presentation.screen.calendar.views.CalendarDisplay
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.common.LoadingView

@Composable
fun CalendarScreen(
    vm: CalendarScreenViewModel,
) {
    val viewState = vm.stateData.observeAsState(initial = vm.getDefaultState())

    when (val state = viewState.value) {
        is CalendarScreenViewModel.State.Display -> CalendarDisplay(
            state = state,
            onDateSelectionChanged = { vm.onEvent(CalendarScreenViewModel.Event.DateChanged(it)) }
        )
        CalendarScreenViewModel.State.Loading -> LoadingView()
    }
}
