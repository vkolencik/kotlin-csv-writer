import java.io.PrintWriter
import kotlin.random.Random

fun main() {

    val family = mapOf(
        "Homer" to 35,
        "Marge" to 32,
        "Bart" to 10,
        "Lisa" to 8,
        "Maggie" to 2
    )

    PrintWriter(System.out).use {
        csv(it) {
            line {
                cell("Name")
                cell("Age")
                cell("IQ")
            }

            family.map {
                line {
                    cell(it.key)
                    cell(it.value)
                    cell(100 + 20 * (Random.nextDouble() - 0.5), 3)
                }
            }
        }
    }
}
