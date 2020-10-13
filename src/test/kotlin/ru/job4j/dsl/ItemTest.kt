package ru.job4j.dsl

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec


class ItemTest : StringSpec({
    "ItemStore.getItems()[0].id  = '1'" {
        Item("1", "test").save()
        ItemStore.getItems()[0].id shouldBe "1"
    }
})