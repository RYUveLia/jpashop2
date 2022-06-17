package jpabook.jpashop2.domain.item

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object ItemTable: IntIdTable("item") {
    val name = varchar("name", 50)
    val price = integer("price")
    val stockQuantity = integer("stock_quantity")
}

class Item(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Item>(ItemTable)
    var name by ItemTable.name
    var price by ItemTable.price
    var stockQuantity by ItemTable.stockQuantity
}