import java.lang.StringBuilder

class Solution {
    fun countAndSay(n: Int): String {
        if (n <= 1) {
            return "1"
        }

        val sb = StringBuilder()

        var prevCharacter: Char? = null
        var count = 0

        val prevResult = countAndSay(n - 1)

        for (i in prevResult.indices) {
            if (prevCharacter != null && prevCharacter != prevResult[i]) {
                sb.append(count).append(prevCharacter)
                count = 1
            } else {
                count++
            }

            prevCharacter = prevResult[i]
        }

        sb.append(count).append(prevCharacter)

        return sb.toString()
    }
}