package com.mightyhedgehog.doplanner.presentation.screen.daily

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.domain.model.user.User
import com.mightyhedgehog.doplanner.domain.usecase.task.GetCompletedTasksUseCase
import com.mightyhedgehog.doplanner.domain.usecase.task.GetTasksUseCase
import com.mightyhedgehog.doplanner.domain.usecase.user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DailyScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val getCompletedTasksUseCase: GetCompletedTasksUseCase,
    private val getUserUseCase: GetUserUseCase,
    dailyUpdateHandler: DailyUpdateHandler,
) : StatefulViewModel<DailyScreenViewModel.Event>() {

    private val _currentState: MutableLiveData<State> =
        MutableLiveData(State.Loading)
    val currentState: LiveData<State> = _currentState

    init {
        initDailyViewModel()
        dailyUpdateHandler.data.safeObserve { initDailyViewModel() }
    }

    private fun initDailyViewModel() {
        viewModelScope.launch {
            val taskList = getTasksUseCase.execute()
            val completedTaskList = getCompletedTasksUseCase.execute()
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

    sealed class Event

    override fun onEvent(event: Event) {

    }
}
