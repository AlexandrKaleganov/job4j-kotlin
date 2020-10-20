
package ru.job4j.dsl

import ru.job4j.dsl.recipient.Connector
import java.sql.ResultSet
import java.sql.Statement

object CrudService : CrudInterface {


    override fun <R> execSt(res: Statement.() -> R?): R? {
        var r: R?
        Connector.data.connection.apply {
            use {
                createStatement().apply {
                    use {
                        r = res()
                    }
                }
            }
        }
        return r;
    }

    override fun <I> execQuery(query: String, handler: ResultSet.() -> I?): I? {
        var i: I? = null
        execSt {
            executeQuery(query).use {
                while (it.next()) {
                    i = it.handler()
                }
            }

        }
        return i
    }

    override fun execUpdate(query: String, handler: ResultSet.() -> Long?): Long? {
        var res: Long? = null;
        execSt {
            executeUpdate(query, Statement.RETURN_GENERATED_KEYS)
            generatedKeys.apply {
                use {
                    while (next()) {
                        res = handler()
                    }
                }
            }
        }
        return res;
    }
}

fun CrudService.findAll(): List<Item> {
    val crud = this
    return ArrayList<Item>().apply {
        crud.execQuery("select *  from item") {
            add(Item().apply {
                id = getLong("id").toString()
                name = getString("name")
            })
        }
    }
}

fun CrudService.findById(idItem: Long): Item {
    val crud = this
    return Item().apply {
        crud.execQuery("select *  from item where $idItem") {
            id = getLong("id").toString()
            name = getString("name")
        }
    }
}

fun CrudService.create(sql: String, handler: ResultSet.() -> Long?): Long? {
    return execUpdate(sql, handler)
}

fun CrudService.create(item: Item): Item {
    val crud = this
    return Item().apply {
        id = crud.create(
                "insert into item (name) values('${item.name}')"
        ) { getLong(1) }.toString()
        name = item.name
    }
}



