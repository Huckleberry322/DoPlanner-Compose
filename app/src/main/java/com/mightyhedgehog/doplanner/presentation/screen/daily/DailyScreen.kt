package com.mightyhedgehog.doplanner.presentation.screen.daily

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.presentation.screen.daily.views.DailyDisplay
import com.mightyhedgehog.doplanner.presentation.views.LoadingView

@Composable
fun DailyScreen(vm: DailyScreenViewModel, navController: NavHostController) {
    val viewState = vm.stateData.observeAsState(initial = vm.getDefaultState())

    when (val state = viewState.value) {
        is DailyScreenViewModel.State.Display -> DailyDisplay(
            state = state,
            onTodayTaskComplete = { vm.onEvent(DailyScreenViewModel.Event.CompleteTask(it)) },
            onTodayTaskDelete = { vm.onEvent(DailyScreenViewModel.Event.DeleteTask(it)) },
            onToDoTaskComplete = { vm.onEvent(DailyScreenViewModel.Event.CompleteTask(it)) },
            onToDoTaskDelete = { vm.onEvent(DailyScreenViewModel.Event.DeleteTask(it)) },
            onCompleteTaskDelete = { vm.onEvent(DailyScreenViewModel.Event.DeleteCompletedTask(it)) },
        )
        DailyScreenViewModel.State.Loading -> LoadingView()
    }
}
