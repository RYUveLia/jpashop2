package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Items: IntIdTable() {
    val name = varchar("name", 50)
    val price = integer("price")
    val stockQuantity = integer("stock_quantity")
}

class Item(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Item>(Items)
    var price by Items.price
    var stockQuantity by Items.stockQuantity
}
