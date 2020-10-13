package ru.job4j.dsl


data class Item(var id: String = "", var name: String? = "") {
    private var created: Long = 0
    fun getCreated() = created
}

fun Item.save(): Item {
    ItemStore.addItem(this)
    return this
}