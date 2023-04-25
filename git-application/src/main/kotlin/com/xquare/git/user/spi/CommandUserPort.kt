package com.xquare.git.user.spi

import com.xquare.git.user.model.User

interface CommandUserPort {
    fun saveUser(user: User)
}
