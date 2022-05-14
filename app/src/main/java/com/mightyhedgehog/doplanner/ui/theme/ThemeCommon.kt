package com.mightyhedgehog.doplanner.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

enum class DoPlannerStyle {
    ORANGE, BLUE, PINK, PURPLE, GREEN
}

@Immutable
data class DoPlannerColors(
    val black: Color,
    val white: Color,
    val backgroundWhite: Color,
    val grey: Color,
    val mainColor: Color,
    val secondaryColor: Color,
    val red: Color,
    val blue: Color,
    val green: Color,
    val taskCardRed: Color,
    val taskCardBlue: Color,
    val taskCardPurple: Color,
    val taskPriorityHigh: Color,
    val taskPriorityMedium: Color,
    val taskPriorityLow: Color,
)

@Immutable
data class DoPlannerTypography(
    val taskPriorityStyle: TextStyle,
    val taskTitleStyle: TextStyle,
    val taskDescriptionStyle: TextStyle,
    val taskDateStyle: TextStyle,
    val dailyTitlesStyle: TextStyle,
    val dailyEmptyLists: TextStyle,
    val welcomeBarStyle: TextStyle,
    val calendarTitleStyle: TextStyle,
    val calendarWeekHeaderStyle: TextStyle,
    val calendarCardTitle: TextStyle,
    val calendarCardDescription: TextStyle,
    val calendarCardTime: TextStyle,
    val calendarEmptyList: TextStyle,
    val settingsTitleStyle: TextStyle,
    val dialogStyle: TextStyle,
)

@Immutable
data class DoPlannerShape(
    val standardCardShape: Dp,
    val calendarButtonShape: Dp,
    val calendarCardShape: Dp,
    val floatingButtonShape: Dp,
    val colorSchemeCardShape: Dp,
)

object DoPlannerTheme {
    val colors: DoPlannerColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDoPlannerColors.current

    val typography: DoPlannerTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDoPlannerTypography.current

    val shapes: DoPlannerShape
        @Composable
        @ReadOnlyComposable
        get() = LocalDoPlannerShapes.current
}

val LocalDoPlannerColors = staticCompositionLocalOf<DoPlannerColors> {
    error("No colors provided")
}

val LocalDoPlannerTypography = staticCompositionLocalOf<DoPlannerTypography> {
    error("No typography provided")
}

val LocalDoPlannerShapes = staticCompositionLocalOf<DoPlannerShape> {
    error("No shapes provided")
}
