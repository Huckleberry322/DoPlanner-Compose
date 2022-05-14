package com.mightyhedgehog.doplanner.app.core

import androidx.lifecycle.LiveData

interface UpdateHandler<T> {

    val data: LiveData<T>

    fun update(value: T)
}
