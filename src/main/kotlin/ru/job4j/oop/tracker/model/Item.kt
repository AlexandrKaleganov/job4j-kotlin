package ru.job4j.oop.tracker.model

import java.util.*

/**
 * клас итем для хранения в трекире
 * @sample name наименование
 * @sample created дата создания
 */
data class Item(var id: String = "", var name: String? = "", var desc: String? = "") {
    private var created: Long = 0
    private val comments = ArrayList<String>()

    init {
        this.created = System.currentTimeMillis();
    }

    fun addComment(comment: String) {
        comments.add(comment)
    }

    fun getComments() = comments
    fun getCreated() = created

}
