package com.mightyhedgehog.doplanner.presentation.screen.daily.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.compoments.bars.progress.OrangeDotProgressBar
import com.mightyhedgehog.doplanner.ui.compoments.buttons.DoPlannerBasicButton
import com.mightyhedgehog.doplanner.ui.compoments.buttons.NavigationButton
import com.mightyhedgehog.doplanner.ui.compoments.buttons.PriorityRadioButtons
import com.mightyhedgehog.doplanner.ui.compoments.screen.add.*
import com.mightyhedgehog.doplanner.ui.compoments.screen.daily.UserImage
import com.mightyhedgehog.doplanner.ui.compoments.text.DoPlannerBasicFieldField
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun AddTaskScreen(
    vm: AddTaskScreenViewModel,
    navController: NavController
) {
    val viewState = vm.currentState.observeAsState()

    when (val state = viewState.value) {
        is AddTaskScreenViewModel.State.Display -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DoPlannerTheme.colors.backgroundWhite)
                    .verticalScroll(rememberScrollState())
            ) {
                Column(modifier = Modifier.weight(1F)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        NavigationButton(
                            icon = painterResource(id = R.drawable.ic_previous),
                            onClick = { navController.popBackStack() }
                        )
                        UserImage(modifier = Modifier.size(40.dp))
                    }
                    AddTaskTitle(
                        modifier = Modifier.padding(
                            top = 8.dp,
                            start = 16.dp,
                            bottom = 8.dp
                        )
                    )
                    Divider(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        thickness = 0.5.dp
                    )
                    AddDescription(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                        textRes = R.string.task_title,
                    )
                    DoPlannerBasicFieldField(
                        text = state.taskTitle,
                        onValueChanged = {
                            vm.onEvent(AddTaskScreenViewModel.Event.TitleChanged(it))
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        paddingTop = 16.dp,
                        dividerThickness = 0.5.dp,
                        hintRes = R.string.title_hint,
                    )
                    AddDescription(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                        textRes = R.string.task_description,
                    )
                    DoPlannerBasicFieldField(
                        text = state.taskDescription,
                        onValueChanged = {
                            vm.onEvent(AddTaskScreenViewModel.Event.DescriptionChanged(it))
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        paddingTop = 16.dp,
                        dividerThickness = 0.5.dp,
                        hintRes = R.string.description_hint,
                    )
                    AddDescription(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                        textRes = R.string.task_date
                    )
                    DatePickerField(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        date = state.date,
                        dividerThickness = 0.5.dp,
                        onDateChanged = {
                            vm.onEvent(AddTaskScreenViewModel.Event.DateChanged(it))
                        }
                    )
                    AddDescription(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                        textRes = R.string.task_time
                    )
                    TimePickerField(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        time = state.time,
                        dividerThickness = 0.5.dp,
                        onTimeChanged = {
                            vm.onEvent(AddTaskScreenViewModel.Event.TimeChanged(it))
                        }
                    )
                    AddDescription(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                        textRes = R.string.task_priority
                    )
                    PriorityRadioButtons(
                        modifier = Modifier.padding(top = 8.dp),
                        onValueChanged = {
                            vm.onEvent(AddTaskScreenViewModel.Event.PriorityChanged(it))
                        },
                        initValue = state.taskPriority
                    )
                }
                DoPlannerBasicButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
                    onClick = { vm.onEvent(AddTaskScreenViewModel.Event.AddTaskButtonClicked) },
                    textRes = R.string.button_add_task,
                    enabled = state.taskTitle.isNotEmpty() && state.date != null && state.time != null
                )
            }
        }
        is AddTaskScreenViewModel.State.SaveProcess -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 72.dp),
                contentAlignment = Alignment.Center
            ) {
                OrangeDotProgressBar()
            }
            vm.onEvent(AddTaskScreenViewModel.Event.SaveTask)
        }
        AddTaskScreenViewModel.State.Success -> {
            navController.popBackStack()
        }
        null -> throw NotImplementedError("Unexpected settings state")
    }
}
