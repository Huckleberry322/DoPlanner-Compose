package com.mightyhedgehog.doplanner.presentation.screen.daily

import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.BaseViewModel
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.domain.model.user.User
import com.mightyhedgehog.doplanner.domain.usecase.task.*
import com.mightyhedgehog.doplanner.domain.usecase.user.GetUserUseCase
import com.mightyhedgehog.doplanner.presentation.screen.calendar.CalendarUpdateHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DailyScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val getCompletedTasksUseCase: GetCompletedTasksUseCase,
    private val completeTaskUseCase: CompleteTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val deleteCompletedTaskUseCase: DeleteCompletedTaskUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val calendarUpdateHandler: CalendarUpdateHandler,
    dailyUpdateHandler: DailyUpdateHandler,
) : BaseViewModel<DailyScreenViewModel.State, DailyScreenViewModel.Event>(State.Loading) {

    init {
        fetchTasksData()
        dailyUpdateHandler.data.safeObserve { fetchTasksData() }
    }

    private fun fetchTasksData() {
        viewModelScope.launch {
            produceState(State.Loading)

            val taskList = getTasksUseCase.execute().reversed()
            val completedTaskList = getCompletedTasksUseCase.execute().reversed()
            val user = getUserUseCase.execute()
            val todayTaskList = taskList.mapNotNull {
                if (it.date.toLocalDate() == LocalDate.now()) it else null
            }

            produceState(
                State.Display(
                    user = user,
                    tasks = taskList,
                    dailyTasks = todayTaskList,
                    completedTasks = completedTaskList,
                )
            )
        }
    }

    open class State {
        data class Display(
            val user: User,
            val tasks: List<Task>,
            val dailyTasks: List<Task>,
            val completedTasks: List<Task>,
        ) : State()

        object Loading : State()
    }

    sealed class Event {
        data class CompleteTask(val task: Task) : Event()
        data class DeleteTask(val task: Task) : Event()

        data class DeleteCompletedTask(val task: Task) : Event()
    }

    override fun onEvent(event: Event) {
        when (val currentState = state) {
            is State.Display -> reduce(event, currentState)
        }
    }

    private fun reduce(event: Event, currentState: State.Display) {
        when (event) {
            is Event.CompleteTask -> viewModelScope.launch {
                completeTaskUseCase.execute(event.task)
                calendarUpdateHandler.update(Unit)
                fetchTasksData()
            }
            is Event.DeleteCompletedTask -> viewModelScope.launch {
                deleteCompletedTaskUseCase.execute(event.task)
                calendarUpdateHandler.update(Unit)
                fetchTasksData()
            }
            is Event.DeleteTask -> viewModelScope.launch {
                deleteTaskUseCase.execute(event.task)
                calendarUpdateHandler.update(Unit)
                fetchTasksData()
            }
        }
    }
}
