package com.mightyhedgehog.doplanner.app.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

abstract class AutoObserverViewModel : ViewModel() {

    private val observerMap: HashMap<LiveData<*>, MutableSet<Observer<Any>>> = hashMapOf()

    fun <T : Any> LiveData<T>.safeObserve(action: (data: T) -> Unit) {
        val observer = Observer<T> { action.invoke(it) }
        observeForever(observer)
        val list = observerMap[this] ?: mutableSetOf()
        list.add(observer as Observer<Any>)
        observerMap[this] = list
    }

    override fun onCleared() {
        super.onCleared()
        observerMap.forEach { entry ->
            entry.value.forEach {
                entry.key.removeObserver(it)
            }
        }
    }
}
