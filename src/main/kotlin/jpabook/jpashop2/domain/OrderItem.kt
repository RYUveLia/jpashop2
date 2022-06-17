package jpabook.jpashop2.domain

import jpabook.jpashop2.domain.item.Item
import jpabook.jpashop2.domain.item.ItemTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object OrderItemTable: IntIdTable() {
    val order = reference("order", OrderTable)
    val orderPrice = integer("order_price")
    val count = integer("count")
    val item = reference("item", ItemTable)
}

class OrderItem(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<OrderItem>(OrderItemTable)
    var order by Order referencedOn OrderItemTable.order
    var orderPrice by OrderItemTable.orderPrice
    var count by OrderItemTable.count
    var item by Item referencedOn OrderItemTable.item
}