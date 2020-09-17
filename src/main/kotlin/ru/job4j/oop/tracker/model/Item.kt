package ru.job4j.oop.tracker.model

import java.util.*

data class Item(var id: String = "", var name: String? = "", var desc: String? = "") {
    private var created: Long = 0
    private val comments = ArrayList<String>()

    init {
        createdSet()
    }

    fun addComment(comment: String) {
        comments.add(comment)
    }

    fun getComments() = comments
    fun getCreated() = created


    private fun createdSet() {
        this.created = System.currentTimeMillis();
    }

}