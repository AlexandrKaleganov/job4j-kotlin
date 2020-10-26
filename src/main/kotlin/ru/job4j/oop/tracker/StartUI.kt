package ru.job4j.oop.tracker

/**
 * старт приложения
 */
class StartUI {

    companion object {
        private val menuTracker: MenuTracker = MenuTracker()
        private val tracker: Tracker = Tracker()
//        private val input1: Input = ConsoleInput()
        private val input1: Input = StubInput(arrayOf("0", "test name", "desc", "1",  "2"))

        @JvmStatic
        fun main(args: Array<String>) {
            start()
        }

        private fun start() {
            do {
                menuTracker.showMenu(System.out::println)
                menuTracker.select(input1.inputCommand("Select:", menuTracker.getMenu().size - 1), input1, tracker)
            } while (tracker.isExit())
        }
    }
}
