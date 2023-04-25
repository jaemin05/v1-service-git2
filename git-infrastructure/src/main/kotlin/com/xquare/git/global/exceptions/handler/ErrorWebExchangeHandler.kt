package com.xquare.git.global.exceptions.handler

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.git.exceptions.BaseException
import com.xquare.git.global.exceptions.GlobalExceptions
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

class ErrorWebExchangeHandler(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BaseException) {
            errorToJson(e, response)
        } catch (e: Exception) {
            when(e.cause) {
                is BaseException -> errorToJson((e.cause as BaseException), response)
                else -> {
                    errorToJson(GlobalExceptions.InternalServerError(), response)
                }
            }
        }
    }

    private fun errorToJson(exception: BaseException, response: HttpServletResponse) {
        response.status = exception.statusCode
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(
            objectMapper.writeValueAsString(ErrorResponse.of(exception))
        )
    }
}