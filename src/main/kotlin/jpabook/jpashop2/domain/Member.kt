package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object MemberTable : IntIdTable("member", "member_id") {
    val name = varchar("name", 50)
    val city = varchar("city", 50)
    val street = varchar("street", 50)
    val zipcode = varchar("zipcode", 50)
}

class Member(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Member>(MemberTable)
    var name by MemberTable.name
    var city by MemberTable.city
    var street by MemberTable.street
    var zipcode by MemberTable.zipcode
}