package autoposter

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import autoposter.plugins.*



fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSecurity()
        configureSerialization()
        connectToDatabase()

        // Uncomment if your database is not created
//        migrateDatabase()
    }.start(wait = true)
}
