package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Deliveries: IntIdTable(){
    val status = enumeration<DeliveryStatus>("status")
}

enum class DeliveryStatus (var status: Int) {
    READY(0),
    COM(1)
}

class Delivery(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Delivery>(Deliveries)
    var status by Deliveries.status
}