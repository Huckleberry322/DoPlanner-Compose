package com.mightyhedgehog.doplanner.presentation.screen.daily.add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.mightyhedgehog.doplanner.presentation.screen.daily.add.views.AddTaskDisplay
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.common.LoadingView

@Composable
fun AddTaskScreen(
    vm: AddTaskScreenViewModel,
    navController: NavController
) {
    val viewState = vm.stateData.observeAsState(initial = vm.getDefaultState())

    when (val state = viewState.value) {
        is AddTaskScreenViewModel.State.Display -> AddTaskDisplay(
            state = state,
            navigateBack = { navController.popBackStack() },
            onTitleChanged = { vm.onEvent(AddTaskScreenViewModel.Event.TitleChanged(it)) },
            onDescriptionChanged = { vm.onEvent(AddTaskScreenViewModel.Event.DescriptionChanged(it)) },
            onDateChanged = { vm.onEvent(AddTaskScreenViewModel.Event.DateChanged(it)) },
            onTimeChanged = { vm.onEvent(AddTaskScreenViewModel.Event.TimeChanged(it)) },
            onPriorityChanged = { vm.onEvent(AddTaskScreenViewModel.Event.PriorityChanged(it)) },
            onAddClicked = { vm.onEvent(AddTaskScreenViewModel.Event.AddTaskButtonClicked) }
        )
        is AddTaskScreenViewModel.State.SaveProcess -> {
            LoadingView()
            vm.onEvent(AddTaskScreenViewModel.Event.SaveTask)
        }
        AddTaskScreenViewModel.State.Success -> navController.popBackStack()
    }
}
