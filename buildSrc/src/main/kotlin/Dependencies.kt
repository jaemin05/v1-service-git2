enum class ImplementationType(val originalName: String) {
    IMPLEMENTATION("implementation"),
    TEST_IMPLEMENTATION("testImplementation"),
    KAPT("kapt"),
    RUNTIME_ONLY("runtimeOnly")
}

interface Libraries {
    fun dependencies(): List<Pair<String, ImplementationType>>

    object Kotlin : Libraries {
        private const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
        private const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

        override fun dependencies() = listOf(
            KOTLIN_REFLECT to ImplementationType.IMPLEMENTATION,
            KOTLIN_STDLIB to ImplementationType.IMPLEMENTATION
        )
    }

    object Jackson : Libraries {
        private const val MODULE_KOTLIN =
            "com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersions.JACKSON_VERSION}"

        override fun dependencies() = listOf(
            MODULE_KOTLIN to ImplementationType.IMPLEMENTATION
        )
    }

    object Transaction : Libraries {
        private const val SPRING_TRANSACTION = "org.springframework:spring-tx:${DependencyVersions.SPRING_TRANSACTION}"

        override fun dependencies() = listOf(
            SPRING_TRANSACTION to ImplementationType.IMPLEMENTATION
        )
    }

    object Component : Libraries {
        private const val SPRING_COMPONENT = "org.springframework:spring-context:${DependencyVersions.SPRING_COMPONENT}"

        override fun dependencies() = listOf(
            SPRING_COMPONENT to ImplementationType.IMPLEMENTATION
        )
    }

    object SpringBoot : Libraries {
        private const val STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
        private const val STARTER_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

        override fun dependencies() = listOf(
            STARTER_WEB to ImplementationType.IMPLEMENTATION,
            STARTER_VALIDATION to ImplementationType.IMPLEMENTATION,
        )
    }

    object ORM : Libraries {
        private const val STARTER_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"

        override fun dependencies() = listOf(
            STARTER_JPA to ImplementationType.IMPLEMENTATION,
        )
    }

    object Database : Libraries {
        private const val MYSQL_CONNECTOR = "mysql:mysql-connector-j"
        private const val FLYWAY = "org.flywaydb:flyway-mysql"

        override fun dependencies() = listOf(
            MYSQL_CONNECTOR to ImplementationType.RUNTIME_ONLY,
            FLYWAY to ImplementationType.IMPLEMENTATION
        )
    }

    object Test : Libraries {
        private const val KOTEST = "io.kotest:kotest-runner-junit5:${DependencyVersions.KOTEST_VERSION}"
        private const val MOCKK = "io.mockk:mockk:${DependencyVersions.MOCKK_VERSION}"

        override fun dependencies() = listOf(
            KOTEST to ImplementationType.TEST_IMPLEMENTATION,
            MOCKK to ImplementationType.TEST_IMPLEMENTATION
        )
    }
}