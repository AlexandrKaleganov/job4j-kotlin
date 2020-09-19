package ru.job4j.oop.tracker

import ru.job4j.oop.tracker.model.Item
import java.util.function.Function
import java.util.stream.Collectors
import kotlin.random.Random

class Tracker {
    private val items = ArrayList<Item>()
    private var isExit: Boolean = true
    private val rn: Random = Random(1)

    fun addItem(item: Item): Item {
        item.id = (System.currentTimeMillis() + rn.nextInt() * 100).toString()
        items.add(item)
        return item
    }

    fun isExit() = isExit
    fun exit() {
        isExit = false
    }

    fun addComment(id: String, comment: String) {
        findById(id).addComment(comment)
    }

    fun findById(id: String) = items[Integer.valueOf(id)]

    fun deleteItemById(id: String) = searchItem(id, Function { i: Int ->
        items.removeAt(i)
    })

    fun findAll(): ArrayList<Item>  = items

    fun findAllByName(name: String): MutableList<Item> = 
         items.stream().filter { item ->
            item.name == name
        }.collect(Collectors.toList())

    //метод который будет отвечать за работу функции
    private fun searchItem(sears: String, fanc: Function<Int, Item>): Item? {
        var result: Item? = null
        for (i in items.indices) {
            if (items[i].id.contains(sears)) {
                result = fanc.apply(i)
                break
            }
        }
        return result
    }
}