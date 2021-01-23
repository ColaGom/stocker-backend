package com.colagom.stocker

import com.colagom.stocker.data.StockService
import com.colagom.stocker.entity.Stock
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.http.HttpStatusCode
import io.ktor.request.path
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import org.jetbrains.exposed.sql.Database
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    Database.connect(
        HikariDataSource(
            /*TODO: configuration about database */
        )
    )

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    val stockService = StockService()

    routing {
        route("api") {
            route("stocks") {
                get {
                    val allStocks = stockService.getAllStock()
                    call.respond(allStocks)
                }
                post {
                    val body = call.receive<Stock>()
                    stockService.addStock(body)
                    call.respond(HttpStatusCode.Accepted)
                }
            }
        }
    }
}