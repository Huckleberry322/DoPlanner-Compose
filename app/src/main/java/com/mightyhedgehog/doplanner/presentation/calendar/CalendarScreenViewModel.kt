package com.mightyhedgehog.doplanner.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.domain.usecase.task.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CalendarScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase
) : StatefulViewModel<CalendarScreenViewModel.Event>() {

    private val _currentState: MutableLiveData<State> =
        MutableLiveData(State.Loading)
    val currentState: LiveData<State> = _currentState

    init {
        viewModelScope.launch {
            val taskList = getTasksUseCase.execute()

            _currentState.postValue(
                State.Display(
                    taskList = taskList,
                    dayTaskList = getDateTasks(
                        taskList = taskList,
                        date = State.Display().currentDate
                    )
                )
            )
        }
    }

    sealed class State {
        data class Display(
            val currentDate: LocalDate = LocalDate.now(),
            val taskList: List<Task> = emptyList(),
            val dayTaskList: List<Task> = emptyList(),
        ) : State()

        object Loading : State()
    }

    sealed class Event {
        data class DateChanged(val date: LocalDate) : Event()
    }

    override fun onEvent(event: Event) {
        when (val currentState = _currentState.value) {
            is State.Display -> reduceEvent(event, currentState)
        }
    }

    private fun reduceEvent(event: Event, state: State.Display) {
        when (event) {
            is Event.DateChanged -> {

                _currentState.postValue(
                    state.copy(
                        currentDate = event.date,
                        dayTaskList = getDateTasks(state.taskList, date = event.date)
                    )
                )
            }
        }
    }

    private fun getDateTasks(taskList: List<Task>, date: LocalDate) = taskList.mapNotNull {
        if (it.date.toLocalDate() == date) {
            it
        } else null
    }
}
