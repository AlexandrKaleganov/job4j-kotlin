package ru.job4j.dsl.recipient

import org.apache.commons.dbcp2.BasicDataSource
import ru.job4j.dsl.Dbcp
import java.util.*

/**
 * загрузка  BasicDataSource
 */
object Connector {
    val data: BasicDataSource by lazy { getDataConfig() }

    private fun getDataConfig(): BasicDataSource {
        return with(Properties()) {
            Connector.javaClass.classLoader.getResource("application-h2.properties")?.let {
                it.openStream()?.use { stream ->
                    load(stream)
                }
            }
            Dbcp
                    .driver(getProperty("datasource.driver"))
                    .url(getProperty("datasource.url"))
                    .login(getProperty("datasource.username"))
                    .pass(getProperty("datasource.password"))
                    .builder()
        }
    }
}
