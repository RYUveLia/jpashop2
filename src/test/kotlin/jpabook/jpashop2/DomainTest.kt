package jpabook.jpashop2

import jpabook.jpashop2.domain.Member
import jpabook.jpashop2.domain.Members
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DomainTest {

    @Test
    fun connectionTest() {
        Database.connect("jdbc:h2:tcp://localhost/~/jpashop", driver = "org.h2.Driver", user = "sa", password = "")

        transaction {
            SchemaUtils.create(Members)

            val stPeteId = Members.insert {
                it[name] = "St. Petersburg"
                it[address] = "우리집어딘가"
            } get Members.id

            val stPeteId2 = Member.new {
                name = "the last jedi"
                address = "우리집은 일단 아님"
            }

            // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
            println("Cities: ${Members.selectAll()}")
        }
    }
}