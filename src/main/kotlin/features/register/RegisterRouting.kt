package org.features.register

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import org.features.cache.InMemoryCache
import org.features.cache.TokenCache
import org.features.login.LoginReceiveRemote
import org.features.login.LoginResponseRemote
import org.utils.isValidEmail
import java.util.UUID

fun Application.configureRegisterRouting() {

    routing {
        post("/register") {
            val registerController = RegisterController(call)
            registerController.registerNewUser()
        }
    }
}