package ru.job4j.dsl

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * тестирование CRUD на уровне сессии
 */
class CrudServiceTest : StringSpec({
    "INIT TABLE" {
        val k: Long = 0L
        CrudService.create("create table if not exists  item(\n" +
                "id serial primary key,\n" +
                "name varchar(200)\n" +
                ");\n") { k.inc() }
        println("k = $k")
    }
    " CREATE ELEMENT ITEM.ID = '1' " {
        CrudService.create(Item().apply {
            name = "name"
        }).id shouldBe "1"
    }
    " CrudService.findAll().size  = 1 " {
        CrudService.findAll().size shouldBe 1
    }
})
