package com.mightyhedgehog.doplanner.app.navigation

import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.app.navigation.graph.DAILY_SCREEN_NESTED_GRAPH
import com.mightyhedgehog.doplanner.app.navigation.graph.SETTINGS_SCREEN_NESTED_GRAPH
import com.mightyhedgehog.doplanner.app.navigation.graph.CALENDAR_SCREEN_NESTED_GRAPH

private const val DAILY_BAR_NAME = "Daily"
private const val SETTINGS_BAR_NAME = "Settings"
private const val CALENDAR_BAR_NAME = "Calendar"

sealed class BottomBarGraph(
    val route: String,
    val title: String,
    val icon: Int
) {
    object DailyGraph : BottomBarGraph(
        route = DAILY_SCREEN_NESTED_GRAPH,
        title = DAILY_BAR_NAME,
        icon = R.drawable.ic_bar_daily
    )

    object CalendarGraph : BottomBarGraph(
        route = CALENDAR_SCREEN_NESTED_GRAPH,
        title = CALENDAR_BAR_NAME,
        icon = R.drawable.ic_calendar,
    )

    object SettingsGraph : BottomBarGraph(
        route = SETTINGS_SCREEN_NESTED_GRAPH,
        title = SETTINGS_BAR_NAME,
        icon = R.drawable.ic_bar_settings,
    )
}
