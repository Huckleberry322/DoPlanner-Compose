package com.mightyhedgehog.doplanner.presentation.screen.daily

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.domain.model.user.User
import com.mightyhedgehog.doplanner.domain.usecase.task.*
import com.mightyhedgehog.doplanner.domain.usecase.user.GetUserUseCase
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
    dailyUpdateHandler: DailyUpdateHandler,
) : StatefulViewModel<DailyScreenViewModel.Event>() {

    private val _currentState: MutableLiveData<State> =
        MutableLiveData(State.Loading)
    val currentState: LiveData<State> = _currentState

    init {
        fetchTasksData()
        dailyUpdateHandler.data.safeObserve { fetchTasksData() }
    }

    private fun fetchTasksData() {
        viewModelScope.launch {
            _currentState.postValue(State.Loading)

            val taskList = getTasksUseCase.execute().reversed()
            val completedTaskList = getCompletedTasksUseCase.execute().reversed()
            val user = getUserUseCase.execute()
            val todayTaskList = taskList.mapNotNull {
                if (it.date.toLocalDate()
                    == LocalDate.now()
                ) {
                    it
                } else null
            }

            _currentState.postValue(
                State.Display(
                    user = user,
                    tasks = taskList,
                    dailyTasks = todayTaskList,
                    completedTasks = completedTaskList,
                )
            )
        }
    }

    sealed class State {
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
        when (val currentState = _currentState.value) {
            is State.Display -> reduce(event, currentState)
        }
    }

    private fun reduce(event: Event, currentState: State.Display) {
        when (event) {
            is Event.CompleteTask -> viewModelScope.launch {
                completeTaskUseCase.execute(event.task)
                fetchTasksData()
            }
            is Event.DeleteCompletedTask -> viewModelScope.launch {
                deleteCompletedTaskUseCase.execute(event.task)
                fetchTasksData()
            }
            is Event.DeleteTask -> viewModelScope.launch {
                deleteTaskUseCase.execute(event.task)
                fetchTasksData()
            }
        }
    }
}
