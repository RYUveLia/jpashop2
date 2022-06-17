package jpabook.jpashop2.domain.item

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.ReferenceOption

object BookTable: IdTable<Int>() {

    val author = varchar("author", 20)
    val isbn = varchar("isbn", 10)

    override val id = integer("item_id")
        .references(ref = ItemTable.id, onDelete = ReferenceOption.RESTRICT)
        .entityId()

    override val primaryKey = PrimaryKey(id)
}
/*
object BookTable: IntIdTable("book") {
    val author = varchar("author", 20)
    val isbn = varchar("isbn", 10)
    val item_id = reference("item_id", ItemTable)
}*/

class Book(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Book>(BookTable)
    var author by BookTable.author
    var isbn by BookTable.isbn
    var itemId by BookTable.id
}