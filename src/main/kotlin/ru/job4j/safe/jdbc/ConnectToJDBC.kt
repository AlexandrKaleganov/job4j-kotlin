package ru.job4j.safe.jdbc

import java.sql.Connection
import java.sql.DriverManager

class ConnectToJDBC {

    private lateinit var dispatcher: Map<String, (String) -> String>

    fun init(url: String, login: String, password: String) {

        val select = { sql: String ->
            var count = 0
            // используем use  для закрытия ресурсов fun <T : AutoCloseable?, R> T.use(block: (T) -> R)
            createConnect(url, login, password).createStatement().use { statement ->
                statement.executeQuery(sql).use { resultSet ->
                    while (resultSet.next()) {
                        count++
                    }
                }
            }
            "$count row(s) were selected"
        }

        val update = { sql: String ->
            val count = createConnect(url, login, password).createStatement().use { statement ->
                statement.executeUpdate(sql)
            }
            "$count row(s) were updated"
        }

        val delete = { sql: String ->
            val count = createConnect(url, login, password).createStatement().use { statement ->
                statement.executeUpdate(sql)
            }
            "$count row(s) were deleted"
        }

        val insert = { sql: String ->
            val count = createConnect(url, login, password).createStatement().use { statement ->
                statement.executeUpdate(sql)
            }
            "$count row(s) were inserted"
        }

        dispatcher = mapOf( "insert" to insert,  "select" to select, "update" to update,
                "delete" to delete)

    }

    private fun createConnect(url: String, login:String, password: String): Connection {
        return DriverManager.getConnection(url, login, password)
    }

    fun execute(command: String, sql: String): String {
        return dispatcher[command]?.invoke(sql) ?: ""
    }

}

fun main() {
    val dataBase = ConnectToJDBC()
    dataBase.init("jdbc:mysql://localhost:3306/kotlin_test"
                    ,"admin", "admin")
    dataBase.execute("insert", "create table if not exists entity(name varchar(50) null);")
    println(dataBase.execute("insert", "INSERT INTO entity(name) VALUES('test')"))
    println(dataBase.execute("select", "SELECT * FROM entity"))
}