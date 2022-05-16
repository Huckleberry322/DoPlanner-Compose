package com.mightyhedgehog.doplanner.presentation.ui.compoments.screen.add

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mightyhedgehog.doplanner.presentation.ui.theme.DoPlannerTheme

@Composable
fun AddTaskTitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        style = DoPlannerTheme.typography.dailyTitlesStyle,
        text = buildAnnotatedString {
            append("Create\nNew ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("Task")
        }
    )
}

@Composable
@Preview
fun AddTaskTitlePreview() {
    DoPlannerTheme {
        Text(
            style = DoPlannerTheme.typography.dailyTitlesStyle,
            text = buildAnnotatedString {
                append("Create\nNew ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
                append("Task")
            }
        )
    }
}

@Composable
fun AddDescription(
    modifier: Modifier = Modifier,
    textRes: Int,
) {
    Text(
        modifier = modifier,
        text = stringResource(id = textRes),
        style = DoPlannerTheme.typography.dailyTitlesStyle,
        color = DoPlannerTheme.colors.black.copy(alpha = 0.5F),
        fontSize = 20.sp,
    )
}

@Composable
@Preview
fun AddDescriptionPreview() {
    DoPlannerTheme {
        Text(
            text = "Task title",
            style = DoPlannerTheme.typography.dailyTitlesStyle,
            color = DoPlannerTheme.colors.black.copy(alpha = 0.5F),
            fontSize = 20.sp,
        )
    }
}
