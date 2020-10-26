package ru.job4j.oop.extend

/**
 * как работает наследование в котлине
 */
class Electrician(private var name: String = "") : Profession(name) {
    override fun getName(): String {
        println("новый функционал")
        return super.getName()
    }
}
