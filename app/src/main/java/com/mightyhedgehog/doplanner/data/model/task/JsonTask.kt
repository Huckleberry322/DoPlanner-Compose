package com.mightyhedgehog.doplanner.data.model.task

data class JsonTask(
    val id: Int,
    val name: String,
    val description: String,
    val date: Long,
    val priority: String,
)
