package com.mightyhedgehog.doplanner.ui.theme.style

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DoPlannerStyleImpl @Inject constructor(
    @ApplicationContext context: Context
) : UserSettings {

    override val styleStream: MutableStateFlow<DoPlannerStyle>
    override val style: DoPlannerStyle

    init {
        styleStream
    }
}