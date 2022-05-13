package com.mightyhedgehog.doplanner.presentation.screen.daily.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import com.mightyhedgehog.doplanner.domain.model.task.Priority
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.domain.usecase.task.AddTaskUseCase
import com.mightyhedgehog.doplanner.ext.emptyString
import com.mightyhedgehog.doplanner.presentation.screen.calendar.CalendarUpdateHandler
import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyUpdateHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddTaskScreenViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val dailyUpdateHandler: DailyUpdateHandler,
    private val calendarUpdateHandler: CalendarUpdateHandler,
) : StatefulViewModel<AddTaskScreenViewModel.Event>() {

    private val _currentState: MutableLiveData<State> =
        MutableLiveData(State.Display())
    val currentState: LiveData<State> = _currentState

    sealed class State {
        data class Display(
            val taskTitle: String = emptyString(),
            val taskDescription: String = emptyString(),
            val date: LocalDate? = null,
            val time: LocalTime? = null,
            val taskPriority: Priority = Priority.LOW
        ) : State()

        data class SaveProcess(
            val task: Task,
        ) : State()

        object Success : State()
    }

    sealed class Event {
        data class TitleChanged(val title: String) : Event()
        data class DescriptionChanged(val description: String) : Event()
        data class DateChanged(val date: LocalDate) : Event()
        data class TimeChanged(val time: LocalTime) : Event()
        data class PriorityChanged(val priority: Priority) : Event()

        object AddTaskButtonClicked : Event()
        object SaveTask : Event()
    }

    override fun onEvent(event: Event) {
        when (val currentState = _currentState.value) {
            is State.Display -> reduce(event, currentState)
            is State.SaveProcess -> reduce(event, currentState)
        }
    }

    private fun reduce(event: Event, currentState: State.Display) {
        when (event) {
            is Event.DateChanged -> _currentState.postValue(
                currentState.copy(date = event.date)
            )
            is Event.TimeChanged -> _currentState.postValue(
                currentState.copy(time = event.time)
            )
            is Event.DescriptionChanged -> _currentState.postValue(
                currentState.copy(taskDescription = event.description)
            )
            is Event.PriorityChanged -> _currentState.postValue(
                currentState.copy(taskPriority = event.priority)
            )
            is Event.TitleChanged -> _currentState.postValue(
                currentState.copy(taskTitle = event.title)
            )
            Event.AddTaskButtonClicked -> {
                val task = createTaskFromState()
                _currentState.postValue(State.SaveProcess(task))
            }
        }
    }

    private fun reduce(event: Event, currentState: State.SaveProcess) {
        when (event) {
            Event.SaveTask -> {
                viewModelScope.launch {
                    addTaskUseCase.execute(currentState.task)
                    dailyUpdateHandler.update(Unit)
                    calendarUpdateHandler.update(Unit)

                    _currentState.postValue(State.Success)
                }
            }
        }
    }

    private fun createTaskFromState(): Task {
        val currentState = currentState.value!! as State.Display
        val dateTime = LocalDateTime.of(currentState.date, currentState.time)

        return Task(
            id = UUID.randomUUID().toString(),
            name = currentState.taskTitle,
            description = currentState.taskDescription,
            date = dateTime,
            priority = currentState.taskPriority
        )
    }
}
