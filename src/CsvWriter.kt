import java.io.Writer
import java.math.RoundingMode

fun csv(output: Writer, init: CsvWriter.() -> Unit): CsvWriter {
    val csvWriter = CsvWriter(output)
    csvWriter.init()
    return csvWriter
}

class CsvWriter(private val output: Writer) {

    companion object {
        private const val lineSeparator = "\r\n"
    }

    fun line(init: Line.() -> Unit): Line {
        val line =  Line(output)
        line.init()
        output.write(lineSeparator)
        return line
    }
}

class Line(private val output: Writer) {

    companion object {
        private const val columnSeparator = ";"
        private const val textDelimiter = "\""
    }

    private var first = true

    private fun sep() {
        if (!first)
            output.write(columnSeparator)

        first = false
    }

    fun cell(value: String) {
        sep()
        output.write(textDelimiter)
        output.write(value)
        output.write(textDelimiter)
    }

    fun cell(value: Number) {
        sep()
        output.write(value.toString())
    }

    fun cell(value: Double, decimals: Int) {
        sep()
        output.write(value.toBigDecimal().setScale(decimals, RoundingMode.HALF_UP).toString())
    }
}
