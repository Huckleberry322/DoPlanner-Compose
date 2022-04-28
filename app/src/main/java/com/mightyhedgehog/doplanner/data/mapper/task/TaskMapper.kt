package com.mightyhedgehog.doplanner.data.mapper.task

import com.mightyhedgehog.doplanner.data.model.task.JsonTask
import com.mightyhedgehog.doplanner.domain.model.task.Priority
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.ext.*

private const val PRIORITY_HIGH = "High"
private const val PRIORITY_MEDIUM = "Medium"
private const val PRIORITY_LOW = "Low"

private const val WRONG_TYPE_EXCEPTION = "Wrong string!"

fun JsonTask.toTask() = Task(
    id = this.id,
    name = this.name,
    description = if (this.description == emptyString()) {
        null
    } else this.description,
    date = toLocalDateTime(this.date),
    priority = priorityFromString(this.priority),
)

fun Task.toJsonTask() = JsonTask(
    id = this.id,
    name = this.name,
    description = this.description ?: emptyString(),
    date = this.date.toEpochMillis(),
    priority = priorityToString(this.priority),
)

fun priorityToString(priority: Priority) = when (priority) {
    Priority.HIGH -> PRIORITY_HIGH
    Priority.MEDIUM -> PRIORITY_MEDIUM
    Priority.LOW -> PRIORITY_LOW
}

private fun priorityFromString(string: String) = when (string) {
    PRIORITY_HIGH -> Priority.HIGH
    PRIORITY_MEDIUM -> Priority.MEDIUM
    PRIORITY_LOW -> Priority.LOW
    else -> throw IllegalArgumentException(WRONG_TYPE_EXCEPTION)
}
