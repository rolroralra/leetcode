class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexMap = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (indexMap[nums[i]] != null) {
                return intArrayOf(indexMap[nums[i]]!!, i)
            }

            indexMap[target - nums[i]] = i
        }

        return intArrayOf(-1, -1)
    }
}