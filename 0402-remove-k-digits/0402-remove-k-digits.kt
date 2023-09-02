class Solution {
    fun removeKdigits(num: String, k: Int): String {
        val stack = Stack<Char>()

        var removedCount = 0
        num.toCharArray().forEach { digit ->
            while (stack.isNotEmpty() && stack.peek() > digit && removedCount < k) {
                stack.pop()
                removedCount++
            }
            stack.push(digit)
        }

        while (removedCount < k) {
            stack.pop()
            removedCount++
        }

        return stack.joinToString("").trimStart('0').ifBlank { "0" }
    }
}