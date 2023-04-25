package com.xquare.git

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GitInfrastructureApplication

fun main(args: Array<String>) {
    runApplication<GitInfrastructureApplication>(*args)
}
