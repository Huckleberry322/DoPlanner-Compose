package com.mightyhedgehog.doplanner.presentation.screen.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mightyhedgehog.doplanner.app.core.UpdateHandler

class CalendarUpdateHandler: UpdateHandler<Unit> {
    override val data: LiveData<Unit> = MutableLiveData()

    override fun update(value: Unit) {
        (data as MutableLiveData).postValue(Unit)
    }
}
