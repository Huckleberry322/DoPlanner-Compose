package com.mightyhedgehog.doplanner.domain.model.task

import java.time.LocalDateTime

data class Task(
    val id: Int,
    val name: String,
    val description: String?,
    val date: LocalDateTime,
    val priority: Priority,
)
