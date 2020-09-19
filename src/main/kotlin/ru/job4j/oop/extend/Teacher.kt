package ru.job4j.oop.extend

class Teacher(private var name: String = "") : Profession(name) {
    override fun getName(): String {
        println("новая реализация")
        return super.getName()
    }
}