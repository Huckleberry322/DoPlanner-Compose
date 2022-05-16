package com.mightyhedgehog.doplanner.presentation.ui.theme

import androidx.compose.ui.graphics.Color

val baseLightPalette = DoPlannerColors(
    black = Color.Black,
    white = Color.White,
    backgroundWhite = Color(0xFFFCFCFF),
    grey = Color(0xFF7E7E7E),
    mainColor = Color(0xFFFF7300),
    secondaryColor = Color(0xFFFFAE6C),
    red = Color(0xFFB90000),
    blue = Color(0xFF0943D6),
    green = Color(0xFF33CE08),
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
    secondaryColor = Color(0xFFFFAE6C),
    red = Color(0xFFB90000),
    blue = Color(0xFF0943D6),
    green = Color(0xFF33CE08),
    taskCardRed = Color(0xFFFFE2E1),
    taskCardBlue = Color(0xFFD3E8FF),
    taskCardPurple = Color(0xFFF1E5FF),
    taskPriorityHigh = Color(0xFFFF2A2A),
    taskPriorityMedium = Color(0xFF4F9DFF),
    taskPriorityLow = Color(0xFFEA80FC),
)

val orangeLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFFFF7300),
    secondaryColor = Color(0xFFFFAE6C),
)

val orangeDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFFFF7300),
    secondaryColor = Color(0xFFFFAE6C),
)

val blueLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFF7AD9FF),
    secondaryColor = Color(0xFFC4EEFF),
)

val blueDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFF7AD9FF),
    secondaryColor = Color(0xFFC4EEFF),
)

val pinkLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFFFF8BD8),
    secondaryColor = Color(0xFFFFCFEF),
)

val pinkDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFFFF8BD8),
    secondaryColor = Color(0xFFFFCFEF),
)

val purpleLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFFAC36FF),
    secondaryColor = Color(0xFFCF8BFF),
)

val purpleDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFFAC36FF),
    secondaryColor = Color(0xFFCF8BFF),
)

val greenLightPalette = baseLightPalette.copy(
    mainColor = Color(0xFF64E096),
    secondaryColor = Color(0xFF9EE6BB),
)

val greenDarkPalette = baseDarkPalette.copy(
    mainColor = Color(0xFF64E096),
    secondaryColor = Color(0xFF9EE6BB),
)
