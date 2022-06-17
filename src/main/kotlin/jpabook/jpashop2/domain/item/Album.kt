package jpabook.jpashop2.domain.item

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.ReferenceOption

object AlbumTable: IdTable<Int>() {

    val artist = varchar("artist", 20)

    override val id = integer("item_id")
        .references(ref = ItemTable.id, onDelete = ReferenceOption.RESTRICT)
        .entityId()

    override val primaryKey = PrimaryKey(id)
}

class Album(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Album>(AlbumTable)
    var artist by AlbumTable.artist
    var itemId by AlbumTable.id
}