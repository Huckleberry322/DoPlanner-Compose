package com.mightyhedgehog.doplanner.ui.compoments.daily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun TodayTasksTitle(count: Int, modifier: Modifier = Modifier) {
    Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
        modifier = modifier,
        text = buildAnnotatedString {
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("$count Tasks ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.Light))
            append("today")
        })
}

@Composable
@Preview
fun TodayTasksTitlePreview() {
    DoPlannerTheme {
        Text(style = DoPlannerTheme.typography.dailyTitlesStyle,
            text = buildAnnotatedString {
                pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
                append("4 Tasks ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.Light))
                append("today")
            })
    }
}

@Composable
fun AllTasksTitle(count: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(style = DoPlannerTheme.typography.dailyTitlesStyle, text = buildAnnotatedString {
            pushStyle(style = SpanStyle(fontWeight = FontWeight.Light))
            append("To ")
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("Do")
        })
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .height(25.dp)
                .width(25.dp)
                .clip(CircleShape)
                .background(DoPlannerTheme.colors.mainColor.copy(alpha = 0.1F)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                style = DoPlannerTheme.typography.dailyTitlesStyle,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                text = count.toString()
            )
        }
    }
}

@Composable
@Preview
fun AllTasksTitlePreview() {
    DoPlannerTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(style = DoPlannerTheme.typography.dailyTitlesStyle, text = buildAnnotatedString {
                pushStyle(style = SpanStyle(fontWeight = FontWeight.Light))
                append("To ")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
                append("Do")
            })
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
                    .clip(CircleShape)
                    .background(DoPlannerTheme.colors.mainColor.copy(alpha = 0.1F)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    style = DoPlannerTheme.typography.dailyTitlesStyle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    text = "3"
                )
            }
        }
    }
}

@Composable
fun CompletedTasksTitle(count: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(style = DoPlannerTheme.typography.dailyTitlesStyle, text = buildAnnotatedString {
            pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
            append("Completed")
        })
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier
                .height(25.dp)
                .width(25.dp)
                .clip(CircleShape)
                .background(DoPlannerTheme.colors.taskPriorityLow.copy(alpha = 0.1F)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                style = DoPlannerTheme.typography.dailyTitlesStyle,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                text = count.toString()
            )
        }
    }
}

@Composable
@Preview
fun CompletedTasksTitlePreview() {
    DoPlannerTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(style = DoPlannerTheme.typography.dailyTitlesStyle, text = buildAnnotatedString {
                pushStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold))
                append("Completed")
            })
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
                    .clip(CircleShape)
                    .background(DoPlannerTheme.colors.taskPriorityLow.copy(alpha = 0.1F)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    style = DoPlannerTheme.typography.dailyTitlesStyle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    text = "6"
                )
            }
        }
    }
}
