package autoposter.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Answers : IntIdTable() {
    val text = varchar("text", 70)
    val poll = reference("poll", Polls)
}

class Answer(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Answer>(Answers)

    var text by Answers.text
    var poll by Poll referencedOn Answers.poll
}