import kotlin.math.min

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var minLength = Int.MAX_VALUE
        for (str in strs) {
            minLength = min(minLength, str.length)
        }
        
        var prefixIndex = -1
        for (i in 0 until minLength) {
            if (strs.map { it[i] }.toSet().size > 1) {
                break
            }

            prefixIndex = i
        }

        return strs.first().substring(0, prefixIndex + 1)
    }
}