package ru.job4j.safe

import java.time.LocalDate

/**
 *    other as Action  equals and hashCode
 */
class Action(var valuta: String, date: LocalDate, var name: String? = null) {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false else
        if (this === other) {
            return true
        }
        if (this.javaClass != other.javaClass) {
            return false
        }
        other as Action
        if (name != other.name) {
            return false
        }
        if (valuta != other.valuta) {
            return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = 31
        if (name != null) {
            result *= name.hashCode()
        }
        result = 31 * result + valuta.hashCode()
        return result
    }


}

fun main() {
    val act1 = Action("val", LocalDate.now(), "sa");
    val act = Action("val", LocalDate.now());
    println(act.equals(null))
}
