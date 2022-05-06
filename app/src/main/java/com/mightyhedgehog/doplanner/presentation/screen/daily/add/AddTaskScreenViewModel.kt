package com.mightyhedgehog.doplanner.presentation.screen.daily.add

import com.mightyhedgehog.doplanner.app.core.StatefulViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddTaskScreenViewModel @Inject constructor(

) : StatefulViewModel<AddTaskScreenViewModel.Event>() {

    class State

    sealed class Event

    override fun onEvent(event: Event) {
        TODO("Not yet implemented")
    }
}
