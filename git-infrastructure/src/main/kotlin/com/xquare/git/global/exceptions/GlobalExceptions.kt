package com.xquare.git.global.exceptions

import com.xquare.git.exceptions.BaseException

sealed class GlobalExceptions(
    override val statusCode: Int,
    override val errorMessage: String
) : BaseException(statusCode, errorMessage) {

    class InternalServerError(message: String = UNEXPECTED_EXCEPTION) : GlobalExceptions(500, message)

    companion object {
        const val UNEXPECTED_EXCEPTION = "Unexpected Error Occurred"
    }
}