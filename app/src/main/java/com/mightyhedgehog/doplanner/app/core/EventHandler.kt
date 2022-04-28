package com.mightyhedgehog.doplanner.app.core

interface EventHandler<T> {
    fun onEvent(event: T)
}
