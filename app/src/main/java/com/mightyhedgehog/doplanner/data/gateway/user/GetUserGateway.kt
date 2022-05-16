package com.mightyhedgehog.doplanner.data.gateway.user

import com.mightyhedgehog.doplanner.data.local.json.user.UserStorage
import com.mightyhedgehog.doplanner.data.mapper.user.toUser
import javax.inject.Inject

class GetUserGateway @Inject constructor(
    private val userStorage: UserStorage
) {
    suspend fun execute() = userStorage.get().toUser()
}
