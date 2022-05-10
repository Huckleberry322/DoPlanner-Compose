package com.mightyhedgehog.doplanner.ui.compoments.screen.calendar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.domain.model.task.Priority
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.header.MonthState
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.TextStyle
import java.util.*

@Composable
fun DoPlannerCalendar(
    modifier: Modifier,
    onSelectionChanged: (LocalDate) -> Unit,
    today: LocalDate = LocalDate.now(),
    taskList: List<Task>,
) {
    val calendarState = rememberSelectableCalendarState(
        onSelectionChanged = { selection -> onSelectionChanged(selection.map { it }.first()) },
        initialSelectionMode = SelectionMode.Single,
    )

    SelectableCalendar(
        modifier = modifier,
        calendarState = calendarState,
        today = today,
        horizontalSwipeEnabled = false,
        weekHeader = { CalendarWeekHeader(daysOfWeek = it) },
        monthHeader = { CalendarMonthHeader(monthState = it) },
        dayContent = { dayState ->
            CalendarDayContent(
                dayState = dayState,
                task = taskList.firstOrNull { it.date.toLocalDate() == dayState.date },
            )
        },
    )
}

@Composable
@Preview(showBackground = true)
fun DoPlannerCalendarPreview() {
    DoPlannerTheme {
        val calendarState = rememberSelectableCalendarState()

        SelectableCalendar(
            modifier = Modifier
                .animateContentSize()
                .padding(start = 25.dp, end = 25.dp),
            calendarState = calendarState,
            weekHeader = { CalendarWeekHeader(daysOfWeek = it) },
            monthHeader = { CalendarMonthHeader(monthState = it) },
            dayContent = { dayState ->
                CalendarDayContent(
                    dayState = dayState,
                    task = Task(
                        id = 0,
                        name = "",
                        description = null,
                        date = LocalDateTime.now(),
                        priority = Priority.MEDIUM,
                    ),
                )
            },
        )
    }
}

@Composable
private fun CalendarDayContent(dayState: DayState<DynamicSelectionState>, task: Task?) {
    val interactionSource = remember { MutableInteractionSource() }
    val date = dayState.date
    val selectionState = dayState.selectionState

    val isSelected = selectionState.isDateSelected(date)

    val contentBorderColor by animateColorAsState(
        when {
            dayState.isCurrentDay -> {
                DoPlannerTheme.colors.mainColor
            }
            isSelected -> {
                DoPlannerTheme.colors.mainColor.copy(alpha = 0.5F)
            }
            else -> DoPlannerTheme.colors.backgroundWhite
        }
    )
    val contentNumberColor by animateColorAsState(
        when {
            dayState.isFromCurrentMonth && dayState.isCurrentDay -> DoPlannerTheme.colors.white
            isSelected -> DoPlannerTheme.colors.mainColor
            !dayState.isFromCurrentMonth -> DoPlannerTheme.colors.black.copy(alpha = 0.4F)
            else -> DoPlannerTheme.colors.black
        }
    )

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(41.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    if (!selectionState.isDateSelected(date)) {
                        selectionState.onDateSelected(date)
                    }
                }
            ),
        shape = RoundedCornerShape(DoPlannerTheme.shapes.calendarButtonShape),
        border = BorderStroke(1.dp, contentBorderColor),
        backgroundColor = if (dayState.isCurrentDay) DoPlannerTheme.colors.secondaryColor
        else Color.Transparent,
        elevation = when {
            dayState.isCurrentDay -> {
                1.dp
            }
            else -> 0.dp
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(0.5F))
            Text(
                modifier = Modifier.weight(2F),
                text = date.dayOfMonth.toString(),
                textAlign = TextAlign.Center,
                style = DoPlannerTheme.typography.calendarWeekHeaderStyle,
                color = contentNumberColor
            )
            Icon(
                modifier = Modifier
                    .size(5.dp)
                    .alpha(if (task != null) 1F else 0F),
                painter = painterResource(id = R.drawable.ic_calendar_dot),
                contentDescription = null,
                tint = DoPlannerTheme.colors.mainColor,
            )
        }
    }
}

@Composable
private fun CalendarMonthHeader(monthState: MonthState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 35.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PreviousMonthButton(onClick = {
            monthState.currentMonth = monthState.currentMonth.minusMonths(1)
        })
        Text(text = buildAnnotatedString {
            append(
                "${
                    monthState.currentMonth.month.toString().lowercase()
                        .replaceFirstChar { it.uppercase() }
                } ${monthState.currentMonth.year}"
            )
        }, style = DoPlannerTheme.typography.calendarTitleStyle)
        NextMonthButton(onClick = {
            monthState.currentMonth = monthState.currentMonth.plusMonths(1)
        })
    }
}

@Composable
private fun CalendarWeekHeader(daysOfWeek: List<DayOfWeek>) {
    Row {
        daysOfWeek.forEach { dayOfWeek ->
            Text(
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ROOT),
                style = DoPlannerTheme.typography.calendarWeekHeaderStyle,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),
                color = DoPlannerTheme.colors.black.copy(alpha = 0.4F)
            )
        }
    }
}
