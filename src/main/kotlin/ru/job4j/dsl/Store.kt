package ru.job4j.dsl

interface Store<T> {
    fun addItem(item: T): T
}
