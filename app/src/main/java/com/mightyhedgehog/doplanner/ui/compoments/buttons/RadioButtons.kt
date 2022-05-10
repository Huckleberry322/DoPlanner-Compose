package com.mightyhedgehog.doplanner.ui.compoments.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mightyhedgehog.doplanner.domain.model.task.Priority
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun PriorityRadioButtons(modifier: Modifier = Modifier) {
    val priorityOptions = Priority.values()
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(priorityOptions[2]) }

    Row(modifier = modifier) {
        priorityOptions.forEach { item ->
            Row(
                modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val name = item.name.lowercase().replaceFirstChar { it.uppercase() }

                RadioButton(
                    selected = (item == selectedOption),
                    onClick = { onOptionSelected(item) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = when (item) {
                            Priority.HIGH -> DoPlannerTheme.colors.taskPriorityHigh
                            Priority.MEDIUM -> DoPlannerTheme.colors.taskPriorityMedium
                            Priority.LOW -> DoPlannerTheme.colors.taskPriorityLow
                        },
                        unselectedColor = when (item) {
                            Priority.HIGH -> DoPlannerTheme.colors.taskPriorityHigh
                            Priority.MEDIUM -> DoPlannerTheme.colors.taskPriorityMedium
                            Priority.LOW -> DoPlannerTheme.colors.taskPriorityLow
                        },
                    ),
                    interactionSource = remember { DisabledInteractionSource() }
                )

                ClickableText(
                    text = buildAnnotatedString {
                        pushStyle(SpanStyle(fontSize = 18.sp))
                        append(name)
                    },
                    onClick = {
                        onOptionSelected(item)
                    },
                    style = DoPlannerTheme.typography.dailyTitlesStyle,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PriorityRadioButtonsPreview() {
    DoPlannerTheme {
        val radioOptions = listOf("High", "Low", "Medium")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
        Row {
            radioOptions.forEach { item ->
                Row(
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (item == selectedOption),
                        onClick = { onOptionSelected(item) }
                    )

                    ClickableText(
                        text = buildAnnotatedString {
                            append(item)
                        },
                        onClick = {
                            onOptionSelected(item)
                        },
                        style = DoPlannerTheme.typography.dailyTitlesStyle
                    )
                }
            }
        }
    }
}