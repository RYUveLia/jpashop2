package jpabook.jpashop2.domain


import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Categories: IntIdTable() {
    val name = varchar("name", 50)
    val field1 = varchar("field1", 50)
    val field2 = varchar("field2", 50)
}

class Category(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Category>(Categories)
    var name by Categories.name
    var director by Categories.field1
    var actor by Categories.field2
    // TODO : parentid 구현
}


class Movie(id: EntityID<Int>): IntEntity(id) {
    val name by Categories.name
    val director by Categories.field1
    val actor by Categories.field2
}

class Book(id: EntityID<Int>): IntEntity(id) {
    val name by Categories.name
    val author by Categories.field1
    val isbn by Categories.field2
}

class Album(id: EntityID<Int>): IntEntity(id) {
    val name by Categories.name
    val artist by Categories.field1
    val genre by Categories.field2
}