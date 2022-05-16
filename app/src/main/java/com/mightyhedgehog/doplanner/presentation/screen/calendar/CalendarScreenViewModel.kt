package com.mightyhedgehog.doplanner.presentation.screen.calendar

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.BaseViewModel
import com.mightyhedgehog.doplanner.presentation.model.task.Task
import com.mightyhedgehog.doplanner.data.gateway.task.GetTasksGateway
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CalendarScreenViewModel @Inject constructor(
    private val getTasksGateway: GetTasksGateway,
    calendarUpdateHandler: CalendarUpdateHandler,
) : BaseViewModel<CalendarScreenViewModel.State, CalendarScreenViewModel.Event>(State.Loading) {

    init {
        initCalendarViewModel()
        calendarUpdateHandler.data.safeObserve { initCalendarViewModel() }
    }

    private fun initCalendarViewModel() {
        viewModelScope.launch {
            val taskList = getTasksGateway.execute()

            produceState(
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
        when (val currentState = state) {
            is State.Display -> reduceEvent(event, currentState)
        }
    }

    private fun reduceEvent(event: Event, state: State.Display) {
        when (event) {
            is Event.DateChanged -> {
                produceState(
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
