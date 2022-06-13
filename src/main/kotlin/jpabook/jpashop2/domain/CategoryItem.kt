package jpabook.jpashop2.domain

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object CategoryItems: IntIdTable() {
    val category = reference("category", Categories)
    val item = reference("item", Items)
}

class CategoryItem(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<CategoryItem>(CategoryItems)
    var category by Category referencedOn CategoryItems.category
    var item by Item referencedOn Items.name
}