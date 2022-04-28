package com.mightyhedgehog.doplanner.domain.usecase.user

import com.mightyhedgehog.doplanner.data.local.json.user.UserStorage
import com.mightyhedgehog.doplanner.data.mapper.user.toUser
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userStorage: UserStorage
) {
    suspend fun execute() = userStorage.get().toUser()
}
