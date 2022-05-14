package com.mightyhedgehog.doplanner.presentation.screen.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.mightyhedgehog.doplanner.presentation.screen.settings.views.SettingsDisplay
import com.mightyhedgehog.doplanner.presentation.views.LoadingView

@Composable
fun SettingsScreen(
    vm: SettingsScreenViewModel,
    navController: NavHostController,
) {
    val viewState = vm.stateData.observeAsState(initial = vm.getDefaultState())

    when (val state = viewState.value) {
        is SettingsScreenViewModel.State.Display -> SettingsDisplay(
            state = state,
            saveUserName = { vm.onEvent(SettingsScreenViewModel.Event.UserNameChanged(it)) },
            onColorSchemeChanged = { vm.onEvent(SettingsScreenViewModel.Event.ColorSchemeChanged(it)) }
        )
        SettingsScreenViewModel.State.Loading -> LoadingView()
    }
}
