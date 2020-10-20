package ru.job4j.dsl

import java.sql.ResultSet
import java.sql.Statement

/**
 * интерфейс для CRUD операций
 */
interface CrudInterface {

    fun <R> execSt(res: Statement.() -> R?): R?
    fun <I> execQuery(query: String, handler: ResultSet.() -> I?): I?
    fun execUpdate(query: String, handler: ResultSet.() -> Long?): Long?
}