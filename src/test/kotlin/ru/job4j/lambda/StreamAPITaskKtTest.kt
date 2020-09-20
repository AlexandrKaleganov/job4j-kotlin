package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class StreamAPITaskKtTest : StringSpec({
    "count = 5L" {
        val arr = listOf(1, 2, 3, 4 , 5, 6 ,7, 8, 9 , 10)
        count(arr ) shouldBe 5L
    }
})