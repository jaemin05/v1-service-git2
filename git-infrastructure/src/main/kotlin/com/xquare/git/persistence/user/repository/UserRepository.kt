package com.xquare.git.persistence.user.repository

import com.xquare.git.persistence.user.model.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : CrudRepository<UserEntity, UUID>