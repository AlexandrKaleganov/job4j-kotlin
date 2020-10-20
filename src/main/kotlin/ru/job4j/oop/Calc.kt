package ru.job4j.oop

fun calc(param: Int) = param * 2
fun calc(param: Double) = param * 2

fun main() {
    println(calc(2))
    println(calc(2.0))
}