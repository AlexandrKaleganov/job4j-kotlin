package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * тестирование калькулятора
 */
internal class CalcKtTest : StringSpec({
    /**
     * тест сложения
     */
    "1 + 1 = 2" {
        additions(1, 1) shouldBe 2
    }
    /**
     * тест вычитания
     */
    "1 - 1 = 0" {
        subtract(1, 1) shouldBe 0
    }
    /**
     * тест умножения
     */
    "2 * 2 = 4" {
        multiplication(2, 2) shouldBe 4
    }
    /**
     * тест деления
     */
    "4 / 2 = 2" {
        doing(4, 2) shouldBe 2
    }
})
