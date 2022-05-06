package com.mightyhedgehog.doplanner.presentation.handler

import androidx.lifecycle.LiveData

interface SimpleHandler<T> {

    val data: LiveData<T>

    fun update(value: T)
}
