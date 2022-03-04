package autoposter.models

import autoposter.models.Locations.nullable
import autoposter.models.User.Companion.referrersOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Locations : IntIdTable() {
    val name = varchar("name", 60)
    val link = varchar("link", 300).nullable()
    val post = reference("post", Posts)
}

class Location(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Location>(Locations)

    var name by Locations.name
    var link by Locations.link
    var post by Post referencedOn Locations.post
}