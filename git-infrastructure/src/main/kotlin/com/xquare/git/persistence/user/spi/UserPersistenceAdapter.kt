package com.xquare.git.persistence.user.spi

import com.xquare.git.user.spi.CommandUserPort
import com.xquare.git.user.model.User
import com.xquare.git.persistence.user.mapper.UserMapper
import com.xquare.git.persistence.user.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
) : CommandUserPort {
    override fun saveUser(user: User) {
        userRepository.save(
            userMapper.domainToEntity(user)
        )
    }
}