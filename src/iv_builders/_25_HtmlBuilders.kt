package iv_builders

import iv_builders.data.getProducts
import iv_builders.htmlLibrary.*
import util.TODO

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) %2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask25() = TODO(
    """
        Task 25.
        1) Fill the table with proper values from products.
        2) Color the table in a chess order (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can run 'Html Demo' configuration to see the rendered table
    """
)

fun renderProductTable(): String {
    return html {
        table {
            tr {
                td(color = getTitleColor()) {
                    text("Product")
                }
                td(color = getTitleColor()) {
                    text("Price")
                }
                td(color = getTitleColor()) {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for (i in 0..products.size()-1) {
                val p = products[i]
                tr {
                    td(color = getCellColor(0,i)) {
                        text(p.description)
                    }
                    td(color = getCellColor(1,i)) {
                        text(p.price)
                    }
                    td(color = getCellColor(2,i)) {
                        text(p.popularity)

                    }
                }
            }
        }
    }.toString()
}
