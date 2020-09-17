package ru.job4j.oop.tracker.model

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class ItemTest : StringSpec({
    "setId('1'); getId() = '1'" {
        val item = Item(id ="1")
        item.id shouldBe "1"
    }
    "setName('vasia'); getName() = 'vasia'" {
        val item = Item(name = "vasia")
        item.name shouldBe "vasia"
    }
    "setDesc('desc'); getDesc() = 'desc'" {
        val item = Item(desc = "desc")
        item.desc shouldBe "desc"
    }
    "addComment('comment'); getComment().size = 1" {
        val item = Item()
        item.addComment("comment")
        item.getComments().size shouldBe 1
    }
    "addComment('comment'); getComment().get(0) = 'comment'" {
        val item = Item()
        item.addComment("comment")
        item.getComments().get(0) shouldBe "comment"
    }
    "getCreated() > 0" {
        val item = Item()
        item.getCreated().compareTo(0) shouldBe 1
    }
})


