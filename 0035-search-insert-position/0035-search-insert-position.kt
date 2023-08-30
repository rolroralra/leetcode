class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        var lowerBound = nums.size
        while(start <= end) {
            val mid = (start + end) / 2

            if (nums[mid] < target) {
                start = mid + 1
            } else {
                lowerBound = mid
                end = mid - 1
            }
        }

        return lowerBound
    }
}