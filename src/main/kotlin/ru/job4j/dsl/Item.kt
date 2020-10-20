package ru.job4j.dsl


data class  Item(var id: String = "", var name: String? = "") {
}

fun Item.save(): Item {
    ItemStore.addItem(this)
    return this
}
