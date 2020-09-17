package ru.job4j.oop.tracker

object StartUI {
    @JvmStatic
    fun main(args: Array<String>) {
        start()
    }
    private val menuTracker: MenuTracker = MenuTracker()
    private val tracker: Tracker = Tracker()
    private val input: Input = ConsoleInput()


    private fun start() {
        do {
            menuTracker.showMenu(System.out::println)
            menuTracker.select(input.inputCommand("Select:", menuTracker.getMenu().size - 1), input, tracker)
        } while (tracker.isExit())
    }
}