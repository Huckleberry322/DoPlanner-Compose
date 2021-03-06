package com.mightyhedgehog.doplanner.presentation.screen.daily.add.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.presentation.model.task.Priority
import com.mightyhedgehog.doplanner.presentation.screen.daily.add.AddTaskScreenViewModel
import com.mightyhedgehog.doplanner.presentation.ui.compoments.buttons.DoPlannerBasicButton
import com.mightyhedgehog.doplanner.presentation.ui.compoments.buttons.NavigationButton
import com.mightyhedgehog.doplanner.presentation.ui.compoments.buttons.PriorityRadioButtons
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.add.AddDescription
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.add.AddTaskTitle
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.add.DatePickerField
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.add.TimePickerField
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.daily.UserImage
import com.mightyhedgehog.doplanner.presentation.ui.compoments.text.DoPlannerBasicFieldField
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme
import java.time.LocalDate
import java.time.LocalTime

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddTaskDisplay(
    state: AddTaskScreenViewModel.State.Display,
    navigateBack: () -> Unit,
    onTitleChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
    onDateChanged: (LocalDate) -> Unit,
    onTimeChanged: (LocalTime) -> Unit,
    onPriorityChanged: (Priority) -> Unit,
    onAddClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DoPlannerTheme.colors.backgroundWhite)
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.weight(1F)) {
            val kc = LocalSoftwareKeyboardController.current
            val focusManager = LocalFocusManager.current

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                NavigationButton(
                    icon = painterResource(id = R.drawable.ic_previous),
                    onClick = navigateBack
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
                onValueChanged = { onTitleChanged(it) },
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                paddingTop = 16.dp,
                dividerThickness = 0.5.dp,
                hintRes = R.string.title_hint,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_description,
            )
            DoPlannerBasicFieldField(
                text = state.taskDescription,
                onValueChanged = { onDescriptionChanged(it) },
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                paddingTop = 16.dp,
                dividerThickness = 0.5.dp,
                hintRes = R.string.description_hint,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        kc?.hide()
                        focusManager.clearFocus()
                    }
                )
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_date
            )
            DatePickerField(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                date = state.date,
                dividerThickness = 0.5.dp,
                onDateChanged = { onDateChanged(it) }
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_time
            )
            TimePickerField(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                time = state.time,
                dividerThickness = 0.5.dp,
                onTimeChanged = { onTimeChanged(it) }
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_priority
            )
            PriorityRadioButtons(
                modifier = Modifier.padding(top = 8.dp),
                onValueChanged = { onPriorityChanged(it) },
                initValue = state.taskPriority
            )
        }
        DoPlannerBasicButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 24.dp),
            onClick = { onAddClicked() },
            textRes = R.string.button_add_task,
            enabled = state.taskTitle.isNotEmpty() && state.date != null && state.time != null
        )
    }
}
