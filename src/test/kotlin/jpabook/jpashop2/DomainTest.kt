package jpabook.jpashop2

import jpabook.jpashop2.domain.*
import jpabook.jpashop2.domain.item.*
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
            SchemaUtils.create(MemberTable)

            val stPeteId = MemberTable.insert {
                it[name] = "St. Petersburg"
                it[city] = "서울"
                it[street] = "앞길"
                it[zipcode] = "08217"
            } get MemberTable.id

            val stPeteId2 = Member.new {
                name = "the last jedi"
                city = "서울"
                street = "앞길"
                zipcode = "08217"
            }

            // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
            println("Cities: ${MemberTable.selectAll().count()}")
        }
    }

    @Test
    fun `상속 확인 테스트`() {
        Database.connect("jdbc:h2:tcp://localhost/~/jpashop", driver = "org.h2.Driver", user = "sa", password = "")

        transaction {
            SchemaUtils.create(ItemTable)
            SchemaUtils.create(BookTable)
            SchemaUtils.create(AlbumTable)
            SchemaUtils.create(MovieTable)

            val item = Item.new {
                name = "the last jedi"
                price = 10000
                stockQuantity = 30
            }


            val book = Book.new {
                author = "me"
                isbn = "dadada"
                itemId = item.id
            }

            val album = Album.new {
                artist = "me"
                itemId = item.id
            }

            val movie = Movie.new {
                actor = "me"
                director = "me"
                itemId = item.id
            }

            /*BookTable.insert {
                it[author] = "me"
                it[isbn] = "dadaa"
                it[id] = item.id
            }*/

            println(ItemTable.selectAll().toMutableList())
        }
    }
}