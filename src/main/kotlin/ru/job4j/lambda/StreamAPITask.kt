package ru.job4j.lambda

fun count(list: List<Int>): Long {
    return list
            .stream()
            .filter { it % 2 == 0 }
            .map { it.inc() }
            .count()
}