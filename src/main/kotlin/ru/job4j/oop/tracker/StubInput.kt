package ru.job4j.oop.tracker

class StubInput(private val values:Array<String>): Input {
    var position = 0
    override fun inputCommand(command: String?) = values[position++]

    override fun inputCommand(command: String?, range: Int): Int {
        val key = Integer.valueOf(this.inputCommand(command))
        if (key in 0..2) return key else throw IllegalArgumentException("Всё херня давай по новой")
    }
}