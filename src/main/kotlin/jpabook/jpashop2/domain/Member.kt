package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Members : IntIdTable() {
    val name = varchar("name", 50)
    val address = varchar("address", 128)
}

class Member(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Member>(Members)
    var name by Members.name
    var address by Members.address
}