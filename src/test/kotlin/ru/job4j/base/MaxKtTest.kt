package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
internal class MaxKtTest : StringSpec({
    "1 or 2 = 2" {
        max(1, 2) shouldBe 2
    }

    "1 or 8 or 7 = 8" {
        max(1, 8, 7) shouldBe 8
    }
})