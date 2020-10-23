package ru.job4j.dsl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 *
 * пример инфексных функций
 */
class Infix {
//    реализация equals
     infix fun Any.equalsS(expected: Any) = assertEquals(this, expected)
//    реализация assertTrue
     infix fun Any.asTrue(expected: Any) = assertEquals(this, true)
//    реализация assertFalse
     infix fun Any.asFalse(expected: Any) = assertEquals(this, false)

    @Test
    fun isEqTestThenFunction() = 1 equalsS 1

    @Test
    fun isTueFunction() = true asTrue 1

    @Test
    fun isEqFunction() = false asFalse 2
}
