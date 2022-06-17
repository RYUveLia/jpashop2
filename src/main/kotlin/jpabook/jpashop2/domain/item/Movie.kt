package jpabook.jpashop2.domain.item

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.ReferenceOption

object MovieTable: IdTable<Int>() {

    val director = varchar("director", 20)
    val actor = varchar("actor", 20)

    override val id = integer("item_id")
        .references(ref = ItemTable.id, onDelete = ReferenceOption.RESTRICT)
        .entityId()

    override val primaryKey = PrimaryKey(id)
}

class Movie(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Movie>(MovieTable)
    var director by MovieTable.director
    var actor by MovieTable.actor
    var itemId by MovieTable.id
}