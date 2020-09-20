package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
internal class HtmlTableTest : StringSpec({
    "createTable.table(1, 2) = '<table><tr><td></td><td></td></tr></table>'" {
        val createTable = HtmlTable()
        createTable.table(1, 2) shouldBe "<table><tr><td></td><td></td></tr></table>"
    }
})