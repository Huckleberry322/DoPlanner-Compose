package com.mightyhedgehog.doplanner.data.gateway.user

import com.mightyhedgehog.doplanner.data.local.json.user.UserStorage
import com.mightyhedgehog.doplanner.data.mapper.user.toJsonUser
import com.mightyhedgehog.doplanner.presentation.model.user.User
import javax.inject.Inject

class SaveUserGateway @Inject constructor(
    private val userStorage: UserStorage
) {
    suspend fun execute(user: User) = userStorage.update(user.toJsonUser())
}
