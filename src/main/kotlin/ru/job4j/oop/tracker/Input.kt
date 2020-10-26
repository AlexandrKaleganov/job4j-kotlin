package ru.job4j.oop.tracker

/**
 * интерфейс ввода
 */
interface Input {
    fun inputCommand(command: String?): String?
    fun inputCommand(command: String?, range: Int): Int
}
