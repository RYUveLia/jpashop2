package jpabook.jpashop2.domain

import jpabook.jpashop2.domain.Category.Companion.referrersOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.date

object Orders: IntIdTable() {
    val member = reference("member", Members)
    val delivery = reference("delivery", Deliveries)
    val orderDate = date("order_date")
    val status = enumeration<OrderStatus>("order_status")
}

enum class OrderStatus(var status: Int) {
    CANCEL(0),
    ORDER(1)
}

class Order(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Order>(Orders)
    var member by Member referencedOn Orders.member
    var delivery by Delivery referencedOn Orders.delivery
    var orderDate by Orders.orderDate
    var status by Orders.status
}
