package ru.job4j.oop.tracker.service

import ru.job4j.oop.tracker.Input
import ru.job4j.oop.tracker.Tracker
import ru.job4j.oop.tracker.model.Item
import java.util.function.BiConsumer

/**
 * диспетчер команд, мапа хранит в себе 3 команды
 * 1адд итем которая принимает Item но срабатывает
 * только после вызова  inpet command которые возвращают соответствующие значения
 * так же есть команда вывести весь список
 * и команда выход из программы
 */
object Dispatcher {
    private var commandList: HashMap<Int, BiConsumer<Input, Tracker>> = HashMap()

    init {
        commandList.put(0) { input, tracker ->
            tracker.addItem(
                Item(
                    name = input.inputCommand("Пожалусто введите имя заявки"),
                    desc = input.inputCommand("Пожалусто введите описание заявки")
                )
            )
        }
        commandList.put(1) { input, tracker ->
            tracker.findAll().forEach { e -> println(e) }
        }

        commandList.put(2) { input, tracker ->
            tracker.exit()
        }

    }
    fun execute(index: Int, input: Input, tr: Tracker) {
        commandList.get(index)?.accept(input, tr)
    }
}
