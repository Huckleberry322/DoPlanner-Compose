package com.mightyhedgehog.doplanner.ui.theme.style

import kotlinx.coroutines.flow.StateFlow

enum class DoPlannerStyle {
    ORANGE, BLUE, PINK, PURPLE, GREEN
}

interface UserSettings {
    val styleStream: StateFlow<DoPlannerStyle>
    val style: DoPlannerStyle
}
