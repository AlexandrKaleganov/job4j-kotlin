package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * тестирование предиката val predicate = {e: Account -> e.name == "Ivan" && e.balance > 0 }
 */
internal class FilterKtTest : StringSpec({
    "filter(predicate).size == 1" {
        val accounts = arrayOf(Account("sda", 0),
                Account("Ivan", 0), Account("Ivan", 1))
        accounts.filter(predicate).size shouldBe 1
    }
})
