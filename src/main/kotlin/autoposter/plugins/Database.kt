package autoposter.plugins

import autoposter.models.*
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction


object DatabaseConfig {
    val url = "jdbc:postgresql://localhost:5432/autoposter"
    val driver = "org.postgresql.Driver"
    val user = "klim"
    val password = "klim"
}


fun connectToDatabase() {

    Database.connect(
        url = DatabaseConfig.url,
        driver = DatabaseConfig.driver,
        user = DatabaseConfig.user,
        password = DatabaseConfig.password)
}

fun migrateDatabase() {
    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.create(Users)
        SchemaUtils.create(Projects)
        SchemaUtils.create(Accounts)
        SchemaUtils.create(Posts)
        SchemaUtils.create(Locations)
        SchemaUtils.create(Polls)
        SchemaUtils.create(Answers)
        SchemaUtils.create(Photos)
        SchemaUtils.create(TaggedPersons)
    }
}