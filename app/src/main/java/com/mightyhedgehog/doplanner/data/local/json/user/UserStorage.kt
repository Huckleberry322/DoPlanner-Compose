package com.mightyhedgehog.doplanner.data.local.json.user

import com.google.gson.reflect.TypeToken
import com.mightyhedgehog.doplanner.data.local.json.JsonFileStorage
import com.mightyhedgehog.doplanner.data.model.user.JsonUser

class UserStorage(
    storageDirectory: String,
    fileName: String,
) : JsonFileStorage<JsonUser>(
    fileDirectory = storageDirectory,
    fileName = fileName,
    type = object : TypeToken<JsonUser>() {}.type
) {
    override suspend fun get(): JsonUser = super.get() ?: JsonUser("Cody")
}
