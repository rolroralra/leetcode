class Solution {
    fun majorityElement(nums: IntArray): Int {
        return nums.asSequence().groupingBy { it }.eachCount().asSequence().maxByOrNull { it.value }?.key ?: 0
    }
}