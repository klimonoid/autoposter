package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


enum class AccountType(val type: String) {
    Telegram("telegram"),
    Instagram("instagram"),
    VK("vk")
}

object Accounts : IntIdTable() {
    val type = enumeration("type", AccountType::class)
    val token = varchar("token", 300)
    val link = varchar("link", 300).nullable()
    val dateOfCreation = date("dateOfCreation").nullable()
    val project = reference("project", Projects)
}

class Account(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Account>(Accounts)

    var type by Accounts.type
    var token by Accounts.token
    var link by Accounts.link
    var dateOfCreation by Accounts.dateOfCreation
    var project by Project referencedOn Accounts.project
}