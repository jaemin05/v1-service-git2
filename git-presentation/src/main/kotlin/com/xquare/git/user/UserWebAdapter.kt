package com.xquare.git.user

import com.xquare.git.user.facade.UserFacade
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserWebAdapter(
    private val userFacade: UserFacade
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun saveUser(@RequestParam(name = "username") username: String) =
        userFacade.saveUser(username)
}