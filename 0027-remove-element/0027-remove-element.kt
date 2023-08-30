class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val resultList = nums.filter { it != `val` }
    
        for ((i , value) in resultList.withIndex()) {
            nums[i] = value
        }

        return resultList.size
    }
}