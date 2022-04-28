package com.mightyhedgehog.doplanner.presentation.settings

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import com.mightyhedgehog.doplanner.data.local.datastore.ThemeDataStore
import com.mightyhedgehog.doplanner.ui.theme.style.DoPlannerStyle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val themeDataStore: ThemeDataStore
) : StatefulViewModel<SettingsScreenViewModel>() {

    sealed class Event() {

    }

    class State

    override fun onEvent(event: SettingsScreenViewModel) {
        // TODO("Not yet implemented")
    }

    fun changeSchemeClicked(style: DoPlannerStyle) {
        viewModelScope.launch {
            themeDataStore.saveStyle(style.name)
        }
    }
}
