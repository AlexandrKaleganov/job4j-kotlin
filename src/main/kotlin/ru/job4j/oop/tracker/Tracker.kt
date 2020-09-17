package ru.job4j.oop.tracker

import ru.job4j.oop.tracker.model.Item
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class Tracker {
    private val items = ArrayList<Item>()

    fun addItem(item: Item): Item {
        item.setId(items.size.toString())
        items.add(item)
        return item
    }

    fun addComment(id: String, comment: String) {
        findById(id).addComment(comment)
    }

    fun findById(id: String): Item {
        return items[Integer.valueOf(id)]
    }

    fun deleteItemById(id: String): Item {
        return items.removeAt(Integer.valueOf(id))
    }

    fun findAll(): ArrayList<Item> {
        return items
    }

    fun findAllByName(name: String): List<Item> {
        return items.stream().filter { item ->
            item.getName() == name
        }.collect(Collectors.toList())
    }
}