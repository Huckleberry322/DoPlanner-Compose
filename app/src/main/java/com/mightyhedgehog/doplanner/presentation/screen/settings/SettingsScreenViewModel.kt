package com.mightyhedgehog.doplanner.presentation.screen.settings

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.BaseViewModel
import com.mightyhedgehog.doplanner.data.local.datastore.ThemeDataStore
import com.mightyhedgehog.doplanner.presentation.model.user.User
import com.mightyhedgehog.doplanner.data.gateway.user.GetUserGateway
import com.mightyhedgehog.doplanner.data.gateway.user.SaveUserGateway
import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyUpdateHandler
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerStyle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val themeDataStore: ThemeDataStore,
    private val getUserGateway: GetUserGateway,
    private val saveUserGateway: SaveUserGateway,
    private val dailyUpdateHandler: DailyUpdateHandler,
) : BaseViewModel<SettingsScreenViewModel.State, SettingsScreenViewModel.Event>(State.Loading) {

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        viewModelScope.launch {
            val user = getUserGateway.execute()

            produceState(
                State.Display(user = user)
            )
        }
    }

    sealed class State {
        data class Display(
            val user: User,
        ) : State()

        object Loading : State()
    }

    sealed class Event {
        data class UserNameChanged(val name: String) : Event()
        data class ColorSchemeChanged(val scheme: DoPlannerStyle) : Event()
    }

    override fun onEvent(event: Event) {
        when (val currentState = state) {
            is State.Display -> reduceEvent(event, currentState)
        }
    }

    private fun reduceEvent(event: Event, state: State.Display) {
        when (event) {
            is Event.UserNameChanged -> {
                viewModelScope.launch {
                    val user = state.user
                    val newUser = user.copy(
                        name = event.name
                    )

                    produceState(
                        state.copy(user = newUser)
                    )

                    saveUserGateway.execute(newUser)
                    dailyUpdateHandler.update(Unit)
                }
            }
            is Event.ColorSchemeChanged -> viewModelScope.launch {
                themeDataStore.saveStyle(event.scheme.name)
            }
        }
    }
}
