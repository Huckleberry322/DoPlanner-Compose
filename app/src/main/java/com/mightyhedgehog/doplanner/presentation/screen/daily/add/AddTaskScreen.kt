package com.mightyhedgehog.doplanner.presentation.screen.daily.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ui.compoments.buttons.DoPlannerBasicButton
import com.mightyhedgehog.doplanner.ui.compoments.buttons.NavigationButton
import com.mightyhedgehog.doplanner.ui.compoments.buttons.PriorityRadioButtons
import com.mightyhedgehog.doplanner.ui.compoments.screen.add.AddDescription
import com.mightyhedgehog.doplanner.ui.compoments.screen.add.AddTaskTitle
import com.mightyhedgehog.doplanner.ui.compoments.screen.daily.UserImage
import com.mightyhedgehog.doplanner.ui.compoments.text.DoPlannerBasicFieldField
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun AddTaskScreen(vm: AddTaskScreenViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DoPlannerTheme.colors.backgroundWhite)
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
            AddTaskTitle(modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 8.dp))
            Divider(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                thickness = 0.5.dp
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_title,
            )
            DoPlannerBasicFieldField(
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
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                paddingTop = 16.dp,
                dividerThickness = 0.5.dp,
                hintRes = R.string.description_hint,
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_date
            )
            DoPlannerBasicFieldField(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                paddingTop = 16.dp,
                dividerThickness = 0.5.dp,
                hintRes = R.string.date_hint
            )
            AddDescription(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                textRes = R.string.task_priority
            )
            PriorityRadioButtons(modifier = Modifier.padding(top = 8.dp))
        }
        DoPlannerBasicButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            onClick = {},
            textRes = R.string.button_add_task
        )
    }
}
