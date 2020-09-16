package ru.job4j.base

fun max(first: Int, second: Int) = if (first > second) first else second

fun max(first: Int, second: Int, three: Int) = if (first > second && first > three) first
else if (second > first && second > three) second else three

fun main() {
    val rsl = max(1, 2)
    println("max from 1 and 2 is $rsl")

    val rsl2 = max(1, 2, 3)
    println("max from 1 and 2 and 3 is $rsl2")
}