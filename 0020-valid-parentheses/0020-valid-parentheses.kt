import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            if (c == '(') {
                stack.push(')')
            } else if (c == '{') {
                stack.push('}')
            } else if (c == '[') {
                stack.push(']')
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false
            }
        }

        return stack.isEmpty()
    }
    
}