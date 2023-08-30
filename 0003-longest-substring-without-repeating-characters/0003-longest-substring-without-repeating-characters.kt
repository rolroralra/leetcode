import java.lang.Integer.max
import java.util.*

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val queue = LinkedList<Char>()

        var result = 0

        for (index in s.indices) {
            val character = s[index]

            if (queue.contains(s[index])) {
                while (queue.isNotEmpty()) {
                    if (queue.poll() == s[index]) {
                        break
                    }
                }
            }

            queue.offer(character)
            result = max(result, queue.size)
        }
        return result
    }
}