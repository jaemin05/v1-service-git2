package com.xquare.git.user.model

import com.xquare.git.annotations.Aggregate
import java.util.UUID

@Aggregate
data class User(
    val id: UUID = UUID(0,0),
    val username: String
)