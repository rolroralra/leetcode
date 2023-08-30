import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun maxArea(height: IntArray): Int {
        val pointers: Array<Int> = arrayOf(0, height.size - 1)

        var maxArea = 0

        for (i in 1..height.size) {
            val minHeight = min(height[pointers[0]], height[pointers[1]])

            maxArea = max(maxArea, minHeight * (pointers[1] - pointers[0]))

            if (height[pointers[0]] < height[pointers[1]]) {
                pointers[0]++
            } else {
                pointers[1]--
            }
        }

        return maxArea
    }
}