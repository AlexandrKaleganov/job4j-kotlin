package ru.job4j.base

/**
 * 1. Реализуйте метод fun defragment(array: Array<String?>) ,
 * который будет перемещать заполненные ячейки массива в начало, а пустые в конец.
 */
fun defragment(array: Array<String?>) {
    for ((infix, value) in array.withIndex()) {
        if (value == null) {
            for ((infix2, value2) in array.withIndex()) {
                if (infix2 > infix && value2 != null) {
                    array[infix] = value2
                    array[infix2] = null
                    break
                }
            }
        }
    }
}

fun sout(array: Array<String?>) {
    for (value in array) {
        print(value);
    }
    println()
}

fun main() {
    val array = arrayOfNulls<String>(10)
    array[2] = "1"
    array[9] = "2"
    sout(array)
    defragment(array)
    sout(array)
}