package ru.job4j.dsl

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import org.apache.commons.dbcp2.BasicDataSource
import java.sql.Driver

class DbcpTest : StringSpec({
    "data.isClosed = false"{
        val data: BasicDataSource = Dbcp.driver("org.h2.Driver")
            .url("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1")
            .login("sa")
            .pass("")
            .builder()
//        val data = BasicDataSource().apply {
//            driverClassName = "org.h2.Driver"
//            url = "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1"
//            username = "sa"
//            password = ""
//        }
        val con = data.connection
        con.isClosed shouldBe false
        con.close()
        con.isClosed shouldBe true
    }
})