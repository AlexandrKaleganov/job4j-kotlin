package ru.job4j.oop.tracker

interface Input {
    fun inputCommand(command: String?): String?
    fun inputCommand(command: String?, range: Int): Int
}