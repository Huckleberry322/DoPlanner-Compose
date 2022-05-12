package com.mightyhedgehog.doplanner.ui.compoments.screen.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mightyhedgehog.doplanner.R
import com.mightyhedgehog.doplanner.data.mapper.task.priorityToString
import com.mightyhedgehog.doplanner.domain.model.task.Priority
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.ext.toString
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme

@Composable
fun TodayTaskCard(task: Task, modifier: Modifier) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(250.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.standardCardShape),
        backgroundColor = when (task.priority) {
            Priority.HIGH -> DoPlannerTheme.colors.taskCardRed
            Priority.MEDIUM -> DoPlannerTheme.colors.taskCardBlue
            Priority.LOW -> DoPlannerTheme.colors.taskCardPurple
        }
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = priorityToString(task.priority),
                color = when (task.priority) {
                    Priority.HIGH -> DoPlannerTheme.colors.taskPriorityHigh
                    Priority.MEDIUM -> DoPlannerTheme.colors.taskPriorityMedium
                    Priority.LOW -> DoPlannerTheme.colors.taskPriorityLow
                },
                style = DoPlannerTheme.typography.taskPriorityStyle,
            )
            Text(
                text = task.name,
                style = DoPlannerTheme.typography.taskTitleStyle,
                modifier = Modifier
                    .weight(2F)
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = task.description ?: stringResource(id = R.string.empty_task_description),
                style = DoPlannerTheme.typography.taskDescriptionStyle,
                modifier = Modifier
                    .weight(3F)
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                val pattern = "MMM d, yyyy"
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_flag), contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = task.date.toString(pattern),
                    style = DoPlannerTheme.typography.taskDateStyle
                )
            }
        }
    }
}

@Composable
@Preview
fun TaskCardPreview() {
    DoPlannerTheme {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(250.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(DoPlannerTheme.shapes.standardCardShape),
            backgroundColor = DoPlannerTheme.colors.taskCardPurple
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "High",
                    color = DoPlannerTheme.colors.taskPriorityLow,
                    style = DoPlannerTheme.typography.taskPriorityStyle,
                )
                Text(
                    text = "Some theme",
                    style = DoPlannerTheme.typography.taskTitleStyle,
                    modifier = Modifier
                        .weight(2F)
                        .padding(bottom = 4.dp)
                        .fillMaxWidth(),
                    maxLines = 3
                )
                Text(
                    text = "Some description",
                    style = DoPlannerTheme.typography.taskDescriptionStyle,
                    modifier = Modifier
                        .weight(3F)
                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_flag),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "23 Apr, 2020",
                        style = DoPlannerTheme.typography.taskDateStyle
                    )
                }
            }
        }
    }
}

@Composable
fun AllTaskCard(task: Task, modifier: Modifier) {
    Card(
        modifier = modifier
            .width(120.dp)
            .height(130.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.standardCardShape),
        backgroundColor = when (task.priority) {
            Priority.HIGH -> DoPlannerTheme.colors.taskCardRed
            Priority.MEDIUM -> DoPlannerTheme.colors.taskCardBlue
            Priority.LOW -> DoPlannerTheme.colors.taskCardPurple
        }
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = priorityToString(task.priority),
                color = when (task.priority) {
                    Priority.HIGH -> DoPlannerTheme.colors.taskPriorityHigh
                    Priority.MEDIUM -> DoPlannerTheme.colors.taskPriorityMedium
                    Priority.LOW -> DoPlannerTheme.colors.taskPriorityLow
                },
                style = DoPlannerTheme.typography.taskPriorityStyle
            )
            Text(
                modifier = Modifier
                    .weight(2F)
                    .padding(bottom = 3.dp),
                text = task.name,
                style = DoPlannerTheme.typography.taskTitleStyle,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                val pattern = "MMM d, yyyy"
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_flag), contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = task.date.toString(pattern),
                    style = DoPlannerTheme.typography.taskDateStyle
                )
            }
        }
    }
}

@Composable
@Preview
fun AllTaskCardPreview() {
    DoPlannerTheme {
        Card(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(DoPlannerTheme.shapes.standardCardShape),
            backgroundColor = DoPlannerTheme.colors.taskCardRed
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "High",
                    color = DoPlannerTheme.colors.taskPriorityHigh,
                    style = DoPlannerTheme.typography.taskPriorityStyle
                )
                Text(
                    modifier = Modifier
                        .weight(2F)
                        .padding(bottom = 3.dp),
                    text = "Hello compose!",
                    style = DoPlannerTheme.typography.taskTitleStyle
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_flag),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "27 Apr, 2020",
                        style = DoPlannerTheme.typography.taskDateStyle,
                    )
                }
            }
        }
    }
}

