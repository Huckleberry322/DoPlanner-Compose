package com.mightyhedgehog.doplanner.app.navigation

private const val DAILY_SCREEN_ROUTE = "daily_screen"
private const val SETTINGS_SCREEN_ROUTE = "settings_screen"
private const val CALENDAR_SCREEN_ROUTE = "calendar_screen"

sealed class Screens(val route: String) {
    object DailyScreen : Screens(DAILY_SCREEN_ROUTE)
    object SettingsScreen: Screens(SETTINGS_SCREEN_ROUTE)
    object CalendarScreen: Screens(CALENDAR_SCREEN_ROUTE)
}
