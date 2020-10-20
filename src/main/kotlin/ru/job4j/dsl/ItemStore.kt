package ru.job4j.dsl


object ItemStore : Store<Item> {
    private val items = ArrayList<Item>()

    override fun addItem(item: Item): Item {
        this.items.add(item)
        return item
    }

    fun getItems() = items
}