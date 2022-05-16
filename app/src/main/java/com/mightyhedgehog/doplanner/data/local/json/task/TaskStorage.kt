package com.mightyhedgehog.doplanner.data.local.json.task

import com.google.gson.reflect.TypeToken
import com.mightyhedgehog.doplanner.data.local.json.JsonFileStorage
import com.mightyhedgehog.doplanner.data.model.task.JsonTask

class TaskStorage(
    storageDirectory: String,
    fileName: String,
) : JsonFileStorage<List<JsonTask>>(
    fileDirectory = storageDirectory,
    fileName = fileName,
    type = object : TypeToken<List<JsonTask>>() {}.type
) {
    override suspend fun get(): List<JsonTask> = super.get() ?: emptyList()

}
