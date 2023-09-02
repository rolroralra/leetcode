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

        val result = StringBuilder()

        while (stack.isNotEmpty()) {
            result.insert(0, stack.pop())
        }
        
        return result.toString().trimStart('0').ifBlank { "0" }
    }
}