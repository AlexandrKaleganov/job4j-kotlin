package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class CalcKtTest : StringSpec({
    "1 + 1 = 2" {
        additions(1, 1) shouldBe 2
    }

    "1 - 1 = 0" {
        subtract(1, 1) shouldBe 0
    }
    "2 * 2 = 4" {
        multiplication(2, 2) shouldBe 4
    }
    "4 / 2 = 2" {
        doing(4, 2) shouldBe 2
    }
})
