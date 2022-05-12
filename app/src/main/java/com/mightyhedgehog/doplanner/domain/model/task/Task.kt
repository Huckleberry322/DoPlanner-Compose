package com.mightyhedgehog.doplanner.domain.model.task

import java.time.LocalDateTime

data class Task(
    val id: String,
    val name: String,
    val description: String?,
    val date: LocalDateTime,
    val priority: Priority,
)
