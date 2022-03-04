package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Polls : IntIdTable() {
    val name = varchar("name", 70)
    val post = reference("post", Posts)
}

class Poll(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Poll>(Polls)

    var name = Polls.name
    var post = Post referencedOn Polls.post
}