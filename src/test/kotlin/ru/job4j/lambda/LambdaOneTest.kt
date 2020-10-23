package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * тестирование функций
 */
internal class LambdaOneTest: StringSpec({
    "inc" {
       inc(1) shouldBe 2
    }
    "dec" {
        dec(1) shouldBe 0
    }
    "square" {
        square(2) shouldBe 4
    }
})
