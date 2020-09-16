package ru.job4j.base

fun draw(size: Int) {
    if (size > 0 && size % 2 > 0)
        for (value in 0 until size) {
            (0 until size).forEach { value2 ->
                if (value == value2 || value == size - 1 - value2) print("x") else print(" ")
            }
            println()
        } else print("Операция не поддерживается")
}

fun main() {
    draw(7)
    draw(10)
}