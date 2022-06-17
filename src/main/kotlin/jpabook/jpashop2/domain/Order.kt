package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date

object OrderTable: IntIdTable() {
    val member = reference("member", MemberTable)
    val delivery = reference("delivery", DeliveryTable)
    val orderDate = date("order_date")
    val status = enumeration<OrderStatus>("order_status")
}

enum class OrderStatus(var status: Int) {
    CANCEL(0),
    ORDER(1)
}

class Order(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Order>(OrderTable)
    var member by Member referencedOn OrderTable.member
    var delivery by Delivery referencedOn OrderTable.delivery
    var orderDate by OrderTable.orderDate
    var status by OrderTable.status
}
