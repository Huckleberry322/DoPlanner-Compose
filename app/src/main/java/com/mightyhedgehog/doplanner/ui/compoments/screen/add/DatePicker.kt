package com.mightyhedgehog.doplanner.ui.compoments.screen.add

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.ext.noRippleClickable
import com.mightyhedgehog.doplanner.ext.toString
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Composable
fun DatePickerField(
    modifier: Modifier = Modifier,
    date: LocalDate? = null,
    dividerThickness: Dp,
    onDateChanged: (LocalDate) -> Unit,
) {
    var selectedDate by remember { mutableStateOf(date) }

    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            val mDate = LocalDate.of(mYear, mMonth + 1, mDayOfMonth)
            selectedDate = mDate
            onDateChanged(mDate)
        }, year, month, day
    )

    Column(
        modifier = modifier.noRippleClickable {
            mDatePickerDialog.show()
        },
    ) {
        val pattern = "MMM d, yyyy"

        val textColor = if (date != null) {
            DoPlannerTheme.colors.black
        } else {
            DoPlannerTheme.colors.black.copy(alpha = 0.2F)
        }

        Text(
            text = selectedDate?.toString(pattern) ?: stringResource(id = R.string.date_hint),
            color = textColor
        )
        Divider(
            modifier = Modifier.padding(top = 8.dp),
            thickness = dividerThickness,
        )
    }
}

@Composable
fun TimePickerField(
    modifier: Modifier = Modifier,
    time: LocalTime? = null,
    dividerThickness: Dp,
    onTimeChanged: (LocalTime) -> Unit,
) {
    var selectedTime by remember { mutableStateOf(time) }

    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val mTimePickerDialog = TimePickerDialog(
        context,
        { _, hHour: Int, mMinute: Int ->
            val mTime = LocalTime.of(hHour, mMinute)
            selectedTime = mTime
            onTimeChanged(mTime)
        }, hour, minute, false
    )

    Column(
        modifier = modifier.noRippleClickable {
            mTimePickerDialog.show()
        },
    ) {
        val pattern = "HH:mm"
        val textColor = if (selectedTime != null) {
            DoPlannerTheme.colors.black
        } else {
            DoPlannerTheme.colors.black.copy(alpha = 0.2F)
        }

        Text(
            text = selectedTime?.toString(pattern) ?: stringResource(id = R.string.time_hint),
            color = textColor
        )
        Divider(
            modifier = Modifier.padding(top = 8.dp),
            thickness = dividerThickness,
        )
    }
}

@Composable
@Preview
fun DateTimePickerFieldPreview() {
    DoPlannerTheme {
        val date: LocalDate? = null
        val pattern = "MMM d, yyyy"

        Column {
            Text(
                text = date?.toString(pattern) ?: stringResource(id = R.string.date_hint),
                color = DoPlannerTheme.colors.black.copy(alpha = 0.2F)
            )
            Divider(
                modifier = Modifier.padding(top = 8.dp),
                thickness = 0.5.dp
            )
        }
    }
}

@Composable
fun MyTimePicker() {
    AndroidView({ TimePicker(it) },
        Modifier.wrapContentSize(),
        update = { view ->
            view.setOnTimeChangedListener { _, hour, min ->
                // do something with the time
            }
        }
    )
}