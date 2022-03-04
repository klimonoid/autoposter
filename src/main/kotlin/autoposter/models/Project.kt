package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable


object Projects : IntIdTable() {
    val name = varchar("name", 50)
    val user = reference("user", Users)
}

class Project(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Project>(Projects)

    var name by Projects.name
    var user by User referencedOn Projects.user
}