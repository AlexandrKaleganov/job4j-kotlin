package ru.job4j.lambda

class HtmlTable {
    fun table(row: Int, cell: Int): String {
        val table = StringBuilder()
        table.apply {
            append("<table>")
            for (r in 0 until row) {
                apply { append("<tr>")
                    for (c in 0 until cell) {
                        append("<td></td>")
                    }
                    append("</tr>")
                }
            }
            append("</table>")
        }
        return table.toString()
    }

}