package ru.job4j.base

/**
 * класс калькулятор
 */
fun additions(firs: Int, second: Int): Int {
    return firs + second;
}

fun subtract(first: Int, second: Int): Int {
    return first - second
}

fun multiplication(first: Int, second: Int): Int {
    return first * second
}

fun doing(first: Int, second: Int): Int {
    return first / second
}

fun main () {
    val additions = additions(1, 1)
    println("1 + 1 = $additions")
    val subtract = subtract(1, 1)
    println("1 - 1 = $subtract")
    val multiplication = multiplication(2, 2)
    println("2 * 2 = $multiplication")
    val doing = doing(4, 2)
    println("4 / 2 = $doing")
}
