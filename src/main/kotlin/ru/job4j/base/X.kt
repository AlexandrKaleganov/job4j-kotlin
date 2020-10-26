package ru.job4j.base
/*
* метод рисует X исходя из размеров
 */
fun draw(size: Int) {
    if (isValidSize(size))
        for (value in 0 until size) {
            for (value2 in 0 until size) {
                if (value == value2 || value == size - 1 - value2) {
                    print("x")
                } else {
                    print(" ")
                }
            }
            println()
        }
}

fun isValidSize(size: Int): Boolean {
    if (size > 0 && size % 2 > 0) {
        return true
    } else {
        print("Операция не поддерживается")
        return false
    }
}

fun main() {
    draw(7)
    draw(10)
}

