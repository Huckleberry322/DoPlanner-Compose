package com.mightyhedgehog.doplanner.app.core

import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel<State : Any, Event : Any>(private val defaultState: State) :
    AutoObserverViewModel(), EventHandler<Event> {

    val stateData: MutableLiveData<State> = MutableLiveData(defaultState)

    private var _state: State = defaultState

    val state: State get() = _state

    fun produceState(state: State) {
        this._state = state
        stateData.postValue(state)
    }

    fun getDefaultState() = defaultState
}
