package org

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.features.login.configureLoginRouting
import org.features.register.configureRegisterRouting
import org.jetbrains.exposed.sql.Database


fun main() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/test",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "postgres"
    )


    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureMonitoring()
    configureSecurity()
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
}
