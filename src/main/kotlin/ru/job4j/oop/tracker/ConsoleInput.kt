package ru.job4j.oop.tracker

class ConsoleInput : Input {
    override fun inputCommand(command: String?) = readLine()

    override fun inputCommand(command: String?, range: Int): Int {
        val key = Integer.valueOf(this.inputCommand(command))
        if (key in 0..2) return key else throw IllegalArgumentException("Всё херня давай по новой")
    }
}