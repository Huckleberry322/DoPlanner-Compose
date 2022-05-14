package com.mightyhedgehog.doplanner.presentation.screen.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import com.mightyhedgehog.doplanner.data.local.datastore.ThemeDataStore
import com.mightyhedgehog.doplanner.domain.model.user.User
import com.mightyhedgehog.doplanner.domain.usecase.user.GetUserUseCase
import com.mightyhedgehog.doplanner.domain.usecase.user.SaveUserUseCase
import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyUpdateHandler
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerStyle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val themeDataStore: ThemeDataStore,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val dailyUpdateHandler: DailyUpdateHandler,
) : StatefulViewModel<SettingsScreenViewModel.Event>() {

    private val _currentState: MutableLiveData<State> =
        MutableLiveData(State.Loading)
    val currentState: LiveData<State> = _currentState

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        viewModelScope.launch {
            val user = getUserUseCase.execute()

            _currentState.postValue(
                State.Display(user = user)
            )
        }
    }

    sealed class Event {
        data class UserNameChanged(val name: String) : Event()
        data class ColorSchemeChanged(val scheme: DoPlannerStyle) : Event()
    }

    sealed class State {
        data class Display(
            val user: User,
        ) : State()

        object Loading : State()
    }

    override fun onEvent(event: Event) {
        when (val currentState = _currentState.value) {
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

                    _currentState.postValue(
                        state.copy(
                            user = newUser
                        )
                    )

                    saveUserUseCase.execute(newUser)
                    dailyUpdateHandler.update(Unit)
                }
            }
            is Event.ColorSchemeChanged -> viewModelScope.launch {
                themeDataStore.saveStyle(event.scheme.name)
            }
        }
    }
}
