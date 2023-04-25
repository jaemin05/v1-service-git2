package com.xquare.git.persistence.user.model

import com.xquare.git.global.entity.BaseUUIDEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull
import java.util.UUID

@Entity
@Table(name = "tbl_github_commit")
class UserEntity(

    override val id: UUID,

    @field: NotNull
    val username: String

) : BaseUUIDEntity(id) {
}