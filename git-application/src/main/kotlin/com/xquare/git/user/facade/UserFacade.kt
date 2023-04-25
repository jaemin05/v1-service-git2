package com.xquare.git.user.facade

import com.xquare.git.user.usecase.SaveUserUseCase
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserFacade(
    private val saveUserUseCase: SaveUserUseCase
) {
    @Transactional(rollbackFor = [Exception::class])
    fun saveUser(userName: String) {
        saveUserUseCase.execute(userName)
    }
}