package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object OrderItems: IntIdTable() {
    val order = reference("order", Orders)
    val orderPrice = integer("order_price")
    val count = integer("count")
    val item = reference("item", Items)
}

class OrderItem(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<OrderItem>(OrderItems)
    var order by Order referencedOn OrderItems.order
    var orderPrice by OrderItems.orderPrice
    var count by OrderItems.count
    var item by Item referencedOn OrderItems.item
}