package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable


object Photos : IntIdTable() {
    val path = varchar("path", 300)
    val post = reference("post", Posts)
}

class Photo(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Photo>(Photos)

    var path by Photos.path
    var post by Post referencedOn Photos.post
}