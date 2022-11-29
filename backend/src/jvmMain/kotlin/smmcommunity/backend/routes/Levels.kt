package smmcommunity.backend.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import smmcommunity.backend.Database
import smmcommunity.backend.data.models.Level

// TODO: Remove KoinComponent, when Koin becomes compatible with Ktor 2.0
//  https://github.com/InsertKoinIO/koin/pull/1266
context(KoinComponent)
fun Routing.levels() {
    val db by inject<Database>()
    route("levels") {
        get {
            val levels = db.levelQueries.selectAll(Level.mapper).executeAsList()
            call.respond(levels)
        }
        get("add") {
            db.levelQueries.insert("Carl's Premature Detonation")
            call.respondText("Added level!")
        }
    }
}