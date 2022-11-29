package smmcommunity.backend

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import smmcommunity.backend.routes.levels

class ServerApp : KoinComponent {

    fun run() {
        embeddedServer(CIO, port = 80) {
            install(DefaultHeaders)
            install(CallLogging)
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                })
            }
            routing {
                get("/") {
                    call.respondText("Hello, world!")
                }
                levels()
            }
        }.start(wait = true)
    }
}