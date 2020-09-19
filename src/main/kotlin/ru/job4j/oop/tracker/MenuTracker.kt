package ru.job4j.oop.tracker

import ru.job4j.oop.tracker.service.Dispatcher
import java.util.*
import java.util.function.Consumer

class MenuTracker {
    private val actions: ArrayList<UserAction> = ArrayList<UserAction>()

    init {
        actions.add(UserAction(id = "0", "Добавить заявку"))
        actions.add(UserAction(id = "1", "Показать все заявки"))
        actions.add(UserAction(id = "2", "Выйти"))
    }

    fun getMenu() = actions
    fun select(key: Int, input:Input, tr:Tracker) = Dispatcher.execute(key, input, tr)

    fun showMenu(out: Consumer<String>) {
        actions.forEach { e -> out.accept( e.toString() ) }
    }
}