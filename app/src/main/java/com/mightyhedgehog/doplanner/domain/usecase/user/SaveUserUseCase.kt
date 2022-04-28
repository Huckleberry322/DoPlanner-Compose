package com.mightyhedgehog.doplanner.domain.usecase.user

import com.mightyhedgehog.doplanner.data.local.json.user.UserStorage
import com.mightyhedgehog.doplanner.data.mapper.user.toJsonUser
import com.mightyhedgehog.doplanner.domain.model.user.User
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userStorage: UserStorage
) {
    suspend fun execute(user: User) = userStorage.update(user.toJsonUser())
}
