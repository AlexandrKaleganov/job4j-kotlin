package ru.job4j.oop.extend

class Electrician(private var name: String = "") : Profession(name) {
    override fun getName(): String {
        println("новый функционал")
        return super.getName()
    }
}