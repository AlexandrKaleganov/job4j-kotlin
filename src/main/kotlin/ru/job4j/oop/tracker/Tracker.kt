package ru.job4j.oop.tracker

import ru.job4j.oop.tracker.model.Item
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class Tracker {
    private val items = ArrayList<Item>()
    private var isExit: Boolean = true

    fun addItem(item: Item): Item {
        item.id = items.size.toString()
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

    fun deleteItemById(id: String) = items.removeAt(Integer.valueOf(id))

    fun findAll(): ArrayList<Item>  = items

    fun findAllByName(name: String): MutableList<Item> = 
         items.stream().filter { item ->
            item.name == name
        }.collect(Collectors.toList())
}