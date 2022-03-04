package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object TaggedPersons : IntIdTable() {
    val username = varchar("username", 50)
    val photo = reference("photo", Photos)
}

class TaggedPerson(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<TaggedPerson>(TaggedPersons)

    var username by TaggedPersons.username
    var photo by Photo referencedOn TaggedPersons.photo
}