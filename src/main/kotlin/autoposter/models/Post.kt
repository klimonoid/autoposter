package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime


object Posts : IntIdTable() {
    val dateToPost = datetime("dateToPost")
    val text = text("text").nullable()
    val account = reference("account", Accounts)
}

class Post(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Post>(Posts)

    var dateToPost by Posts.dateToPost
    var text by Posts.text
    var account by Account referencedOn Posts.account
}