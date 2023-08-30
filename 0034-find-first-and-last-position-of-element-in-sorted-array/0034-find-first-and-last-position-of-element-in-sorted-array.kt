import kotlin.math.max
import kotlin.math.min

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val answer = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
        binarySearch(nums, target, answer = answer)

        if (answer[0] == Int.MIN_VALUE || answer[1] == Int.MIN_VALUE) {
            answer[0] = -1
            answer[1] = -1
        }

        return answer
    }

    fun binarySearch(nums: IntArray, target: Int, start: Int = 0, end: Int = nums.lastIndex, answer: IntArray) {
        if (start > end) {
            return
        }

        val mid = (start + end) / 2
        if (nums[mid] == target) {
            answer[0] = min(answer[0], mid)
            answer[1] = max(answer[1], mid)

            binarySearch(nums, target, start ,mid - 1, answer)
            binarySearch(nums, target, mid + 1, end, answer)
        } else if (nums[mid] > target) {
            binarySearch(nums, target, start, mid - 1, answer)
        } else {
            binarySearch(nums, target, mid + 1, end, answer)
        }
    }
}