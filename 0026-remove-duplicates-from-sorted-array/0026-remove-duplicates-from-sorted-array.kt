class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val resultArray = nums.toSortedSet().toIntArray()

        for ((i, value) in resultArray.withIndex()) {
            nums[i] = value
        }

        return resultArray.size
    }
}