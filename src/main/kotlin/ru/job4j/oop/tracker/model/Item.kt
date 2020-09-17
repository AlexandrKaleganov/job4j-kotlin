package ru.job4j.oop.tracker.model

import java.util.*

class Item {
    private var id: String? = null
    private var name: String? = null
    private var desc: String? = null
    private var created: Long = 0
    private val comments = ArrayList<String>()

    init {
        createdSet()
    }

    fun setId(id: String) {
        this.id = id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setDesc(desc: String) {
        this.desc = desc
    }

    fun getCreated(): Long {
        return created
    }

    fun getComments(): List<String> {
        return comments
    }

    fun getId(): String {
        return id.toString()
    }

    fun getName(): String {
        return name.toString()
    }

    fun getDesc(): String {
        return desc.toString()
    }

    fun addComment(comment: String) {
        comments.add(comment)
    }

    private fun createdSet() {
        this.created = System.currentTimeMillis();
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (id != other.id) return false
        if (name != other.name) return false
        if (desc != other.desc) return false
        if (created != other.created) return false
        if (comments != other.comments) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (desc?.hashCode() ?: 0)
        result = 31 * result + created.hashCode()
        result = 31 * result + comments.hashCode()
        return result
    }

    override fun toString(): String {
        return "Item(id=$id, name=$name, desc=$desc, created=$created, comments=$comments)"
    }


}