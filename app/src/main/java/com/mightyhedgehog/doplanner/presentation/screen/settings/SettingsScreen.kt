package com.mightyhedgehog.doplanner.presentation.screen.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.ui.compoments.bars.progress.OrangeDotProgressBar
import com.mightyhedgehog.doplanner.ui.compoments.screen.settings.*
import com.mightyhedgehog.doplanner.ui.compoments.text.ChangeUserNameTextField
import com.mightyhedgehog.doplanner.ui.theme.*
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerStyle

@Composable
fun SettingsScreen(
    vm: SettingsScreenViewModel,
    navController: NavHostController,
) {
    val viewState = vm.currentState.observeAsState()

    when (val state = viewState.value) {
        is SettingsScreenViewModel.State.Display -> {
            Column(
                modifier = Modifier
                    .background(DoPlannerTheme.colors.backgroundWhite)
                    .fillMaxSize()
            ) {
                SettingsTitle(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    )
                )
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
                    saveUserName = { name ->
                        vm.onEvent(SettingsScreenViewModel.Event.UserNameChanged(name))
                    }
                )
                ChangeStyleTitle(modifier = Modifier.padding(16.dp))
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ColorSchemeBox(color = orangeLightPalette.mainColor, onClick = {
                        vm.changeSchemeClicked(DoPlannerStyle.ORANGE)
                    })
                    ColorSchemeBox(color = blueLightPalette.mainColor, onClick = {
                        vm.changeSchemeClicked(DoPlannerStyle.BLUE)
                    })
                    ColorSchemeBox(color = pinkLightPalette.mainColor, onClick = {
                        vm.changeSchemeClicked(DoPlannerStyle.PINK)
                    })
                }
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ColorSchemeBox(color = purpleLightPalette.mainColor, onClick = {
                        vm.changeSchemeClicked(DoPlannerStyle.PURPLE)
                    })
                    ColorSchemeBox(color = greenLightPalette.mainColor, onClick = {
                        vm.changeSchemeClicked(DoPlannerStyle.GREEN)
                    })
                }
            }
        }
        SettingsScreenViewModel.State.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 72.dp), contentAlignment = Alignment.Center
            ) {
                OrangeDotProgressBar()
            }
        }
        null -> throw NotImplementedError("Unexpected settings state")
    }
}
