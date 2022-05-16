package com.mightyhedgehog.doplanner.presentation.screen.settings.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.presentation.screen.settings.SettingsScreenViewModel
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.settings.ChangeNameTitle
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.settings.ChangeStyleTitle
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.settings.ColorSchemeBox
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.settings.SettingsTitle
import com.mightyhedgehog.doplanner.presentation.ui.compoments.text.ChangeUserNameTextField
import com.mightyhedgehog.doplanner.presentation.ui.theme.*

@Composable
fun SettingsDisplay(
    state: SettingsScreenViewModel.State.Display,
    saveUserName: (String) -> Unit,
    onColorSchemeChanged: (DoPlannerStyle) -> Unit,
    ) {
    Column(
        modifier = Modifier
            .background(DoPlannerTheme.colors.backgroundWhite)
            .fillMaxSize()
    ) {
        SettingsTitle(modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp))
        Divider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 0.5.dp
        )
        ChangeNameTitle(modifier = Modifier.padding(16.dp))
        ChangeUserNameTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            user = state.user,
            saveUserName = { saveUserName(it) }
        )
        ChangeStyleTitle(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorSchemeBox(
                color = orangeLightPalette.mainColor,
                onClick = { onColorSchemeChanged(DoPlannerStyle.ORANGE) }
            )
            ColorSchemeBox(
                color = blueLightPalette.mainColor,
                onClick = { onColorSchemeChanged(DoPlannerStyle.BLUE) }
            )
            ColorSchemeBox(
                color = pinkLightPalette.mainColor,
                onClick = { onColorSchemeChanged(DoPlannerStyle.PINK) }
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorSchemeBox(
                color = purpleLightPalette.mainColor,
                onClick = { onColorSchemeChanged(DoPlannerStyle.PURPLE) }
            )
            ColorSchemeBox(
                color = greenLightPalette.mainColor,
                onClick = { onColorSchemeChanged(DoPlannerStyle.GREEN) }
            )
        }
    }
}
