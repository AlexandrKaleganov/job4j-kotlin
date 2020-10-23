package ru.job4j.dsl

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.apache.commons.dbcp2.BasicDataSource

/**
 * тестирование класса {@Link Dbcp}
 */
class DbcpTest : StringSpec({
    "data.isClosed = false"{
        val data: BasicDataSource = Dbcp.driver("org.h2.Driver")
            .url("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1")
            .login("sa")
            .pass("")
            .builder()
        val con = data.connection
        con.isClosed shouldBe false
        con.close()
        con.isClosed shouldBe true
    }
})
