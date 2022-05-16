package com.mightyhedgehog.doplanner.data.mapper.user

import com.mightyhedgehog.doplanner.data.model.user.JsonUser
import com.mightyhedgehog.doplanner.presentation.model.user.User

fun User.toJsonUser() = JsonUser(
    name = this.name
)

fun JsonUser.toUser() = User(
    name = this.name
)
