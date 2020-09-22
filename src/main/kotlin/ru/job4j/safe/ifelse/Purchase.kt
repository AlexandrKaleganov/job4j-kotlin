package ru.job4j.safe.ifelse

import java.lang.StringBuilder
import java.time.LocalDate

data class Purchase(var name: String, var created: LocalDate, var address: Address? = null) {
}

fun createHtmlTablePurchase(purchases: List<Purchase>) =
        with(StringBuilder()) {
            append("<table>")
            purchases.forEach {
                append("<tr>")
                append("<td>${it.name}</td>")
                append("<td>${it.created}</td>")
                append("<td>")
                append(it.address?.toString() ?: "")
                append("</tr>")
            }
            append("</table>")
        }.toString()

fun main() {
    val purchases = listOf(
            Purchase("name1", LocalDate.of(2020, 12, 12)),
            Purchase("name1", LocalDate.of(2020, 12, 12))
                    .apply { address = Address("home", "street", "zip") },
    )
    println(createHtmlTablePurchase(purchases))
}