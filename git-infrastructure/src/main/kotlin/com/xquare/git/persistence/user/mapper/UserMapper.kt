package com.xquare.git.persistence.user.mapper

import com.xquare.git.user.model.User
import com.xquare.git.persistence.user.model.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun entityToDomain(entity: UserEntity?): User? {
        return entity?.run {
            User(
                id = id,
                username = username
            )
        }
    }

    fun domainToEntity(domain: User): UserEntity {
        return domain.run {
            UserEntity(
                id = id,
                username = username
            )
        }
    }
}