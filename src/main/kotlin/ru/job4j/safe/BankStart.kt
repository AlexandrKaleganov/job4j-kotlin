package ru.job4j.safe

import ru.job4j.safe.model.User

fun main(args: Array<String>) {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev"))
    var user = bank.findByPassport("3211")
    println(user?.name)
    user = bank.findByPassport("321")
    println(user?.name)
}