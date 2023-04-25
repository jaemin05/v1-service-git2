package com.xquare.git.user.usecase

import com.xquare.git.user.spi.CommandUserPort
import com.xquare.git.annotations.UseCase
import com.xquare.git.user.model.User

@UseCase
class SaveUserUseCase(
    private val commandUserPort: CommandUserPort
) {
    fun execute(userName: String) {
        commandUserPort.saveUser(
            User(username = userName)
        )
    }
}