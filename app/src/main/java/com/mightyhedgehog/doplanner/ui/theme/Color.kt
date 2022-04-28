package com.mightyhedgehog.doplanner.ui.theme

import androidx.compose.ui.graphics.Color

val baseLightPalette = DoPlannerColors(
    black = Color.Black,
    white = Color.White,
    backgroundWhite = Color(0xFFFCFCFF),
    grey = Color(0xFF7E7E7E),
    mainColor = Color(0xFFFF7300),
    secondOrange = Color(0xFFFFAE6C),
    redBackground = Color(0xFFB90000),
    blueBackground = Color(0xFF0943D6),
    greenBackground = Color(0xFF33CE08),
    taskCardRed = Color(0xFFFFE2E1),
    taskCardBlue = Color(0xFFD3E8FF),
    taskCardPurple = Color(0xFFF1E5FF),
    taskPriorityHigh = Color(0xFFFF2A2A),
    taskPriorityMedium = Color(0xFF4F9DFF),
    taskPriorityLow = Color(0xFFEA80FC),
)

val baseDarkPalette = DoPlannerColors(
    black = Color.Black,
    white = Color.White,
    backgroundWhite = Color(0xFFFCFCFF),
    grey = Color(0xFF7E7E7E),
    mainColor = Color(0xFFFF7300),
    secondOrange = Color(0xFFFFAE6C),
    redBackground = Color(0xFFB90000),
    blueBackground = Color(0xFF0943D6),
    greenBackground = Color(0xFF33CE08),
    taskCardRed = Color(0xFFFFE2E1),
    taskCardBlue = Color(0xFFD3E8FF),
    taskCardPurple = Color(0xFFF1E5FF),
    taskPriorityHigh = Color(0xFFFF2A2A),
    taskPriorityMedium = Color(0xFF4F9DFF),
    taskPriorityLow = Color(0xFFEA80FC),
)

val orangeLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFFFF7300),
)

val orangeDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFFFF7300),
)

val blueLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFF7AD9FF),
)

val blueDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFF7AD9FF),
)

val pinkLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFFFF8BD8),
)

val pinkDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFFFF8BD8),
)

val purpleLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFFAC36FF),
)

val purpleDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFFAC36FF),
)

val greenLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFF64E096),
)

val greenDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFF64E096),
)