@Composable
fun CalendarTaskCard(task: Task, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(DoPlannerTheme.shapes.calendarCardShape))
            .background(
                when (task.priority) {
                    Priority.HIGH -> DoPlannerTheme.colors.taskCardRed
                    Priority.LOW -> DoPlannerTheme.colors.taskCardPurple
                    Priority.MEDIUM -> DoPlannerTheme.colors.taskCardBlue
                }
            )
    ) {
        Box(
            modifier = Modifier
                .weight(0.5F)
                .padding(top = 10.dp, bottom = 10.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
            Box(
                modifier = Modifier
                    .height(35.dp)
                    .width(6.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        when (task.priority) {
                            Priority.HIGH -> DoPlannerTheme.colors.taskPriorityHigh
                            Priority.LOW -> DoPlannerTheme.colors.taskPriorityLow
                            Priority.MEDIUM -> DoPlannerTheme.colors.taskPriorityMedium
                        }
                    )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10F)
                .padding(top = 8.dp, bottom = 8.dp, end = 10.dp)
        ) {
            Text(
                text = task.name,
                style = DoPlannerTheme.typography.calendarCardTitle
            )
            Text(
                text = task.description ?: stringResource(id = R.string.empty_task_description),
                style = DoPlannerTheme.typography.calendarCardDescription
            )
            val datePattern = "h:mm a"
            Text(
                text = task.date.toString(datePattern),
                style = DoPlannerTheme.typography.calendarCardTime
            )
        }
    }
}

@Composable
@Preview
fun CalendarTaskCardPreview() {
    DoPlannerTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(DoPlannerTheme.shapes.calendarCardShape))
                .background(DoPlannerTheme.colors.taskCardPurple)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.5F)
                    .padding(top = 10.dp, bottom = 10.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Box(
                    modifier = Modifier
                        .height(36.dp)
                        .width(6.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(DoPlannerTheme.colors.taskPriorityLow)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(10F)
                    .padding(top = 8.dp, bottom = 8.dp, end = 10.dp)
            ) {
                Text(
                    text = "Some title for you task",
                    style = DoPlannerTheme.typography.calendarCardTitle
                )
                Text(
                    text = "Very very very very very very very very very long description for you task Very very very very very very very very very long description for you task",
                    style = DoPlannerTheme.typography.calendarCardDescription
                )
                Text(
                    text = "10:00 PM",
                    style = DoPlannerTheme.typography.calendarCardTime
                )
            }
        }
    }
}

@Composable
fun CompletedTaskCard(task: Task, modifier: Modifier) {
    Card(
        modifier = modifier
            .width(120.dp)
            .height(130.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(DoPlannerTheme.shapes.standardCardShape),
        backgroundColor = when (task.priority) {
            Priority.HIGH -> DoPlannerTheme.colors.taskCardRed
            Priority.MEDIUM -> DoPlannerTheme.colors.taskCardBlue
            Priority.LOW -> DoPlannerTheme.colors.taskCardPurple
        }
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = priorityToString(task.priority),
                color = when (task.priority) {
                    Priority.HIGH -> DoPlannerTheme.colors.taskPriorityHigh
                    Priority.MEDIUM -> DoPlannerTheme.colors.taskPriorityMedium
                    Priority.LOW -> DoPlannerTheme.colors.taskPriorityLow
                },
                style = DoPlannerTheme.typography.taskPriorityStyle
            )
            Text(
                modifier = Modifier
                    .weight(2F)
                    .padding(bottom = 3.dp),
                text = task.name,
                style = DoPlannerTheme.typography.taskTitleStyle,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                val pattern = "MMM d, yyyy"
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_flag), contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = task.date.toString(pattern),
                    style = DoPlannerTheme.typography.taskDateStyle
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DoPlannerTheme.colors.greenBackground.copy(alpha = 0.3F))
        ) {
            Image(
                modifier = Modifier.fillMaxSize().padding(14.dp),
                painter = painterResource(id = R.drawable.ic_complete),
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview
fun CompletedTaskCardPreview() {
    DoPlannerTheme {
        Card(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            elevation = 0.dp,
            shape = RoundedCornerShape(DoPlannerTheme.shapes.standardCardShape),
            backgroundColor = DoPlannerTheme.colors.taskCardRed
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "High",
                    color = DoPlannerTheme.colors.taskPriorityHigh,
                    style = DoPlannerTheme.typography.taskPriorityStyle
                )
                Text(
                    modifier = Modifier
                        .weight(2F)
                        .padding(bottom = 3.dp),
                    text = "Hello compose!",
                    style = DoPlannerTheme.typography.taskTitleStyle
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_flag),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "27 Apr, 2020",
                        style = DoPlannerTheme.typography.taskDateStyle,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DoPlannerTheme.colors.greenBackground.copy(alpha = 0.3F))
            ) {
                Image(
                    modifier = Modifier.fillMaxSize().padding(14.dp),
                    painter = painterResource(id = R.drawable.ic_complete),
                    contentDescription = null
                )
            }
        }
    }
}
