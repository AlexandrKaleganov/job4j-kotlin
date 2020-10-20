package ru.job4j.dsl

import io.kotlintest.specs.StringSpec

class CrudServiceTest : StringSpec({
    "test create " {
        val k: Long = 0L
        CrudService.create("create table item\n" +
                "(\n" +
                "\tid bigint auto_increment,\n" +
                "\tname varchar(255) null,\n" +
                "\tconstraint item_pk\n" +
                "\t\tprimary key (id)\n" +
                ");") { k.inc() }
        println("k = $k")
    }
//    CrudService.create(Item().apply {
//    name = "name"}) shouldBe "0"
})