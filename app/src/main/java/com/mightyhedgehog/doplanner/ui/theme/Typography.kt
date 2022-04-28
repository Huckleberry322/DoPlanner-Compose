package com.mightyhedgehog.doplanner.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mightyhedgehog.doplanner.R

val fonts = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_light, weight = FontWeight.Light),
    Font(R.font.roboto_thin, weight = FontWeight.Thin),
    Font(R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
)

val doPlannerTypography = DoPlannerTypography(
    taskPriorityStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 13.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    taskTitleStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    taskDescriptionStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light
    ),
    taskDateStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    ),
    dailyTitlesStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 25.sp,
        fontWeight = FontWeight.Light
    ),
    dailyEmptyLists = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light
    ),
    welcomeBarStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 23.sp,
        fontWeight = FontWeight.Light
    ),
    calendarTitleStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    calendarWeekHeaderStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
    ),
    calendarCardTitle = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    calendarCardDescription = TextStyle(
        fontFamily = fonts,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    ),
    calendarCardTime = TextStyle(
        fontFamily = fonts,
        fontSize = 18.sp,
        fontWeight = FontWeight.Light
    ),
    calendarEmptyList = TextStyle(
        fontFamily = fonts,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    ),
    settingsTitleStyle = TextStyle(
        fontFamily = fonts,
        fontSize = 25.sp,
        fontWeight = FontWeight.Light
    ),
)
