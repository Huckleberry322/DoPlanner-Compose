package com.mightyhedgehog.doplanner.presentation.settings

import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor() : StatefulViewModel<SettingsScreenViewModel>() {

    sealed class Event() {

    }

    class State

    override fun onEvent(event: SettingsScreenViewModel) {
        // TODO("Not yet implemented")
    }
}
