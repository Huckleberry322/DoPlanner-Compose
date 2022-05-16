package com.mightyhedgehog.doplanner.presentation.screen.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.mightyhedgehog.doplanner.presentation.screen.settings.views.SettingsDisplay
import com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.common.LoadingView

@Composable
fun SettingsScreen(
    vm: SettingsScreenViewModel,
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
