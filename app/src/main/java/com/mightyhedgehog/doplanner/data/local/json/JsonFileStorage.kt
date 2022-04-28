package com.mightyhedgehog.doplanner.data.local.json

import com.google.gson.Gson
import java.io.File
import java.lang.reflect.Type
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

open class JsonFileStorage<T>(
    private val fileDirectory: String,
    private val fileName: String,
    private val type: Type,
) {

    private val file = File(fileDirectory, fileName)

    suspend fun update(data: T?) {
        delete()
        return suspendCoroutine {
            try {
                file.writeText(data?.let { data -> Gson().toJson(data) } ?: "")
                it.resume(Unit)
            } catch (e: Exception) {
                it.resumeWithException(e)
            }
        }
    }

    suspend fun delete() = suspendCoroutine<Unit> {
        file.delete()
        it.resume(Unit)
    }

    open suspend fun get(): T? = suspendCoroutine {
        it.resume(kotlin.runCatching {
            if (!file.exists()) return@runCatching null
            Gson().fromJson<T>(file.readText(), type)
        }.onFailure { it.printStackTrace() }.getOrNull())
    }
}
