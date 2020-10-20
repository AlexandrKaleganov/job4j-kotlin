package ru.job4j.dsl


data class  Item(var id: String = "", var name: String? = "") {
}

fun Item.save() = ItemStore.addItem(this)
