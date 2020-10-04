package ru.job4j.safe.jdbc

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec


class ConnectToJDBCTest: StringSpec({
    "insert  = 1 row(s) were inserted" {
        with(ConnectToJDBC()) {
            init("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1"
                    ,"sa", "")
            execute("insert", "create table if not exists entity(name varchar(50) null);")
            execute("insert", "INSERT INTO entity(name) VALUES('test')")
        } shouldBe "1 row(s) were inserted"

    }
    "delete  = 3 row(s) were deleted" {
        with(ConnectToJDBC()) {
            init("jdbc:h2:mem:db2;DB_CLOSE_DELAY=-1"
                    ,"sa", "")
            execute("insert", "create table if not exists entity(name varchar(50) null);")
            execute("insert", "INSERT INTO entity(name) VALUES('test')")
            execute("insert", "INSERT INTO entity(name) VALUES('test')")
            execute("insert", "INSERT INTO entity(name) VALUES('test')")
            execute("delete", "delete from entity where name like 'test'")
        } shouldBe "3 row(s) were deleted"

    }
})