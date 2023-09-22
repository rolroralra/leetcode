private const val DIGIT = 'Z' - 'A' + 1

class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var remainNumber = columnNumber

        val list = mutableListOf<Int>()
        while (remainNumber > 0) {
            val remain = (remainNumber - 1) % DIGIT
            val quotient = (remainNumber - 1) / DIGIT

            list.add(remain + 1)

            remainNumber = quotient
        }

        return list.joinToString("") { it.toExcelChar().toString() }.reversed()
    }

    fun Int.toExcelChar(): Char {
        return ('A'.code + this - 1).toChar()
    }
}